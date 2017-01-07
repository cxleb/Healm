package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.mobs.Poo;
import entities.mobs.Unicorn;
import entities.particle.ParticleSpawner;
import graphics.Render;
import graphics.map.Map;

public class EntityManager {
	
	//// TODO: ENTITY MANAGER
	//1, check for collision and remove or add health
	// ~ 2, check for 0 health, if so remove
	
	public List<Entity> entities;
	ParticleSpawner spawner;
	Random random;
	
	public EntityManager(){
		entities = new ArrayList<Entity>();
		spawner = new ParticleSpawner(0, 0);
		random = new Random(System.currentTimeMillis());
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
	}
	
	public void updateMobs(int delta, Map map, EntityManager manager){
		for(Entity entity:entities){
			entity.update(delta, map, manager);	
		}
		
		for(int i = 0; i < entities.size(); i++){
			if(entities.get(i).health <= 0){
				spawner.setX((int)entities.get(i).getX());
				spawner.setY((int)entities.get(i).getY());
				if(entities.get(i) instanceof Unicorn){
					spawner.addParticles(50, 50, 0, true);
				}else if(entities.get(i) instanceof Poo){
					spawner.addParticles(50, 50, 0xF99661f, false);
				}else if(entities.get(i).isTakeDmg()){
					spawner.addParticles(50, 50, 0xffffff, false);
					
				}
				entities.remove(i);
			}
		}
		
		for(Entity entity1:entities){
			for(Entity entity2:entities){
				if(!entity2.getClass().equals(entity1.getClass())){
					if(entity2.getX() > entity1.getX() && entity2.getX() < entity1.getX() + 16){
						if(entity2.getY() > entity1.getY() && entity2.getY() < entity1.getY() + 16){
							entity1.setHealth(entity1.getHealth() - entity2.getDmg());
						
						}
					}
				}
			}
		}
		
		spawner.update(delta, map, manager);
		
	}
	
	public void renderMobs(int delta, Render render){
		for(Entity entity:entities){
			entity.render(delta, render);	
		}
		spawner.render(delta, render);
	}

}
