package entities.mobs;

import entities.Entity;
import entities.EntityManager;
import entities.PlayerProfile;
import entities.bullets.Bullet;
import entities.components.AnimationComponent;
import entities.components.RandomMovementComponent;
import graphics.font.Font;
import graphics.map.Map;
import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;

public class Poo extends Entity{

	public Spritesheet poo_sprites = new Spritesheet("res/spritesheets/poo_spritesheet.png", 64);
	
	public Sprite frame_0 = new Sprite(poo_sprites, 16, 0, 0);
	public Sprite frame_1 = new Sprite(poo_sprites, 16, 1, 0);
	public Sprite frame_2 = new Sprite(poo_sprites, 16, 2, 0);
	public Sprite frame_3 = new Sprite(poo_sprites, 16, 3, 0);
	
	RandomMovementComponent movement;
	AnimationComponent animation;
	
	public Poo(int x, int y) {
		super(x, y, 20, 0, true);
		
		animation = new AnimationComponent(true);
		animation.printFirstFrame = true;
		animation.add(frame_0);
		animation.add(frame_1);
		animation.add(frame_2);
		animation.add(frame_3);
		
		movement = new RandomMovementComponent();
		
		addComponent(animation);
		addComponent(movement);
		
	}
	
	public void entityUpdate(int delta, Map map, EntityManager manager){
		if(movement.spdX > 0 || movement.spdY > 0){
			animation.triggered = true;
		}else{
			animation.triggered = true;
		}
	}
	
	public void entityCollide(int delta, Map map, EntityManager manager, Entity collided)
	{
		if (collided instanceof Bullet){
			this.health = 0;
			PlayerProfile.profile.score += 10;
			
		}
	}

}
