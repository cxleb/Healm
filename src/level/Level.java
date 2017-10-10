package level;

import java.util.Random;

import entities.EntityManager;
import entities.Player;
import entities.lighting.LightMap;
import entities.mobs.Poo;
import entities.mobs.Unicorn;
import entities.tile.Chest;
import entities.tile.Spike;
import game.Game;
import graphics.Render;
import graphics.map.Map;

public class Level {
	
	private Map map;
	private LightMap lightMap;
	public Player player;
	
	EntityManager manager;
	Random random;
	int counter;
	
	public Level(String mapPath, String sheetPath, int sheetSize, int spriteSize){
		
		map = new Map(mapPath);
		
		lightMap = new LightMap();
		player = new Player(map.GetSpawnX() - (Game.Width/2-8), map.GetSpawnY() - (Game.Height/2-8), 16);
		manager = new EntityManager();
		random = new Random(System.currentTimeMillis());
		
		manager.addEntity(player);
		
		for(int i = 0; i < 20; i++){
			manager.addEntityRandomly(new Unicorn(0,0), map);
		}
		
		for(int i = 0; i < 20; i++){
			manager.addEntityRandomly(new Poo(0,0), map);
		}
		
		for(int y = 0; y < map.Height; y++){
			for(int x = 0; x < map.Width; x++){
				int tileID = map.tiles[x + y * map.Width];
				if(tileID == 25 || tileID == 43){
					manager.addEntity(new Chest(x * 16, y * 16));
				}
			}
		}
		
		for(int y = 0; y < map.Height; y++){
			for(int x = 0; x < map.Width; x++){
				int tileID = map.tiles[x + y * map.Width];
				if(tileID == 44){
					manager.addEntity(new Spike(x * 16, y * 16));
				}
			}
		}
	}
	
	public void update(int delta){
		//player.update(delta, map, manager);
		manager.updateMobs(delta, map, manager);
	}
	
	public void render(Render render, int delta){
		map.render(render);
		//player.render(delta, render);
		lightMap.renderLightMap(render);
		manager.renderMobs(delta, render);
	}

}
