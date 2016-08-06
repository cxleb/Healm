package graphics.tiles;

import graphics.Render;
import graphics.sprites.Sprite;

public class Tile {
	
	public final Sprite sprite;
	public final boolean isSolid;
	
	public static Tile grass = new Tile(Sprite.grass, false);
	public static Tile stone = new Tile(Sprite.stone, true);
	public static Tile rock = new Tile(Sprite.rock, true);
	public static Tile wood = new Tile(Sprite.wood, false);
	
	public static Tile water = new Tile(Sprite.water, false);
	public static Tile watertop = new Tile(Sprite.watertop, true);
	public static Tile waterbottom = new Tile(Sprite.waterbottom , true);
	public static Tile waterleft = new Tile(Sprite.waterleft, true);
	public static Tile waterright = new Tile(Sprite.waterright, true);
	public static Tile watertopleft = new Tile(Sprite.watertopleft, true);
	public static Tile watertopright = new Tile(Sprite.watertopright, true);
	public static Tile waterbotleft = new Tile(Sprite.waterbotleft, true);
	public static Tile waterbotright = new Tile(Sprite.waterbotright, true);
	public static Tile waterstatic = new Tile(Sprite.waterstatic, true);
	
	public static Tile spawn = new Tile(Sprite.spawn, false);
	
	
	public Tile(Sprite sp, boolean solid){
		sprite = sp;
		isSolid = solid;
	}
	
	public void render(Render render, int x, int y){
		render.renderTile(this, x, y);
	}

}
