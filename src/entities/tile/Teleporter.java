package entities.tile;

import entities.Entity;

public class Teleporter extends Entity{

	public int id = 0;
	public Teleporter(int x, int y, int id) {
		super(x, y);
		this.id = id;
	}

}
