package items;

import entities.PlayerProfile;
import graphics.sprites.Sprite;

public class HealthPotion extends Item{

	public static Sprite potion = new Sprite(Item.itemSheet, 8, 0, 0);
	
	public HealthPotion() {
		super(potion, "Health Potion", "Heals 4 Hearts");
	}
	
	protected void itemAction(){
		if (PlayerProfile.profile.health > 12){
			PlayerProfile.profile.health = 20;
			
		}else{
			PlayerProfile.profile.health += 8;
		}
	}

}
