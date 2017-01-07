package math;

public class Tinting {
	
	public static int changeBrightness(int colour, int amount){
		int r = (colour & 0xff0000) >> 16;
		int g = (colour & 0xff00) >> 8;
		int b = colour & 0xff;
		r += amount;
		g += amount;
		b += amount;
		if(r < 0)
			r = 0;
		if(g < 0)
			g = 0;
		if(b < 0)
			b = 0;
		if(r > 0xff)
			r = 0xff;
		if(g > 0xff)
			g = 0xff;
		if(b > 0xff)
			b = 0xff;
		return r << 16 | g << 8 | b;
	}
	
	public static int colourBlend(int colour, int colour2){
		int r = (colour & 0xff0000) >> 16;
		int g = (colour & 0xff00) >> 8;
		int b = colour & 0xff;
		int r2 = (colour2 & 0xff0000) >> 16;
		int g2 = (colour2 & 0xff00) >> 8;
		int b2 = colour2 & 0xff;
		r = (r2) + (r) ;
		g = (g2) + (g) ;
		b = (b2) + (b) ;
		if(r < 0)
			r = 0;
		if(g < 0)
			g = 0;
		if(b < 0)
			b = 0;
		if(r > 0xff)
			r = 0xff;
		if(g > 0xff)
			g = 0xff;
		if(b > 0xff)
			b = 0xff;
		return r << 16 | g << 8 | b;
		//return colour * colour2 / 255;
	}


}
