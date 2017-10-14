package math;

public class Rect {
	public int x;
	public int y;
	public int sizeX;
	public int sizeY;
	
	public Rect(int x, int y, int sizeX, int sizeY) {
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public boolean doesCollide(Rect rect){
		return doesCollide(rect.x, rect.y, rect.sizeX, rect.sizeY);
	}
	
	public boolean doesCollide(int x, int y, int sizeX, int sizeY){
		return (this.x > x && this.x < x + sizeX) || (this.y > y && this.y < y + sizeY) ||
				(x > this.x && x < this.x + this.sizeX) || (y > this.y && y < this.y + this.sizeY); 
		
	}
}
