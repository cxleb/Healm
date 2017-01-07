package graphics.sprites;

public class MapedSpriteSheet {
	
	public int spriteSize;
	public int sheetBound;
	Spritesheet sheet;
	public Sprite sprites[];
	
	public MapedSpriteSheet(String sheetName, int sheetSize,int spriteSize){
		
		sheet = new Spritesheet(sheetName, sheetSize);
		
		this.spriteSize = spriteSize;
		this.sheetBound = sheet.getBound(spriteSize);
		sprites = new Sprite[sheetBound * sheetBound];
		load();
	}
	
	private void load(){
		for(int y = 0; y < sheetBound; y++){
			for(int x = 0; x < sheetBound; x++){
				sprites[x + y * sheetBound] = new Sprite(sheet, spriteSize, x, y);
			}
		}
	}

}
