package entities.particle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Entity;
import entities.components.RenderComponent;
import graphics.Render;
import graphics.map.Map;
import graphics.sprites.Sprite;

public class ParticleSpawner extends Entity{

	List<Particle> particles;
	private int timer = 0;
	private int pps;
	Random random;
	
	public ParticleSpawner(int x, int y, int pps) {
		super(x, y);
		particles = new ArrayList<Particle>();
		addComponent(new RenderComponent(Sprite.spawner_1, true));
		random = new Random();
		this.pps = pps;
	}
	
	public void entityRender(int delta, Render render){
		for(Particle particle:particles){
			particle.render(delta, render);
		}
	}
	
	public void entityUpdate(int delta, Map map){
		for(Particle particle:particles){
			particle.update(delta, map);	
		}
		
		timer += delta;
		if(timer > 60){
			timer = 0;
			for(int i = 0; i < pps; i++){
				particles.add(new Particle(7+x, 7+y, random.nextGaussian(), random.nextGaussian(), 100));
			}
		}
		
		for(int i = 0; i < particles.size(); i++){
			if(particles.get(i).isDead){
				particles.remove(i);
			}
		}
		
	}

}
