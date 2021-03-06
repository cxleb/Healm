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
	
	public void addEntityRandomly(Entity entity, Map map){
		boolean placed = false;
		while(!placed){
			int newX = random.nextInt(map.Height*16);
			int newY = random.nextInt(map.Height*16);
			if(!map.getTileAt((newX + 8) / 16, (newY + 8) / 16).isSolid){
				entity.setX(newX);
				entity.setY(newY);
				entities.add(entity);
				placed = true;
			}
		}
	}
	
	public void updateMobs(int delta, Map map, EntityManager manager){
		//for(Entity entity:entities){
		//	entity.update(delta, map, manager);	
		//}
		
		for(int i = 0; i < entities.size(); i++){
			Entity clazz = entities.get(i);
			clazz.update(delta, map, manager);
		}
		
		for(int i = 0; i < entities.size(); i++){
			if(entities.get(i).health <= 0){
				spawner.setX((int)entities.get(i).getX());
				spawner.setY((int)entities.get(i).getY());
				if(entities.get(i) instanceof Unicorn){
					spawner.addParticles(50, 50, 0, true);
					PlayerProfile.profile.xp += 10;
				}else if(entities.get(i) instanceof Poo){
					spawner.addParticles(50, 50, 0xF99661f, false);
					PlayerProfile.profile.xp += 10;
				}else if(entities.get(i).isTakeDmg()){
					spawner.addParticles(50, 50, 0xffffff, false);
				}
				entities.remove(i);
			}
		}
		
		for(int i = 0; i < entities.size(); i++){
			Entity entity1 = entities.get(i);
			for(int z = 0; z < entities.size(); z++){
				Entity entity2 = entities.get(z);
				if(!entity2.getClass().equals(entity1.getClass())){
					int x1 = entity1.getX();
					int y1 = entity1.getY();
					int x2 = entity2.getX();
					int y2 = entity2.getY();
					if(x2 > x1 && x2 < x1 + 16 && y2 > y1 && y2 < y1 + 16 ){
						entity1.entityCollide(delta, map, manager, entity2);
					}
					if(x2 + 16 > x1 && x2 + 16  < x1 + 16 && y2 > y1 && y2  < y1 + 16){
						entity1.entityCollide(delta, map, manager, entity2);	
					}
					if(x2 > x1 && x2 < x1 + 16 && y2 + 16 > y1 && y2 + 16 < y1 + 16){
						entity1.entityCollide(delta, map, manager, entity2);
					}
				}
			}
		}
		
		spawner.update(delta, map, manager);
		
	}
	
	public void renderMobs(int delta, Render render){
		//for(Entity entity:entities){
		//	entity.render(delta, render);	
		//}
		for(int i = 0; i < entities.size(); i++){
			Entity clazz = entities.get(i);
			clazz.render(delta, render);
		}
		spawner.render(delta, render);
	}

}
