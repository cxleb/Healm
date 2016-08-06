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
	
	
	public Entity(int x, int y) {
		components = new ArrayList<EntityComponent>();
		this.x = x;
		this.y = y;
	}
	
	public final void addComponent(EntityComponent component){
		System.out.println("Adding Component: " + component.componentName);
		components.add(component);
	}

	public final void update(int delta, Map map) {
		for(EntityComponent component:components){
			component.update(this, delta);
		}
		entityUpdate(delta, map);
	}

	public  final void render(int delta, Render render) {
		for(EntityComponent component:components){
			component.render(this, x, y, delta, render);
		}
		entityRender(delta, render);
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
	
	public void entityUpdate(int delta, Map map){}

}
