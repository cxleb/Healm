package graphics.sprites;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	
	public Sprite(Spritesheet sheet, int size, int x, int y){
		SIZE = size;
		this.x = x * size;
		this.y = y * size;
		pixels = new int[SIZE * SIZE];
		load(sheet);
	}
	
	public Sprite(int size){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
	}
	
	private void load(Spritesheet sheet){
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				
				pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}
	
	public static Sprite rescale(Sprite sprite, int scale){
		Sprite scaled = new Sprite(sprite.SIZE*scale);
		
		for(int y = 0; y < scaled.SIZE; y++){
			for(int x = 0; x < scaled.SIZE; x++){
				scaled.pixels[x + y * scaled.SIZE] = sprite.pixels[(x/scale) + (y/scale) * sprite.SIZE];
			}
		}
		
		return scaled;
	}

}
