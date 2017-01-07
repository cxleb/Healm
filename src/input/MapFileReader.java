package input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapFileReader {
	public static int[] readCSV(String filepath){
		int Size = 0;
		int[] tiles;
		
		String contents = "";
		try {
			FileReader fr = new FileReader(filepath);
			BufferedReader reader = new BufferedReader(fr);
			String line = "";
			while((line = reader.readLine()) != null) {
                contents += line;
            } 
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] mapContents = contents.split(",");
		
		Size = (int)Math.sqrt((double)mapContents.length);
		
		Log.Log.log_add("Map Format: CSV, Map size: " + (Size));
		
		tiles = new int[Size * Size];
		
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = Integer.parseInt(mapContents[i]);
		}
		
		return tiles;
	}
	
	public static int[] readHMF(String filepath){
		int Width = 0;
		int Height = 0;
		int[] tiles;
		
		String contents = "";
		try {
			FileReader fr = new FileReader(filepath);
			BufferedReader reader = new BufferedReader(fr);
			String line = "";
			while((line = reader.readLine()) != null) {
                contents += line;
            } 
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] mapContent = contents.split(",");
		
		Width =  Integer.parseInt(mapContent[0]);
		Height =  Integer.parseInt(mapContent[1]);
		
		System.out.println(Width + " " + Height);
		
		tiles = new int[Width*Height];
		
		if(tiles.length > mapContent.length - 2){
			System.err.println("Error: Map is not big enogh for the size!");
			System.err.println("Error Log: Given Map Size:" + tiles.length + " Real Map Size:" + (mapContent.length - 2));
			return null;
		} else if(tiles.length < mapContent.length - 2){
			System.err.println("Warning: Map is to big enogh for the size!");
			System.err.println("Warning Log:Given Map Size:" + tiles.length + " Real Map Size:" + (mapContent.length - 2));
		}
		
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = Integer.parseInt(mapContent[i + 2]);
		}
		
		return tiles;
	}
}
