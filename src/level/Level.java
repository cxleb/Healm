package level;

import java.util.Random;

import GUI.GUI;
import entities.EntityManager;
import entities.Player;
import entities.lighting.LightMap;
import entities.tile.Chest;
import entities.tile.Spike;
import entities.tile.Teleporter;
import game.Game;
import graphics.Render;
import graphics.map.Map;

public class Level {
	
	public Map map;
	public LightMap lightMap;
	public Player player;
	public GUI gui;
	
	public EntityManager manager;
	public Random random;
	int counter;
	
	public Level(){
		
		
	}
	
	public void setupLevel(){
		lightMap = new LightMap();
		player = new Player(map.GetSpawnX() - (Game.Width/2-8), map.GetSpawnY() - (Game.Height/2-8), 16);
		manager = new EntityManager();
		random = new Random(System.currentTimeMillis());
		gui = new GUI();
		
		manager.addEntity(player);
		
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
		
		int id = 0;
		for(int y = 0; y < map.Height; y++){
			for(int x = 0; x < map.Width; x++){
				int tileID = map.tiles[x + y * map.Width];
				if(tileID == 45){
					manager.addEntity(new Teleporter(x * 16, y * 16, id++));
				}
			}
		}
	}
	
	public void update(int delta){
		//player.update(delta, map, manager);
		manager.updateMobs(delta, map, manager);
		gui.update(delta, manager);
	}
	
	public void render(Render render, int delta){
		map.render(render);
		//player.render(delta, render);
		lightMap.renderLightMap(render);
		manager.renderMobs(delta, render);
		gui.render(delta, render);
	}
	
	protected void levelTeleport(int id){
		
	}
	
	public void teleport(int id){
		levelTeleport(id);
	}

}
