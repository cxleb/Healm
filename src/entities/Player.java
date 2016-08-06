package entities;

import java.util.ArrayList;
import java.util.List;

import entities.components.AnimationComponent;
import game.Game;
import graphics.map.Map;
import graphics.sprites.Sprite;
import input.Keyboard;

public class Player extends Entity{

	public int playerX = 0;
	public int playerY = 0;
	
	public boolean canMoveUp = true;
	public boolean canMoveDown = true;
	public boolean canMoveLeft = true;
	public boolean canMoveRight = true;
	public boolean side = true; // right = true, left = false
	public boolean animate;
	public boolean animateY;
	
	private AnimationComponent leftAnim;
	private AnimationComponent rightAnim;
	List<Sprite> leftSprites;
	List<Sprite> rightSprites;
	
	
	public Player(int x, int y) {
		super(Game.Width/2-8, Game.Height/2-8);
		playerX = x;
		playerY = y;
		
		leftSprites = new ArrayList<Sprite>();
		rightSprites = new ArrayList<Sprite>();
		
		leftSprites.add(Sprite.manleft_0);
		leftSprites.add(Sprite.manleft_1);
		leftSprites.add(Sprite.manleft_0);
		leftSprites.add(Sprite.manleft_2);
		
		rightSprites.add(Sprite.manright_0);
		rightSprites.add(Sprite.manright_1);
		rightSprites.add(Sprite.manright_0);
		rightSprites.add(Sprite.manright_2);
		
		leftAnim = new AnimationComponent(leftSprites, 4, false);
		rightAnim = new AnimationComponent(rightSprites, 4, false);
		leftAnim.printFirstFrame = false;
		
		addComponent(rightAnim);
		addComponent(leftAnim);
	}
	
	public void entityUpdate(int delta, Map map){
		if(map.getTileAt( (playerX + (Game.Width/2)) / 16 , (playerY + (Game.Height/2 - 8 )) / 16).isSolid){
			canMoveUp = false;
		} else {
			canMoveUp = true;
		}
		
		if(map.getTileAt( (playerX + (Game.Width/2)) / 16 , (playerY + (Game.Height/2 + 8 )) / 16).isSolid){
			canMoveDown = false;
		} else {
			canMoveDown = true;
		}
		
		if(map.getTileAt( (playerX + (Game.Width/2 + 8 )) / 16 , (playerY + (Game.Height/2)) / 16).isSolid){
			canMoveRight = false;
		} else {
			canMoveRight = true;
		}
		
		if(map.getTileAt( (playerX + (Game.Width/2 - 8 )) / 16 , (playerY + (Game.Height/2)) / 16).isSolid){
			canMoveLeft = false;
		} else {
			canMoveLeft = true;
		}
		
		if(side){
			leftAnim.printFirstFrame = false;
			rightAnim.printFirstFrame = true;
			if(animateY || animate){
				leftAnim.triggered = false;
				rightAnim.triggered = true;
			}else{
				leftAnim.triggered = false;
				rightAnim.triggered = false;
			}
		}else{
			leftAnim.printFirstFrame = true;
			rightAnim.printFirstFrame = false;
			if(animateY || animate){
				leftAnim.triggered = true;
				rightAnim.triggered = false;
			}else{
				leftAnim.triggered = false;
				rightAnim.triggered = false;
			}
		}
	
		if(Keyboard.up && canMoveUp) {
			playerY -= 1;
			animateY = true;
		} else if(Keyboard.down && canMoveDown){
			playerY += 1;
			animateY = true;
		} else {
			animateY = false;
		}
		if(Keyboard.right && canMoveRight){
			side = true;
			animate = true;
			playerX += 1;
		} else if(Keyboard.left && canMoveLeft) {
			side = false;
			animate = true;
			playerX -= 1;
		} else {
			animate = false;
		}
	}

}
