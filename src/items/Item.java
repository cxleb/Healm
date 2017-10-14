package items;

import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;

public class Item {
	
	public static Spritesheet itemSheet = new Spritesheet("res/spritesheets/items.png", 64);
	
	public Sprite sprite;
	public String name;
	public String description;
	public int quantity = 1;
	
	public Item(Sprite sprite, String name, String description) {
		this.sprite = sprite;
		this.name = name;
		this.description = description;
	}
	
	public void completeItemAction(){
		itemAction();
	}
	
	protected void itemAction(){
		
	}
}
