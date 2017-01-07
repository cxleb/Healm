package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	public boolean[] keys = new boolean[150];
	public static boolean up, left, right , down;
	public static boolean o, p;
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		o = keys[KeyEvent.VK_O];
		p = keys[KeyEvent.VK_P];
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		o = keys[KeyEvent.VK_O];
		p = keys[KeyEvent.VK_P];
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
