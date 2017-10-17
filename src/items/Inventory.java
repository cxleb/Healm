package items;

import entities.EntityManager;
import items.items.BasicWand;
import items.items.HealthPotion;
import items.items.Sling;

public class Inventory {
	
	public Item[] items;
	
	public Inventory(){
		items = new Item[8];
		
		items[2] = new HealthPotion();
		items[2].quantity = 2;
		items[0] = new BasicWand();
	}
	
	public void useItem(int index, EntityManager manager){
		if(items[index].quantity >= 1 ){
			items[index].completeItemAction(manager);
		}
		
		if (items[index].usuable) items[index].quantity--;
		
		if(items[index].quantity < 1){
			items[index] = null;
		}
	}
	
	public boolean addItem(Item item){
		int freeSlot = 9;
		
		for(int i = 0; i < items.length; i++){
			if(items[i] == null){
				freeSlot = i;
				break;
			}
		}
		
		for(int i = 0; i < items.length; i++){
			if(items[i] != null){
				if(items[i].getClass() == item.getClass()){
					items[i].quantity++;
					return true;
				}
			}
		}
		
		if(freeSlot == 9){
			return false;
		}
		
		items[freeSlot] = item;
		
		return true;
	}

}
