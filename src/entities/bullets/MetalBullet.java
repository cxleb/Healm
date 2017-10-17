package entities.bullets;

import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;

public class MetalBullet extends Bullet{

	public static final Spritesheet bulletSpriteSheet = new Spritesheet("res/spritesheets/bullet3.png", 8);
	public static final Sprite bullet = new Sprite(bulletSpriteSheet, 8, 0, 0);
	
	public MetalBullet(int x, int y, double xdir, double ydir) {
		super(x, y, xdir, ydir, 4, 30, bullet);
	}
	
}
