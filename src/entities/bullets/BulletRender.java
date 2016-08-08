package entities.bullets;

import java.util.ArrayList;
import java.util.List;

import entities.Entity;
import entities.particle.ParticleSpawner;
import graphics.Render;
import graphics.map.Map;

public class BulletRender extends Entity{

	List<Bullet> bullets;
	private int bullet_speed;
	
	ParticleSpawner spawner;
	
	public BulletRender(int x, int y, int bullet_speed) {
		super(x, y);
		bullets = new ArrayList<Bullet>();
		this.bullet_speed = bullet_speed;
		spawner = new ParticleSpawner(x, y, false);
	}
	
	public void addBullet(int xb, int yb, double xd, double yd){
		bullets.add(new Bullet(xb, yb, xd, yd, bullet_speed));
	}
	
	public void entityRender(int delta, Render render){
		for(Bullet bullet:bullets){
			bullet.render(delta, render);
		}
		spawner.render(delta, render);
	}
	
	public void entityUpdate(int delta, Map map){
		for(Bullet bullet:bullets){
			bullet.update(delta, map);	
		}
		
		for(int i = 0; i < bullets.size(); i++){
			if(bullets.get(i).isDead){
				spawner.setX((int)bullets.get(i).dX);
				spawner.setY((int)bullets.get(i).dY);
				spawner.addParticles(20, 20);
				bullets.remove(i);
			}
		}
		
		spawner.update(delta, map);
		
	}
	
	

}
