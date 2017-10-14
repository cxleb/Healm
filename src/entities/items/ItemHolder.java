package entities.items;

import entities.Entity;
import entities.EntityManager;
import entities.Player;
import entities.PlayerProfile;
import entities.components.RenderComponent;
import graphics.map.Map;
import items.Item;
import main.Main;

public class ItemHolder extends Entity{

	RenderComponent render;
	Item item;
	
	public ItemHolder(int x, int y, Item item) {
		super(x, y);
		this.item = item;
		
		render = new RenderComponent(item.sprite, true);
		
		addComponent(render);
	}
	
	public void entityUpdate(int delta, Map map, EntityManager manager){
		int px = Main.game.currentLevel.player.getX() - 16;
		int py = Main.game.currentLevel.player.getY() - 16;
		
		if (x > px && x < px + 48 && y > py && y < py + 48){
			System.out.println("Item Collected!");
			if (PlayerProfile.profile.items.addItem(item)){
				this.health = 0;
			}
		}
	}
}
