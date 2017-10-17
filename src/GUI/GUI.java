package GUI;

import java.awt.event.KeyEvent;

import entities.EntityManager;
import entities.PlayerProfile;
import graphics.Render;
import graphics.font.Font;
import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;
import input.Keyboard;
import input.Mouse;

public class GUI {
	
	public static final Spritesheet heartSpriteSheet = new Spritesheet("res/spritesheets/heart.png", 16);
	public static final Sprite heart = new Sprite(heartSpriteSheet, 16, 0, 0);
	public static final Spritesheet halfheartSpriteSheet = new Spritesheet("res/spritesheets/halfheart.png", 16);
	public static final Sprite halfheart = new Sprite(halfheartSpriteSheet, 16, 0, 0);
	public static final Spritesheet blankheartSpriteSheet = new Spritesheet("res/spritesheets/blankheart.png", 16);
	public static final Sprite blankheart = new Sprite(blankheartSpriteSheet, 16, 0, 0);
	public static final Spritesheet smallinvSpriteSheet = new Spritesheet("res/spritesheets/smallinv.png", 16);
	public static final Sprite inv = new Sprite(smallinvSpriteSheet, 16, 0, 0);
	public static final Spritesheet biginvSpriteSheet = new Spritesheet("res/spritesheets/biginv.png", 16);
	public static final Sprite biginv = Sprite.rescale(inv, 3);
	public static final Sprite smallinv = Sprite.rescale(inv, 2);
	
	
	int healthx = 341;
	int healthy = 2;
	
	boolean o1 = false, o2 = false, o3 = false, o4 = false, o5 = false, o6 = false;
	boolean or = false, ol = false;
	
	public GUI(){
		
	}
	
