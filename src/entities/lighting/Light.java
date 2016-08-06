package entities.lighting;

import entities.Entity;

public class Light extends Entity{
	
	public int radius;
	public int intensity;

	public Light(int x, int y, int radius, int intensity) {
		super(x, y);
		this.radius = radius;
		this.intensity = intensity;
	}

}
