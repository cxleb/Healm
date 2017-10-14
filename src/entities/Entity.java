package entities;

import java.util.ArrayList;
import java.util.List;

import entities.components.EntityComponent;
import graphics.Render;
import graphics.map.Map;

public class Entity{

	private List<EntityComponent> components;
	
	protected int x = 0;
	protected int y = 0;
	public int health = 1;
	protected int dmg = 0;
	protected boolean takeDmg = false;
	
	
	
	public Entity(int x, int y) {
		components = new ArrayList<EntityComponent>();
		this.x = x;
		this.y = y;
	}
	
	public Entity(int x, int y, int health, int dmg, boolean takeDmg) {
		components = new ArrayList<EntityComponent>();
		this.x = x;
		this.y = y;
		this.health = health;
		this.dmg = dmg;
		this.takeDmg = takeDmg;
	}

	public final void addComponent(EntityComponent component){
		components.add(component);
	}

	public final void update(int delta, Map map, EntityManager manager) {
		for(EntityComponent component:components){
			component.update(this, delta, map);
		}
		entityUpdate(delta, map, manager);
	}

	public  final void render(int delta, Render render) {
		for(EntityComponent component:components){
			component.render(this, x, y, delta, render);
		}
		entityRender(delta, render);
		
		//render.renderOffsetSprite(MapedSpriteSheet.isheet.sprites[0], x, y);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public boolean isTakeDmg() {
		return takeDmg;
	}

	public void setHasLoot(boolean takeDmg) {
		this.takeDmg = takeDmg;
	}

	public final int getX() {
		return x;
	}

	public final int getY() {
		return y;
	}

	public final void setX(int x) {
		this.x = x;
	}

	public final void setY(int y) {
		this.y = y;
	}

	public final void increasePosition(int dx, int dy){
		y += dy;
		x += dx;
	}
	
	public final List<EntityComponent> getComponents() {
		return components;
	}
	
	public void entityRender(int delta, Render render){}
	
	public void entityUpdate(int delta, Map map, EntityManager manager){}
	
	public void entityCollide(int delta, Map map, EntityManager manager, Entity collided){}

}
