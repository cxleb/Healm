package graphics;

import graphics.sprites.Sprite;
import graphics.tiles.Tile;

public class Render {
	//private int Width;
	//private int Height;
	//public int[] pixels;
	
	public Screen screen;
	
	public int xOffset = 0, yOffset = 0;

	public Render(int width, int height){
		//this.Width = width;
		//this.Height = height;
		//pixels = new int[width * height];
		
		screen = new Screen(width, height);
	}
	
	public void clear(){
		for(int i = 0; i < screen.pixels.length; i++){
			screen.pixels[i] = 0;
		}
	}
	
	public void renderTile(Tile tile, int xp, int yp){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.sprite.SIZE; y++){
			int ya = yp + y;
			for(int x = 0; x < tile.sprite.SIZE; x++){
				int xa = xp + x;
				if(ya < 0 || ya >= screen.Height || xa < -16 || xa >= screen.Width) break;
				if(xa < 0) xa = 0;
				screen.pixels[xa + ya * screen.Width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
	
	public void renderSprite(Sprite sprite, int xp, int yp, boolean setOffset){
		if(setOffset){
			xp -= xOffset;
			yp -= yOffset;
		}
		for(int y = 0; y < sprite.SIZE; y++){
			int ya = yp + y;
			for(int x = 0; x < sprite.SIZE; x++){
				int xa = xp + x;
				if(ya < 0 || ya >= screen.Height || xa < -sprite.SIZE || xa >= screen.Width) break;
				if(xa < 0) xa = 0;
				if(sprite.pixels[x + y * sprite.SIZE]  != -65281){
					screen.pixels[xa + ya * screen.Width] = sprite.pixels[x + y * sprite.SIZE];
				}
			}
		}
		
	}
	
	public void renderParticle(int xp, int yp, int colour){
		xp -= xOffset;
		yp -= yOffset;
		if(yp < 0 || yp >= screen.Height || xp < 0 || xp >= screen.Width) return;
		if(yp-1 < 0 || yp-1 >= screen.Height || xp-1 < 0 || xp-1 >= screen.Width) return;
		if(yp < 0 || yp >= screen.Height || xp-1 < 0 || xp-1 >= screen.Width) return;
		if(yp-1 < 0 || yp-1 >= screen.Height || xp < 0 || xp >= screen.Width) return;
		screen.pixels[xp + yp * screen.Width] = colour;
		screen.pixels[xp + (yp-1) * screen.Width] = colour;
		screen.pixels[(xp-1) + yp * screen.Width] = colour;
		screen.pixels[(xp-1) + (yp-1) * screen.Width] = colour;
	}
	
	public void setOffsets(int x, int y){
		xOffset = x;
		yOffset = y; // 20 16
	}

}
