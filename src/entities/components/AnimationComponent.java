package entities.components;

import java.util.ArrayList;
import java.util.List;

import entities.Entity;
import graphics.Render;
import graphics.map.Map;
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
	private int frames = 0;
	
	public AnimationComponent(boolean setOffset) {
		super("Animation Component");
		this.sprites = new ArrayList<Sprite>();
		this.setOffset = setOffset;
	}
	
	public void add(Sprite sprite){
		sprites.add(sprite);
		frames++;
		frameMax = frames - 1;
		fps = 60/frames;
	
	}

	public void update(Entity entity, int delta, Map map) {
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
