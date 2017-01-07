package entities.components;

import java.util.Random;

import entities.Entity;
import graphics.Render;
import graphics.map.Map;

public class RandomMovementComponent extends EntityComponent{
	
	public Random random;
	public int nextX = 0;
	public int nextY = 0;
	public int spdX = 1;
	public int spdY = 1;
	public boolean dirX;
	public boolean dirY;
	public boolean canMoveUp;
	public boolean canMoveDown;
	public boolean canMoveRight;
	public boolean canMoveLeft;

	public RandomMovementComponent() {
		super("Random Movement Component");
		random = new Random(System.nanoTime());
	}

	public void update(Entity entity, int delta, Map map) {
		if(map.getTileAt( entity.getX() / 16 , (entity.getY() - 8) / 16).isSolid || entity.getY() < 0 ){
			canMoveUp = false;
			dirY = true;
		} else {
			canMoveUp = true;
		}
		
		if(map.getTileAt( entity.getX()/ 16 , (entity.getY() + 8) / 16).isSolid || entity.getY() > map.Height*16){
			canMoveDown = false;
			dirY = false;
		} else {
			canMoveDown = true;
		}
		
		if(map.getTileAt( (entity.getX()+ 8)/ 16, entity.getY()/ 16).isSolid || entity.getX() > map.Width*16){
			canMoveRight = false;
			dirX = false;
		} else {
			canMoveRight = true;
		}
		
		if(map.getTileAt( (entity.getX()-8)/ 16, entity.getY() / 16).isSolid || entity.getX() < 0){
			canMoveLeft = false;
			dirX = true;
		} else {
			canMoveLeft = true;
		}
		
		
		if(dirX){
			if(canMoveRight){
				entity.setX(entity.getX() + spdX);
			}
		}else{
			if(canMoveLeft){
				entity.setX(entity.getX() - spdX);
			}
		}
		
		if(dirY){
			if(canMoveDown){
				entity.setY(entity.getY() + spdY);
			}
		}else{
			if(canMoveUp){
				entity.setY(entity.getY() - spdY);
			}
		}
		
		if(nextX == 0){
			nextX = random.nextInt(241) + 60;
			spdX = random.nextInt(2);
			dirX = random.nextBoolean();
		}else{
			nextX--;
		}
		
		if(nextY == 0){
			nextY = random.nextInt(100) + 6;
			spdY = random.nextInt(2);
			dirY = random.nextBoolean();
		}else{
			nextY--;
		}
		
	}

	public void render(Entity entity, int x, int y, int delta, Render render) {
	}

}
