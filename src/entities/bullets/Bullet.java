package entities.bullets;

import entities.Entity;
import graphics.Render;
import graphics.map.Map;
import graphics.sprites.Sprite;

public class Bullet extends Entity{

	public double dX;
	public double dY;
	private double xDir;
	private double yDir;
	public boolean isDead;
	private double speed;
	
	public Bullet(int x, int y, double xdir, double ydir, double speed) {
		super(x, y);
		this.dX = x;
		this.dY = y;
		this.xDir = xdir;
		this.yDir = ydir;
		this.speed = speed;
	}
	
	public void entityRender(int delta, Render render){
		if(!isDead){
			render.renderOffsetSprite(Sprite.bullet_1, (int)dX, (int)dY);
		}
	}
	
	public void entityUpdate(int delta, Map map){
		if(map.getTileAt( ((int)dX)/16 , ((int)dY)/16).isSolid){
			isDead = true;
		}
		if(map.getTileAt( ((int)dX+9)/16 , ((int)dY)/16).isSolid){
			isDead = true;
		}
		if(map.getTileAt( ((int)dX)/16 , ((int)dY+9)/16).isSolid){
			isDead = true;
		}
		if(map.getTileAt( ((int)dX+9)/16 , ((int)dY+9)/16).isSolid){
			isDead = true;
		}
		if(!isDead){
			dX += xDir*speed;
			dY += yDir*speed;
		}
	}

}
