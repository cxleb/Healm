package entities.components;

import entities.Entity;
import graphics.Render;
import graphics.map.Map;

public abstract class EntityComponent {
	
	public String componentName = "";
	
	public EntityComponent(String name){
		this.componentName = name;
	}
	
	public abstract void update(Entity entity, int delta, Map map);
	public abstract void render(Entity entity, int x, int y, int delta, Render render);

}
