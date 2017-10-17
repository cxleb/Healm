package items.items;

import entities.EntityManager;
import entities.PlayerProfile;
import graphics.sprites.Sprite;
import items.Item;

public class HealthPotion extends Item{

	public static Sprite potion = new Sprite(Item.itemSheet, 8, 0, 0);
	
	public HealthPotion() {
		super(potion, "Health Potion", "Heals 4 Hearts", Item.ItemQuality.Common);
	}
	
	protected void itemAction(EntityManager manager){
		if (PlayerProfile.profile.health > 12){
			PlayerProfile.profile.health = 20;
			
		}else{
			PlayerProfile.profile.health += 8;
		}
	}

}
