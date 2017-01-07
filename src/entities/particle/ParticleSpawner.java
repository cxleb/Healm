package entities.particle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Entity;
import entities.EntityManager;
import graphics.Render;
import graphics.map.Map;

public class ParticleSpawner extends Entity{

	List<Particle> particles;
	Random random;
	
	public ParticleSpawner(int x, int y) {
		super(x, y);
		particles = new ArrayList<Particle>();
		random = new Random();
	}
	
	public void addParticles(int amount, int life, int colour, boolean randomColour){
		for(int i = 0; i < amount; i++){
			if(randomColour){
				particles.add(new Particle(7+x, 7+y, random.nextGaussian(), random.nextGaussian(), life, random.nextInt()));
			}else{
				particles.add(new Particle(7+x, 7+y, random.nextGaussian(), random.nextGaussian(), life, colour));
			}
		}
	}
	
	public void entityRender(int delta, Render render){
		for(Particle particle:particles){
			particle.render(delta, render);
		}
	}
	
	public void entityUpdate(int delta, Map map, EntityManager manager){
		for(Particle particle:particles){
			particle.update(delta, map, manager);	
		}
		
		for(int i = 0; i < particles.size(); i++){
			if(particles.get(i).isDead){
				particles.remove(i);
			}
		}
		
	}

}
