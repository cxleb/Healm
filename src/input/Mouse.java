package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import game.Game;

public class Mouse implements MouseListener, MouseMotionListener{
	
	public static int x = 0;
	public static int y = 0;
	public static boolean leftClicked = false;
	public static boolean rightClicked = false;

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		if(arg0.getButton() == MouseEvent.BUTTON1) leftClicked = true;
		if(arg0.getButton() == MouseEvent.BUTTON3) rightClicked = true;
		x = arg0.getX()/Game.scale;
		y = arg0.getY()/Game.scale;
	}

	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getButton() == MouseEvent.BUTTON1) leftClicked = false;
		if(arg0.getButton() == MouseEvent.BUTTON3) rightClicked = false;
	}

	public void mouseDragged(MouseEvent arg0) {
		x = arg0.getX()/Game.scale;
		y = arg0.getY()/Game.scale;
	}

	public void mouseMoved(MouseEvent arg0) {
	}
	
}
