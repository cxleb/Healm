package graphics.map;

import graphics.Render;
import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;
import graphics.tiles.Tile;
import input.MapFileReader;
import math.GenerateDungeon;

public class Map {
	
	public int Width;
	public int Height;
	public int[] tiles;
	
	public Spritesheet bulletSpriteSheet = new Spritesheet("res/spritesheets/spawn_tile.png", 16);
	public Sprite spawnS = new Sprite(bulletSpriteSheet, 16, 0, 0);
	public Tile spawn = new Tile(spawnS, false);
	
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
		///Random rand = new Random();
		///for(int i = 0; i < tiles.length; i++){
		///	tiles[i] = rand.nextInt(3);
		///}
		GenerateDungeon.generateDungeon(this, 64, 8);
	}
	
	private void generateMapFromFile(String filepath){
		tiles = MapFileReader.readCSV(filepath);
		Width = (int)Math.sqrt((double)tiles.length);
		Height = Width;
	}
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	
	
	public void render(Render render){
		for (int y = 0; y < Height; y++){
			for(int x = 0; x < Width; x++){
				drawTile(render, getTileAt(x,y), x, y);
			}
		}
	}
	
	public Tile getTileAt(int x, int y){
		if(x < 0 || x >= Width || y < 0 || y >= Height){
			return Tile.tiles[0];
		}
		
		int tileID = tiles[x + y * Width];
		if(tileID == -1){
			return spawn;
		}
		
		return Tile.tiles[tileID];
	}
	
	public int GetSpawnX(){
		for(int x = 0; x < Width; x++){
			for(int y = 0; y < Height; y++){
				if(tiles[x + y * Width] == -1){
					return x * 16;
				}
			}
		}
		return 0;
	}
		
	public int GetSpawnY(){
		for(int x = 0; x < Width; x++){
			for(int y = 0; y < Height; y++){
				if(tiles[x + y * Width] == -1){
					return y * 16;
				}
			}
		}
		return 0;
	}
	
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////

	
	
	public void drawTile(Render render, Tile tile, int x, int y){
		tile.render(render, x * tile.sprite.SIZE, y * tile.sprite.SIZE);
	}
	
}
