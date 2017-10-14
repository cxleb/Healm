package entities.bullets;

import graphics.sprites.Sprite;
import graphics.sprites.Spritesheet;

public class FireBullet extends Bullet{

	public static final Spritesheet bulletSpriteSheet = new Spritesheet("res/spritesheets/bullet2.png", 8);
	public static final Sprite bullet = new Sprite(bulletSpriteSheet, 8, 0, 0);
	
	public FireBullet(int x, int y, double xdir, double ydir) {
		super(x, y, xdir, ydir, 4, 10, bullet);
	}

}
