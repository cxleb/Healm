package level;

import graphics.map.Map;
import main.Main;

public class Lobby extends Level{

	public Lobby() {
		super();
		
		this.map = new Map("res/maps/lobby.csv");
		
		setupLevel();
		
	}
	
	protected void levelTeleport(int id){
		if(id == 0){
			Main.game.currentLevel = new Dungeon();
		}
	}

}
