package entities.bullets;

import entities.Entity;
import entities.EntityManager;
import entities.components.RenderComponent;
import graphics.Render;
import graphics.map.Map;
import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;

public class Bullet extends Entity{
	
	public static final Spritesheet bulletSpriteSheet = new Spritesheet("res/spritesheets/bullet.png", 8);
	public static final Sprite bullet_1 = new Sprite(bulletSpriteSheet, 8, 0, 0);
	
	public double dX;
	public double dY;
	private double xDir;
	private double yDir;
	public boolean isDead;
	private double speed;
	public int time = 600;
	RenderComponent render;
	
	public Bullet(int x, int y, double xdir, double ydir, double speed, int dmg, Sprite sprite) {
		super(x, y);
		this.dX = x;
		this.dY = y;
		this.xDir = xdir;
		this.yDir = ydir;
		this.speed = speed;
		this.dmg = dmg;
		render = new RenderComponent(sprite, true);
		
		addComponent(render);
	}
	
	public void entityRender(int delta, Render render){
	}
	
	public void entityUpdate(int delta, Map map, EntityManager manager){
		if(map.getTileAt( ((int)dX)/16 , ((int)dY)/16).isSolid){
			this.health = 0;
		}
		if(map.getTileAt( ((int)dX + 8 )/16 , ((int)dY + 8)/16).isSolid){
			this.health = 0;
		}
		if(this.health != 0){
			dX += xDir*speed;
			dY += yDir*speed;
		}
		if(time != 0){
			time--;
		}else{
			this.health = 0;
		}
		
		this.x = (int) dX;
		this.y = (int) dY;

	}

}
