package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import math.Rect;
import graphics.map.Map;

public class GenerateDungeon {

	public static void generateDungeon(Map map, int size, int rooms){
		Random random = new Random(System.currentTimeMillis());
		
		int tiles[] = new int[size * size];
		for(int i = 0; i < size * size; i++) { tiles[i] = 0; }
		List<Rect> Rooms = new ArrayList<Rect>();
		
		
		
		//
		// 	ROOM GENERATION
		//
		
		int roomTryCounter = 0;
		for(int i = 0; i < rooms; i++) {
			boolean notgenerated = true;
			
			while(notgenerated){
				int x = random.nextInt(size) + 1;
				int y = random.nextInt(size) + 1;
				int sizeX = random.nextInt((size/2) - (size/4)) + 4;
				int sizeY = random.nextInt((size/2) - (size/4)) + 4;
				boolean doesntInter = true;
				for(Rect room:Rooms){ 
					if(room.doesCollide(x, y, sizeX, sizeY)){
						doesntInter = false;
					}
				}
				
				if((y + sizeY) < size && (x + sizeX) < size && doesntInter){
					for(int z = 0; z < sizeY; z++){
						for(int w = 0; w < sizeX; w++){
							tiles[(x + w) + (y + z) * size] = 28;
						}
					}
					Rooms.add(new Rect(x, y, sizeX, sizeY));
					notgenerated = false;
				}
				roomTryCounter++;
			}
			
			
		}
		
		//
		// 	TUNNEL GENERATION
		//
		
		if(rooms > 1){
			for(int i = 1; i < Rooms.size(); i++){
				Rect room1 = Rooms.get(i - 1);
				Rect room2 = Rooms.get(i);
				
				int x1 = room1.x;
				int y1 = room1.y;
				int x2 = room2.x;
				int y2 = room2.y;
				
				//x
				int xd = Math.min(x1, x2);
				int sx = Math.max(x1, x2) - xd + 1;
				for(int x = 0; x < sx; x++){
					tiles[(x+xd) + y1 * size] = 28;
				}
				
				
				//y
				int yS = Math.min(y1, y2);
				int sy = Math.max(y1, y2) - yS;
				for(int y = 0; y < sy; y++){
					tiles[x2 + (y+yS) * size] = 28;
				}
				
				
			}
		}
		
		
		
		//
		// 	OBJECT GENERATION
		//
		
		int objects = 0;
		for(int i = 1; i < Rooms.size(); i++){
			Rect room = Rooms.get(i - 1);
			
			//Generates Spikes
			int objectCount = random.nextInt(6);
			for(int c = 0; c < objectCount; c++){
				int x = random.nextInt(room.sizeX -1 ) + 1;
				int y = random.nextInt(room.sizeY -1 ) + 1;
				tiles[(room.x + x) + (room.y + y) * size ] = 44;
				
			}
			objects += objectCount;
				
			// Generates Chest
			int x = random.nextInt(room.sizeX -1 ) + 1;
			int y = random.nextInt(room.sizeY -1 ) + 1;
			int toss = random.nextInt(2);
			if(toss == 0){
				tiles[(room.x + x) + (room.y + y) * size ] = 43;
			}
			objects++;
		}
		
		
		
		System.out.println("Rooms Generated: " + rooms + " Room Generation Trys: " + roomTryCounter + " Objects Generated: " + objects);
		
		map.tiles = tiles;
		
	}
	
}
