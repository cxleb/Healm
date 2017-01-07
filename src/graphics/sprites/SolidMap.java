package graphics.sprites;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SolidMap {

	public int Width;
	public int Height;
	public boolean[] solids;
	
	public SolidMap(String file){
		generateMapFromFile(file);
	}
	
	private void generateMapFromFile(String filepath){
		
		int Size = 0;
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
		
		Log.Log.log_add("Solid Map Format: CSV, Map size: " + (Size));
		
		solids = new boolean[Size * Size];
		
		for (int i = 0; i < solids.length; i++) {
			int solid = Integer.parseInt(mapContents[i]);
			if(solid == 1){
				solids[i] = true;
			}
		}
		
		Width = Size;
		Height = Size;
		
	}

}
