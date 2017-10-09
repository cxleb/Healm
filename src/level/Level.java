package level;

import java.util.Random;

import entities.EntityManager;
import entities.Player;
import entities.lighting.LightMap;
import entities.mobs.Poo;
import entities.mobs.Unicorn;
import game.Game;
import graphics.Render;
import graphics.map.Map;
import graphics.tiles.MapedTiles;

public class Level {
	
	private Map map;
	private LightMap lightMap;
	public Player player;
	
	EntityManager manager;
	Random random;
	int counter;
	
	public Level(String mapPath, String sheetPath, int sheetSize, int spriteSize){
		
		MapedTiles tiles = new MapedTiles(sheetPath, sheetSize, spriteSize);
		map = new Map(mapPath);
		map.giveTiles(tiles);
		
		lightMap = new LightMap();
		player = new Player(map.GetSpawnX() - (Game.Width/2-8), map.GetSpawnY() - (Game.Height/2-8), 16);
		manager = new EntityManager();
		random = new Random(System.currentTimeMillis());
		
		for(int i = 0; i < 20; i++){
			manager.addEntityRandomly(new Unicorn(0,0), map);
		}
		
		for(int i = 0; i < 20; i++){
			manager.addEntityRandomly(new Poo(0,0), map);
		}
	}
	
	public void update(int delta){
		player.update(delta, map, manager);
		manager.updateMobs(delta, map, manager);
	}
	
	public void render(Render render, int delta){
		map.render(render);
		player.render(delta, render);
		lightMap.renderLightMap(render);
		manager.renderMobs(delta, render);
	}

}
