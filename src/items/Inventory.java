package items;

public class Inventory {
	
	public Item[] items;
	
	public Inventory(){
		items = new Item[8];
	}
	
	public void useItem(int index){
		if(items[index].quantity >= 1 ){
			items[index].completeItemAction();
			items[index].quantity--;
		}
		
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
