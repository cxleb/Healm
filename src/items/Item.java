package items;

import java.util.Random;

import entities.EntityManager;
import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;
import items.items.BasicWand;
import items.items.FireWand;
import items.items.HealthPotion;

public class Item {
	
	public static enum ItemQuality{
		Common,
		Uncommon,
		Rare,
		Legendary
		
	}
	
	public static Spritesheet itemSheet = new Spritesheet("res/spritesheets/items.png", 64);
	
	
	public Sprite sprite;
	public String name;
	public String description;
	public int quantity = 1;
	public boolean usuable = true;
	public ItemQuality quality;
	
	public Item(Sprite sprite, String name, String description, ItemQuality quality) {
		this.sprite = sprite;
		this.name = name;
		this.description = description;
		this.quality = quality;
	}
	
	public void completeItemAction(EntityManager manager){
		itemAction(manager);
	}
	
	protected void itemAction(EntityManager manager){
		
	}
}
