package entities.components;

import java.util.List;

import entities.Entity;
import graphics.Render;
import graphics.sprites.Sprite;

public class AnimationComponent extends EntityComponent{
	
	private List<Sprite> sprites;
	public boolean triggered = false;
	public boolean printFirstFrame = true;
	private boolean setOffset;
	
	
	private int curFrame = 0;
	private int frameMax = 0;
	private int timer = 0;
	private int fps = 0;
	
	public AnimationComponent(List<Sprite> sprites, int fps, boolean setOffset) {
		super("Animation Component");
		this.sprites = sprites;
		frameMax = sprites.size() - 1;
		this.fps = 60/fps;
		this.setOffset = setOffset;
	}

	public void update(Entity entity, int delta) {
		if (timer > fps){
			timer = 0;
			curFrame++;
		}
		
		if(curFrame > frameMax){
			curFrame = 0;
		}
		
		timer += delta;
	
	}

	public void render(Entity entity, int x, int y, int delta, Render render) {
		if(triggered){
			if(setOffset)
				render.renderOffsetSprite(sprites.get(curFrame), x, y);	
			else
				render.renderSprite(sprites.get(curFrame), x, y);	
		}else if (printFirstFrame){
			if(setOffset)
				render.renderOffsetSprite(sprites.get(0), x, y);	
			else
				render.renderSprite(sprites.get(0), x, y);	
		}
	}

}
