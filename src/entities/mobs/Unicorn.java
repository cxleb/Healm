package entities.mobs;

import entities.Entity;
import entities.EntityManager;
import entities.bullets.Bullet;
import entities.components.AnimationComponent;
import entities.components.RandomMovementComponent;
import graphics.map.Map;
import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;

public class Unicorn extends Entity{
	
	private AnimationComponent leftAnim;
	private AnimationComponent rightAnim;
	
	public static final Spritesheet unicorn_sprites = new Spritesheet("res/spritesheets/unicorn_spritesheet.png", 32);
	
	public static final Sprite left_0 = new Sprite(unicorn_sprites, 16, 0, 1);
	public static final Sprite left_1 = new Sprite(unicorn_sprites, 16, 1, 1);
	
	public static final Sprite right_0 = new Sprite(unicorn_sprites, 16, 0, 0);
	public static final Sprite right_1 = new Sprite(unicorn_sprites, 16, 1, 0);
	
	
	private boolean animateY 	= false;
	private boolean animate		= true;
	private boolean side		= true;
	
	RandomMovementComponent move;

	public Unicorn(int x, int y) {
		super(x, y, 10, 0, false);
		
		leftAnim = new AnimationComponent(true);
		rightAnim = new AnimationComponent(true);
		leftAnim.printFirstFrame = false;
		
		leftAnim.add(left_0);
		leftAnim.add(left_1);
		
		rightAnim.add(right_0);
		rightAnim.add(right_1);
		
		
		move = new RandomMovementComponent();
		
		addComponent(rightAnim);
		addComponent(leftAnim);
		addComponent(move);
		
	}
	
    public void entityUpdate(int delta, Map map, EntityManager manager){
		
		
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
		
		if(move.dirX){
			if(move.canMoveRight){
				side = true;
				if(move.spdX > 0){
					animate = true;
				}else{
					animate = false;
				}
			}
		}else{
			if(move.canMoveLeft){
				side = false;
				if(move.spdX > 0){
					animate = true;
			    }else{
					animate = false;
				}
			}
		}
		
		if(move.dirY){
			if(move.canMoveDown){
				if(move.spdY > 0){
					animateY = true;
				}else{
					animateY = false;
				}
			}
		}else{
			if(move.canMoveUp){
				if(move.spdY > 0){
					animateY = true;
				}else{
					animateY = false;
				}
			}
		}
		
	}
    
    public void entityCollide(int delta, Map map, EntityManager manager, Entity collided)
	{
		if (collided instanceof Bullet){
			this.health -= collided.getDmg();
			collided.health = 0;
		}
	}
}
