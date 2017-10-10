package graphics.font;

import graphics.Render;
import graphics.sprites.MapedSpriteSheet;

public class Font {
	
	
	public static Font Arial8 = new Font("res/fonts/arial 8.png", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.,;:!?'\"%+-", 8, 104);
	public static Font Arial8White = new Font("res/fonts/arial 8 white.png", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.,;:!?'\"%+-", 8, 104);
	
	
	MapedSpriteSheet sheet;
	String fontSequence;
	int fontSize;
	
	public Font (String fontpath, String fontsequence, int fontSize, int sheetSize){
		this.sheet = new MapedSpriteSheet(fontpath, sheetSize, fontSize);
		this.fontSequence = fontsequence;
		this.fontSize = fontSize;
		
	}
	
	public void renderFont(Render render, String text, int xp, int yp){
		for(int i = 0; i < text.length(); i++){
			int indexInSequence = fontSequence.indexOf(text.charAt(i));
			if(indexInSequence == -1) continue;
			render.renderSprite(sheet.sprites[indexInSequence], xp + i * fontSize, yp);
		}
	}

}
