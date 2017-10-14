package entities;

import java.util.ArrayList;

import items.Inventory;
import items.Item;

public class PlayerProfile {
	
	public static PlayerProfile profile = new PlayerProfile();
	
	public int health;
	public int xp;
	public Inventory items;
	
	public PlayerProfile(){
		health = 20;
		xp = 0;
		items = new Inventory();
	}
	
	public int getLvl(){
		return (int) Math.sqrt(xp * 0.02);
	}
	
	public int getCurXpLevel(){
		return (int) (getLvl() * getLvl() / 0.02) ;
	}
	
	public int getNextXpLevel(){
		int nxtlvl = getLvl() + 1;
		return (int) (nxtlvl * nxtlvl / 0.02) ;
	}
}
