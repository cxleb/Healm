package items.items;

import entities.EntityManager;
import entities.bullets.FireBullet;
import game.Game;
import graphics.sprites.Sprite;
import input.Mouse;
import items.Item;
import main.Main;

public class BasicWand extends Item{

	public static Sprite wand = new Sprite(Item.itemSheet, 8, 3, 0);
	
	public BasicWand() {
		super(wand, "Basic Wand", "10 Damage", Item.ItemQuality.Common);
		this.usuable = false;
	}
	
	protected void itemAction(EntityManager manager){
		double bx = Mouse.x - Game.Width/2;
		double by = Mouse.y - Game.Height/2;
		double dir = Math.atan2(by, bx);
		by = Math.sin(dir)*1;
		bx = Math.cos(dir)*1;
		manager.addEntity(new FireBullet(Main.game.currentLevel.player.getX() + 4, Main.game.currentLevel.player.getY() + 4, bx, by));
	}
	
}
