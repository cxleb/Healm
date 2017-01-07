package graphics.tiles;

import graphics.sprites.MapedSpriteSheet;
import graphics.sprites.SolidMap;

public class MapedTiles {
	
	MapedSpriteSheet sheet;
	SolidMap solids;
	public Tile tiles[];
	
	public MapedTiles(String sheetname, int sheetSize, int SpriteSize){
		sheet = new MapedSpriteSheet(sheetname+".png", sheetSize, SpriteSize);
		solids = new SolidMap(sheetname+"_solidmap.csv");
		tiles = new Tile[sheet.sheetBound * sheet.sheetBound];
		
		if(solids.solids.length != tiles.length){
			try {
				throw new Exception("Not Equal Map Sizes");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
		load();
		}
	}
	
	private void load(){
		for(int y = 0; y < sheet.sheetBound; y++){
			for(int x = 0; x < sheet.sheetBound; x++){
				tiles[x + y * sheet.sheetBound] = new Tile(sheet.sprites[x + y * sheet.sheetBound], solids.solids[x + y * sheet.sheetBound]);
			}
		}
	}
}
