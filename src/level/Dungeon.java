package level;

import java.util.Random;

import entities.mobs.Poo;
import entities.mobs.Unicorn;
import graphics.map.Map;
import main.Main;

public class Dungeon extends Level{

	public Dungeon() {
		super();
		
		refreshDungeon();
		
		setupLevel();
		
		for(int i = 0; i < 20; i++){
			manager.addEntityRandomly(new Unicorn(0,0), map);
		}
		
		for(int i = 0; i < 20; i++){
			manager.addEntityRandomly(new Poo(0,0), map);
		}
	}
	
	public void refreshDungeon(){
		Random random = new Random(System.currentTimeMillis());
		
		int mapno = random.nextInt(2);
		
		this.map = new Map("res/maps/dungeon"+mapno+".csv");
	}
	
	protected void levelTeleport(int id){
		if(id == 0){
			Main.game.currentLevel = new Lobby();
		}
	}

}