	public void update(int delta, EntityManager manager) {
		if (!Keyboard.keys[KeyEvent.VK_1] && o1){
			if(PlayerProfile.profile.items.items[2] != null){
				PlayerProfile.profile.items.useItem(2, manager);
				
			}
		}
		if (!Keyboard.keys[KeyEvent.VK_2] && o2){
			if(PlayerProfile.profile.items.items[3] != null){
				PlayerProfile.profile.items.useItem(3, manager);
				
			}
		}
		if (!Keyboard.keys[KeyEvent.VK_3] && o3){
			if(PlayerProfile.profile.items.items[4] != null){
				PlayerProfile.profile.items.useItem(4, manager);
				
			}
		}
		if (!Keyboard.keys[KeyEvent.VK_4] && o4){
			if(PlayerProfile.profile.items.items[5] != null){
				PlayerProfile.profile.items.useItem(5, manager);
				
			}
		}
		if (!Keyboard.keys[KeyEvent.VK_5] && o5){
			if(PlayerProfile.profile.items.items[6] != null){
				PlayerProfile.profile.items.useItem(6, manager);
				
			}
		}
		if (!Keyboard.keys[KeyEvent.VK_6] && o6){
			if(PlayerProfile.profile.items.items[7] != null){
				PlayerProfile.profile.items.useItem(7, manager);
				
			}
		}
		
		if (!Mouse.leftClicked && ol){
			if(PlayerProfile.profile.items.items[0] != null){
				PlayerProfile.profile.items.useItem(0, manager);
				
			}
		}
		if (!Mouse.rightClicked && or){
			if(PlayerProfile.profile.items.items[1] != null){
				PlayerProfile.profile.items.useItem(1, manager);
				
			}
		}

		
		
		o1 = Keyboard.keys[KeyEvent.VK_1];
		o2 = Keyboard.keys[KeyEvent.VK_2];
		o3 = Keyboard.keys[KeyEvent.VK_3];
		o4 = Keyboard.keys[KeyEvent.VK_4];
		o5 = Keyboard.keys[KeyEvent.VK_5];
		o6 = Keyboard.keys[KeyEvent.VK_6];
		or = Mouse.rightClicked;
		ol = Mouse.leftClicked;
	}

	
	public void render(int delta, Render render) {
		for (int i = 0; i < 10; i++){
			render.renderSprite(blankheart, healthx + i * 18, healthy);
		}
		
		render.renderSprite(smallinv, 130, 250);
		render.renderSprite(smallinv, 162, 250);
		render.renderSprite(smallinv, 194, 250);
		render.renderSprite(biginv, 221, 236);
		render.renderSprite(biginv, 261, 236);
		render.renderSprite(smallinv, 305, 250);
		render.renderSprite(smallinv, 337, 250);
		render.renderSprite(smallinv, 369, 250);
		
		if( PlayerProfile.profile.items.items[0] == null) Font.Arial8White.renderFont(render, "L", 241 , 254);
		if( PlayerProfile.profile.items.items[1] == null) Font.Arial8White.renderFont(render, "R", 281 , 254);
		
		if( PlayerProfile.profile.items.items[2] == null) Font.Arial8White.renderFont(render, "1", 141 , 261);
		if( PlayerProfile.profile.items.items[3] == null) Font.Arial8White.renderFont(render, "2", 173 , 261);
		if( PlayerProfile.profile.items.items[4] == null) Font.Arial8White.renderFont(render, "3", 205 , 261);
		
		if( PlayerProfile.profile.items.items[5] == null) Font.Arial8White.renderFont(render, "4", 316 , 261);
		if( PlayerProfile.profile.items.items[6] == null) Font.Arial8White.renderFont(render, "5", 348 , 261);
		if( PlayerProfile.profile.items.items[7] == null) Font.Arial8White.renderFont(render, "6", 380 , 261);
		
		if( PlayerProfile.profile.items.items[0] != null) { 
			render.renderSprite(Sprite.rescale(PlayerProfile.profile.items.items[0].sprite, 3), 233, 248);
			Font.Arial8White.renderFont(render, "" + PlayerProfile.profile.items.items[0].quantity, 251 , 264);
		}
		if( PlayerProfile.profile.items.items[1] != null) { 
			render.renderSprite(Sprite.rescale(PlayerProfile.profile.items.items[1].sprite, 3), 273, 248); 
			Font.Arial8White.renderFont(render, "" + PlayerProfile.profile.items.items[1].quantity, 291 , 264);
		}
		
		if( PlayerProfile.profile.items.items[2] != null) { 
			render.renderSprite(Sprite.rescale(PlayerProfile.profile.items.items[2].sprite, 2), 138, 258); 
			Font.Arial8White.renderFont(render, "" + PlayerProfile.profile.items.items[2].quantity, 147 , 267);
		}
		if( PlayerProfile.profile.items.items[3] != null) { 
			render.renderSprite(Sprite.rescale(PlayerProfile.profile.items.items[3].sprite, 2), 170, 258); 
			Font.Arial8White.renderFont(render, "" + PlayerProfile.profile.items.items[3].quantity, 179 , 267);
		}
		if( PlayerProfile.profile.items.items[4] != null) { 
			render.renderSprite(Sprite.rescale(PlayerProfile.profile.items.items[4].sprite, 2), 202, 258); 
			Font.Arial8White.renderFont(render, "" + PlayerProfile.profile.items.items[4].quantity, 212 , 267);
		}
		
		if( PlayerProfile.profile.items.items[5] != null) { 
			render.renderSprite(Sprite.rescale(PlayerProfile.profile.items.items[5].sprite, 2), 313, 258); 
			Font.Arial8White.renderFont(render, "" + PlayerProfile.profile.items.items[5].quantity, 324 , 267);
		}
		if( PlayerProfile.profile.items.items[6] != null) { 
			render.renderSprite(Sprite.rescale(PlayerProfile.profile.items.items[6].sprite, 2), 337+8, 258); 
			Font.Arial8White.renderFont(render, "" + PlayerProfile.profile.items.items[6].quantity, 355 , 267);
		}
		if( PlayerProfile.profile.items.items[7] != null) { 
			render.renderSprite(Sprite.rescale(PlayerProfile.profile.items.items[7].sprite, 2), 369+8, 258); 
			Font.Arial8White.renderFont(render, "" + PlayerProfile.profile.items.items[7].quantity, 387 , 267);
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
		
		//for (int i = 0; i < PlayerProfile.profile.items.items.length; i++){
		///	if (PlayerProfile.profile.items.items[i] != null){
		//		render.renderSprite(PlayerProfile.profile.items.items[i].sprite, 5, 10 + i * 10);
		//		Font.Arial8White.renderFont(render, PlayerProfile.profile.items.items[i].name + " QTY: " + PlayerProfile.profile.items.items[i].quantity, 15, 10 + i * 10);
		//	}
		//}
		
		
	}
	
}
