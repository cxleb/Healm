package graphics.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	private String path;
	public final int SIZE;
	public int[] pixels;
	
	
	
	
	public Spritesheet(String Path, int Size){
		this.path = Path;
		this.SIZE = Size;
		pixels = new int[this.SIZE * this.SIZE];
		load();
	}
	
	private void load(){
		try {
			BufferedImage sheet = ImageIO.read(new File(path));
			int w = sheet.getWidth();
			int h = sheet.getHeight();
			sheet.getRGB(0, 0, w, h, pixels, 0, SIZE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getBound(int spriteSize){
		return SIZE / spriteSize;
	}

}
