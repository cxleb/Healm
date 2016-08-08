package entities.particle;

import entities.Entity;
import graphics.Render;
import graphics.map.Map;
import math.HealmMaths;

public class Particle extends Entity{
	private double dX;
	private double dY;
	private double xDir;
	private double yDir;
	private int fade;
	private int life;
	private int originalLife;
	public boolean isDead;
	
	
	
	public Particle(int x, int y, double xDir, double yDir, int life) {
		super(x, y);
		this.xDir = xDir;
		this.yDir = yDir;
		this.dX = x;
		this.dY = y;
		this.life = life;
		this.originalLife = life;
		this.fade = 0xff;
	}
	
	public void entityRender(int delta, Render render){
		if(!isDead){
			render.renderParticle((int)dX, (int)dY, fade);
		}
		
	}
	
	public void entityUpdate(int delta, Map map){
		if(map.getTileAt( ((int)dX)/16 , ((int)dY)/16).isSolid){
			isDead = true;
		}
		if(!isDead){
			dX += xDir;
			dY += yDir;
			life -= delta;
			fade -= HealmMaths.timesProtectedI(delta, originalLife - life);
			if(fade < 0)
				fade = 0;
			if(life <= 0){
				isDead = true;
			}
		}
		
	}
	
	
	
	
	
}
