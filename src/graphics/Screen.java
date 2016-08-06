package graphics;

public class Screen {
	
	public int Width;
	public int Height;
	public int[] pixels;
	
	public Screen(int width, int height){
		this.Width = width;
		this.Height = height;
		pixels = new int[width * height];
	}
	
	

}
