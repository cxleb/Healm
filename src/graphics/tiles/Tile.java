package graphics.tiles;

import graphics.Render;
import graphics.sprites.Sprite;

public class Tile {
	
	public final Sprite sprite;
	public final boolean isSolid;
	
	public Tile(Sprite sp, boolean solid){
		sprite = sp;
		isSolid = solid;
	}
	
	public void render(Render render, int x, int y){
		render.renderOffsetSprite(this.sprite, x, y);
	}

}
