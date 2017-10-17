package entities.tile;

import entities.Entity;
import entities.EntityManager;
import entities.PlayerProfile;
import entities.bullets.Bullet;
import entities.items.ItemHolder;
import graphics.map.Map;
import items.Item;
import items.ItemGenerator;
import items.items.HealthPotion;

public class Chest extends Entity{

	boolean opened = false;
	
	public Chest(int x, int y) {
		super(x, y);
		
	}
	
	public void entityCollide(int delta, Map map, EntityManager manager, Entity collided)
	{
		if (collided instanceof Bullet && !opened){
			int tx = this.getX() / 16;
			int ty = this.getY() / 16;
			int idloc = tx + ty * map.Width;
			if(map.tiles[idloc] == 25){
				map.tiles[idloc] = 26;
				PlayerProfile.profile.xp += 50;
			}
			if(map.tiles[idloc] == 43){
				map.tiles[idloc] = 42;
				PlayerProfile.profile.xp += 50;
			}
			
			manager.addEntity(new ItemHolder(x, y, ItemGenerator.generateRandomItem()));
			opened = true;
		}
	}

	

}
