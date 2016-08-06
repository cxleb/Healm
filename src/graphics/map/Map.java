package graphics.map;

import java.util.Random;

import graphics.Render;
import graphics.tiles.Tile;
import input.MapFileReader;

public class Map {
	
	public int Width;
	public int Height;
	public int[] tiles;
	
	public Map(int w, int h){
		Width = w;
		Height = h;
		tiles = new int[w*h];
		generateRandom();
	}
	
	public Map(String file){
		generateMapFromFile(file);
	}
	
	
	private void generateRandom() {
		Random rand = new Random();
		for(int i = 0; i < tiles.length; i++){
			tiles[i] = rand.nextInt(3);
		}
	}
	
	private void generateMapFromFile(String filepath){
		tiles = MapFileReader.readCSV(filepath);
		Width = (int)Math.sqrt((double)tiles.length);
		Height = Width;
	}

	public void render(Render render){
		for (int y = 0; y < Height; y++){
			for(int x = 0; x < Width; x++){
				drawTile(render, getTileAt(x,y), x, y);
			}
		}
	}
	
	public void drawTile(Render render, Tile tile, int x, int y){
		tile.render(render, x * tile.sprite.SIZE, y * tile.sprite.SIZE);
	}
	
	public Tile getTileAt(int x, int y){
		if(x < 0 || x > Width-1 || y < 0 || y > Height-1){
			return Tile.grass;
		}
		
		int tileID = tiles[x + y * Width];
		if(tileID == 0){
			return Tile.grass;
		} else if(tileID == 1){
			return Tile.rock;
		} else if(tileID == 2){
			return Tile.stone;
		}else if(tileID == 3){
			return Tile.wood;
		}else if(tileID == 4){
			return Tile.water;
		}else if(tileID == 5){
			return Tile.watertop;
		}else if(tileID == 6){
			return Tile.waterbottom;
		}else if(tileID == 7){
			return Tile.waterleft;
		}else if(tileID == 8){
			return Tile.waterright;
		}else if(tileID == 9){
			return Tile.watertopleft;
		}else if(tileID == 10){
			return Tile.watertopright;
		}else if(tileID == 11){
			return Tile.waterbotleft;
		}else if(tileID == 12){
			return Tile.waterbotright;
		}else if(tileID == 13){
			return Tile.waterstatic;
		}else if(tileID == 20){
			return Tile.spawn;
		}
		return Tile.grass;
	}
	
	public int getSpawnX(){
		for(int x = 0; x < Width; x++){
			for(int y = 0; y < Height; y++){
				if(tiles[x + y * Width] == 20){
					return x * 16;
				}
			}
		}
		return 0;
	}
		
	public int getSpawnY(){
		for(int x = 0; x < Width; x++){
			for(int y = 0; y < Height; y++){
				if(tiles[x + y * Width] == 20){
					return y * 16;
				}
			}
		}
		return 0;
	}
}
