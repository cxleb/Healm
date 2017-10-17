package items;

import java.util.Random;

import items.items.BasicWand;
import items.items.FireWand;
import items.items.HealthPotion;
import items.items.Sling;

public class ItemGenerator {
	
	public static Item generateRandomItem(){
		Random random = new Random(System.currentTimeMillis());
		int item = random.nextInt(101);
		
		if(item > 0 && item < 60){
			switch(random.nextInt(1)){
			case 0:
				return new HealthPotion();
			}
			return new HealthPotion();	
		}
		
		if(item > 61 && item < 90){
			switch(random.nextInt(3)){
			case 0:
				return new FireWand();
			case 1:
				return new BasicWand();	
			case 2:
				return new Sling();		
			}
			return new FireWand();
		}
		
		if(item > 91 && item < 100){
			
		}
		
		return new HealthPotion();
	}

}
