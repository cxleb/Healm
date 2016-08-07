package graphics.sprites;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private Spritesheet sheet;
	
	public static Sprite grass = new Sprite(Spritesheet.mainSpriteSheet, 16, 0, 0);
	public static Sprite rock = new Sprite(Spritesheet.mainSpriteSheet, 16, 1, 0);
	public static Sprite stone = new Sprite(Spritesheet.mainSpriteSheet, 16, 2, 0);
	public static Sprite wood = new Sprite(Spritesheet.mainSpriteSheet, 16, 0, 1);
	
	public static Sprite water = new Sprite(Spritesheet.mainSpriteSheet, 16, 4, 1);
	public static Sprite watertop = new Sprite(Spritesheet.mainSpriteSheet, 16, 4, 0);
	public static Sprite waterbottom = new Sprite(Spritesheet.mainSpriteSheet, 16, 4, 2);
	public static Sprite waterleft = new Sprite(Spritesheet.mainSpriteSheet, 16, 3, 1);
	public static Sprite waterright = new Sprite(Spritesheet.mainSpriteSheet, 16, 5, 1);
	public static Sprite watertopleft = new Sprite(Spritesheet.mainSpriteSheet, 16, 3, 0);
	public static Sprite watertopright = new Sprite(Spritesheet.mainSpriteSheet, 16, 5, 0);
	public static Sprite waterbotleft = new Sprite(Spritesheet.mainSpriteSheet, 16, 3, 2);
	public static Sprite waterbotright = new Sprite(Spritesheet.mainSpriteSheet, 16, 5, 2);
	public static Sprite waterstatic = new Sprite(Spritesheet.mainSpriteSheet, 16, 6, 0);
	
	public static Sprite spawn = new Sprite(Spritesheet.mainSpriteSheet, 16, 1, 1);
	
	public static Sprite manleft_0 = new Sprite(Spritesheet.mainSpriteSheet, 16, 0, 15);
	public static Sprite manleft_1 = new Sprite(Spritesheet.mainSpriteSheet, 16, 1, 15);
	public static Sprite manleft_2 = new Sprite(Spritesheet.mainSpriteSheet, 16, 2, 15);
	
	public static Sprite manright_0 = new Sprite(Spritesheet.mainSpriteSheet, 16, 0, 14);
	public static Sprite manright_1 = new Sprite(Spritesheet.mainSpriteSheet, 16, 1, 14);
	public static Sprite manright_2 = new Sprite(Spritesheet.mainSpriteSheet, 16, 2, 14);
	
	public static Sprite spawner_1 = new Sprite(Spritesheet.mainSpriteSheet, 16, 2, 1);
	
	public static Sprite bullet_1 = new Sprite(Spritesheet.bulletSpriteSheet, 8, 0, 0);
	
	public Sprite(Spritesheet sheet, int size, int x, int y){
		SIZE = size;
		this.sheet = sheet;
		this.x = x * size;
		this.y = y * size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load(){
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}

}
