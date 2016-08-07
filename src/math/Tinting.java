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

}
