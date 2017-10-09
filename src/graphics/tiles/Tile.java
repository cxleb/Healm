package graphics.tiles;

import graphics.Render;
import graphics.sprites.MapedSpriteSheet;
import graphics.sprites.Sprite;

public class Tile {
	
	public final Sprite sprite;
	public final boolean isSolid;
	
	public static Tile tiles[] = {
			new Tile(MapedSpriteSheet.isheet.sprites[0], false), 
			new Tile(MapedSpriteSheet.isheet.sprites[1], false),
			new Tile(MapedSpriteSheet.isheet.sprites[2], false),
			new Tile(MapedSpriteSheet.isheet.sprites[3], false),
			new Tile(MapedSpriteSheet.isheet.sprites[4], true),
			new Tile(MapedSpriteSheet.isheet.sprites[5], true),
			new Tile(MapedSpriteSheet.isheet.sprites[6], false),
			new Tile(MapedSpriteSheet.isheet.sprites[7], false),
			new Tile(MapedSpriteSheet.isheet.sprites[8], false),
			new Tile(MapedSpriteSheet.isheet.sprites[9], false),
			new Tile(MapedSpriteSheet.isheet.sprites[10], false),
			new Tile(MapedSpriteSheet.isheet.sprites[11], true),
			new Tile(MapedSpriteSheet.isheet.sprites[12], true),
			new Tile(MapedSpriteSheet.isheet.sprites[13], true),
			new Tile(MapedSpriteSheet.isheet.sprites[14], false),
			new Tile(MapedSpriteSheet.isheet.sprites[15], false),
			new Tile(MapedSpriteSheet.isheet.sprites[16], false),
			new Tile(MapedSpriteSheet.isheet.sprites[17], true),
			new Tile(MapedSpriteSheet.isheet.sprites[18], true),
			new Tile(MapedSpriteSheet.isheet.sprites[19], true),
			new Tile(MapedSpriteSheet.isheet.sprites[20], true),
			new Tile(MapedSpriteSheet.isheet.sprites[21], true),
			new Tile(MapedSpriteSheet.isheet.sprites[22], true),
			new Tile(MapedSpriteSheet.isheet.sprites[23], true),
			new Tile(MapedSpriteSheet.isheet.sprites[24], true),
			new Tile(MapedSpriteSheet.isheet.sprites[25], true),
			new Tile(MapedSpriteSheet.isheet.sprites[26], true),
			new Tile(MapedSpriteSheet.isheet.sprites[27], true),
			new Tile(MapedSpriteSheet.isheet.sprites[28], false),
			new Tile(MapedSpriteSheet.isheet.sprites[29], true),
			new Tile(MapedSpriteSheet.isheet.sprites[30], false),
			new Tile(MapedSpriteSheet.isheet.sprites[31], false),
			new Tile(MapedSpriteSheet.isheet.sprites[32], false),
			new Tile(MapedSpriteSheet.isheet.sprites[33], false),
			new Tile(MapedSpriteSheet.isheet.sprites[34], false),
			new Tile(MapedSpriteSheet.isheet.sprites[35], false),
			new Tile(MapedSpriteSheet.isheet.sprites[36], false),
			new Tile(MapedSpriteSheet.isheet.sprites[37], true),
			new Tile(MapedSpriteSheet.isheet.sprites[38], false),
			new Tile(MapedSpriteSheet.isheet.sprites[39], false),
			new Tile(MapedSpriteSheet.isheet.sprites[40], false),
			new Tile(MapedSpriteSheet.isheet.sprites[41], false),
			new Tile(MapedSpriteSheet.isheet.sprites[42], true),
			new Tile(MapedSpriteSheet.isheet.sprites[43], true),
			new Tile(MapedSpriteSheet.isheet.sprites[44], false)
			
					
	}; 
	
	public Tile(Sprite sp, boolean solid){
		sprite = sp;
		isSolid = solid;
	}
	
	public void render(Render render, int x, int y){
		render.renderOffsetSprite(this.sprite, x, y);
	}

}
