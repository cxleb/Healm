package entities.tile;

import entities.Entity;
import entities.EntityManager;
import entities.PlayerProfile;
import entities.bullets.Bullet;
import graphics.map.Map;

public class Chest extends Entity{

	public Chest(int x, int y) {
		super(x, y);
		
	}
	
	public void entityCollide(int delta, Map map, EntityManager manager, Entity collided)
	{
		if (collided instanceof Bullet){
			int tx = this.getX() / 16;
			int ty = this.getY() / 16;
			int idloc = tx + ty * map.Width;
			if(map.tiles[idloc] == 25){
				map.tiles[idloc] = 26;
				PlayerProfile.profile.score += 50;
			}
			if(map.tiles[idloc] == 43){
				map.tiles[idloc] = 42;
				PlayerProfile.profile.score += 50;
			}
			
			
		}
	}

	

}
