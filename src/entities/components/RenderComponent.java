package entities.components;

import entities.Entity;
import graphics.Render;
import graphics.map.Map;
import graphics.sprites.Sprite;

public class RenderComponent extends EntityComponent{

	public Sprite sprite;
	private boolean setOffset;
	
	public RenderComponent(Sprite sprite, boolean setOffset) {
		super("Render Component");
		this.sprite = sprite; 
		this.setOffset = setOffset;
	}
	
	public void update(Entity entity, int delta, Map map) {	}

	public void render(Entity entity, int x, int y, int delta, Render render) {
		if(setOffset)
			render.renderOffsetSprite(sprite, x, y);	
		else
			render.renderSprite(sprite, x, y);
	}

}
