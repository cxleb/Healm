package entities;

import entities.bullets.Bullet;
import entities.components.AnimationComponent;
import entities.mobs.Poo;
import entities.tile.Spike;
import game.Game;
import graphics.Render;
import graphics.font.Font;
import graphics.map.Map;
import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;
import input.Keyboard;
import input.Mouse;

public class Player extends Entity{

	public int playerX = 0;
	public int playerY = 0;
	public int playerSpriteSize = 0;
	
	public int speed = 2;
	
	public int hitTimer = 0;
	
	public boolean canMoveUp = true;
	public boolean canMoveDown = true;
	public boolean canMoveLeft = true;
	public boolean canMoveRight = true;
	public boolean side = true; // right = true, left = false
	public boolean animate;
	public boolean animateY;
	
	private AnimationComponent leftAnim;
	private AnimationComponent rightAnim;
	
	int timer = 0;
	int fireRate = 5;
	
	public Spritesheet player_sprites = new Spritesheet("res/spritesheets/player_spritesheet.png", 48);
	
	public Sprite manleft_0 = new Sprite(player_sprites, 16, 0, 1);
	public Sprite manleft_1 = new Sprite(player_sprites, 16, 1, 1);
	public Sprite manleft_2 = new Sprite(player_sprites, 16, 2, 1);
	
	public Sprite manright_0 = new Sprite(player_sprites, 16, 0, 0);
	public Sprite manright_1 = new Sprite(player_sprites, 16, 1, 0);
	public Sprite manright_2 = new Sprite(player_sprites, 16, 2, 0);
	
	
	
	public Player(int x, int y, int Size) {
		super(Game.Width/2-8, Game.Height/2-8);
		playerX = x;
		playerY = y;
		playerSpriteSize = Size;
		
		leftAnim = new AnimationComponent(false);
		rightAnim = new AnimationComponent(false);
		leftAnim.printFirstFrame = false;
		
		leftAnim.add(manleft_0);
		leftAnim.add(manleft_1);
		leftAnim.add(manleft_0);
		leftAnim.add(manleft_2);
		
		rightAnim.add(manright_0);
		rightAnim.add(manright_1);
		rightAnim.add(manright_0);
		rightAnim.add(manright_2);
		
		//addComponent(rightAnim);
		//addComponent(leftAnim);
		
	}
	
	public void entityUpdate(int delta, Map map, EntityManager manager){
		
		// moving and animation
		if(map.getTileAt( (playerX + (Game.Width/2)) / 16 , (playerY + (Game.Height/2 - 8 )) / 16).isSolid){
			canMoveUp = false;
		} else {
			canMoveUp = true;
		}
		
		if(map.getTileAt( (playerX + (Game.Width/2)) / 16 , (playerY + (Game.Height/2 + 8 )) / 16).isSolid){
			canMoveDown = false;
		} else {
			canMoveDown = true;
		}
		
		if(map.getTileAt( (playerX + (Game.Width/2 + 8 )) / 16 , (playerY + (Game.Height/2)) / 16).isSolid){
			canMoveRight = false;
		} else {
			canMoveRight = true;
		}
		
		if(map.getTileAt( (playerX + (Game.Width/2 - 8 )) / 16 , (playerY + (Game.Height/2)) / 16).isSolid){
			canMoveLeft = false;
		} else {
			canMoveLeft = true;
		}
		
		
		if(side){
			leftAnim.printFirstFrame = false;
			rightAnim.printFirstFrame = true;
			if(animateY || animate){
				leftAnim.triggered = false;
				rightAnim.triggered = true;
			}else{
				leftAnim.triggered = false;
				rightAnim.triggered = false;
			}
		}else{
			leftAnim.printFirstFrame = true;
			rightAnim.printFirstFrame = false;
			if(animateY || animate){
				leftAnim.triggered = true;
				rightAnim.triggered = false;
			}else{
				leftAnim.triggered = false;
				rightAnim.triggered = false;
			}
		}
	
		if(Keyboard.up && canMoveUp) {
			playerY -= speed;
			animateY = true;
		} else if(Keyboard.down && canMoveDown){
			playerY += speed;
			animateY = true;
		} else {
			animateY = false;
		}
		if(Keyboard.right && canMoveRight){
			side = true;
			animate = true;
			playerX += speed;
		} else if(Keyboard.left && canMoveLeft) {
			side = false;
			animate = true;
			playerX -= speed;
		} else {
			animate = false;
		}
		
		if(Keyboard.p){
			speed = 10;
		}else{
			speed = 2;
		}
		
		
		// shooting
		if(Mouse.clicked && timer <= 0){
			double bx = Mouse.x - Game.Width/2;
			double by = Mouse.y - Game.Height/2;
			double dir = Math.atan2(by, bx);
			by = Math.sin(dir)*1;
			bx = Math.cos(dir)*1;
			//bullets.addBullet(playerX+(Game.Width/2-4), playerY+(Game.Height/2-4), bx, by);
			manager.addEntity(new Bullet(playerX+(Game.Width/2-4), playerY+(Game.Height/2-4), bx, by, 4, 10));
			timer = fireRate;
		}
		if(timer > 0)
			timer--;
		
		leftAnim.update(this, delta, map);
		rightAnim.update(this, delta, map);
		
		setX(playerX + Game.Width/2-8);
		setY(playerY + Game.Height/2-8);
		
		if(hitTimer > 0)
			hitTimer--;
	}
	
	public void entityRender(int delta, Render render){
		
		Font.Arial8White.renderFont(render, "HEALTH: " + PlayerProfile.profile.health, 0, 0);
		Font.Arial8White.renderFont(render, "SCORE: " + PlayerProfile.profile.score, 0, 10);
		
		
		leftAnim.render(this, Game.Width/2-8, Game.Height/2-8, delta, render);
		rightAnim.render(this, Game.Width/2-8, Game.Height/2-8, delta, render);
		
	}
	public void entityCollide(int delta, Map map, EntityManager manager, Entity collided){
		if (hitTimer <= 0){
			if (collided instanceof Poo){
				PlayerProfile.profile.health -= 5;
				hitTimer += 60;
			}
			if (collided instanceof Spike){
				PlayerProfile.profile.health -= 5;
				hitTimer += 60;
			}
		}
	}

}
