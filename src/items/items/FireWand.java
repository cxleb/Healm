package items.items;

import entities.EntityManager;
import entities.bullets.RedOrbBullet;
import game.Game;
import graphics.sprites.Sprite;
import input.Mouse;
import items.Item;
import main.Main;

public class FireWand extends Item{

	public static Sprite wand = new Sprite(Item.itemSheet, 8, 4, 0);
	
	public FireWand() {
		super(wand, "Basic Wand", "10 Damage", Item.ItemQuality.Uncommon);
		this.usuable = false;
	}
	
	protected void itemAction(EntityManager manager){
		double bx = Mouse.x - Game.Width/2;
		double by = Mouse.y - Game.Height/2;
		double dir = Math.atan2(by, bx);
		by = Math.sin(dir)*1;
		bx = Math.cos(dir)*1;
		manager.addEntity(new RedOrbBullet(Main.game.currentLevel.player.getX() + 4, Main.game.currentLevel.player.getY() + 4, bx, by));
	}
	
}
