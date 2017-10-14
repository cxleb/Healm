package GUI;

import java.awt.event.KeyEvent;

import entities.PlayerProfile;
import graphics.Render;
import graphics.font.Font;
import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;
import input.Keyboard;

public class GUI {
	
	public static final Spritesheet heartSpriteSheet = new Spritesheet("res/spritesheets/heart.png", 16);
	public static final Sprite heart = new Sprite(heartSpriteSheet, 16, 0, 0);
	public static final Spritesheet halfheartSpriteSheet = new Spritesheet("res/spritesheets/halfheart.png", 16);
	public static final Sprite halfheart = new Sprite(halfheartSpriteSheet, 16, 0, 0);
	public static final Spritesheet blankheartSpriteSheet = new Spritesheet("res/spritesheets/blankheart.png", 16);
	public static final Sprite blankheart = new Sprite(blankheartSpriteSheet, 16, 0, 0);
	
	int healthx = 341;
	int healthy = 2;
	
	public GUI(){
		
	}
	
	boolean old1 = false;
	
	public void update(int delta) {
		if (old1 && !Keyboard.k1){
			if(PlayerProfile.profile.items.items[0] != null){
				PlayerProfile.profile.items.useItem(0);
				
			}
		}
		old1 = Keyboard.k1;
	}

	
	public void render(int delta, Render render) {
		for (int i = 0; i < 10; i++){
			render.renderSprite(blankheart, healthx + i * 18, healthy);
			
		}
		for (int i = 1; i < PlayerProfile.profile.health; i++){
			if(i % 2 == 1){
				render.renderSprite(heart, healthx + (i / 2) * 18, healthy);
			}else{
				render.renderSprite(halfheart, healthx + (i / 2) * 18, healthy);
			}
		}
		
		Font.Arial8White.renderFont(render, "" + PlayerProfile.profile.getLvl(), 103, 0);
		
		int c = PlayerProfile.profile.getCurXpLevel();
		int n = PlayerProfile.profile.getNextXpLevel() - c;
		int x = PlayerProfile.profile.xp - c;
		double w = (double) x / n * 100;
		render.renderRect(3, 3, 100, 5, 0x007700, false);
		render.renderRect(3, 3, (int)w, 5, 0x00FF00, false);
		
		for (int i = 0; i < PlayerProfile.profile.items.items.length; i++){
			if (PlayerProfile.profile.items.items[i] != null){
				render.renderSprite(PlayerProfile.profile.items.items[i].sprite, 5, 10 + i * 10);
				Font.Arial8White.renderFont(render, PlayerProfile.profile.items.items[i].name + " QTY: " + PlayerProfile.profile.items.items[i].quantity, 15, 10 + i * 10);
			}
		}
	}
	
}
