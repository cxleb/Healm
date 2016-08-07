package level;

import java.util.ArrayList;
import java.util.List;

import entities.Entity;
import entities.Player;
import entities.lighting.LightMap;
import game.Game;
import graphics.Render;
import graphics.map.Map;

public class Level {
	
	private Map map;
	private LightMap lightMap;
	public Player player;
	private List<Entity> entities;
	
	public Level(String mapPath){
		map = new Map(mapPath);
		lightMap = new LightMap();
		player = new Player(map.getSpawnX() - (Game.Width/2-8), map.getSpawnY() - (Game.Height/2-8));
		entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
	}
	
	public void update(int delta){
		player.update(delta, map);
		for(Entity entity:entities){
			entity.update(delta, map);
		}
	}
	
	public void render(Render render, int delta){
		map.render(render);
		player.render(delta, render);
		lightMap.renderLightMap(render);
		for(Entity entity:entities){
			entity.render(delta, render);
		}
	}

}
