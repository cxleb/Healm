package graphics;

import java.awt.Dimension;
import javax.swing.JFrame;
import game.Game;

public class Window
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  public int WIDTH;
  public int HEIGHT;
  private String TITLE;
  
  public Window(int width, int height, String title, Game game)
  {
    this.WIDTH = width;
    this.HEIGHT = height;
    this.TITLE = title;
    setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
    setMaximumSize(new Dimension(this.WIDTH, this.HEIGHT));
    setMinimumSize(new Dimension(this.WIDTH, this.HEIGHT));
    setDefaultCloseOperation(3);
    setLocationRelativeTo(null);
    setTitle(this.TITLE);
    add(game);
    setVisible(true);
  }
  
  public int getWidth()
  {
    return this.WIDTH;
  }
  
  public int getHeight()
  {
    return this.HEIGHT;
  }
  
  public void updateTitle(String title)
  {
    setTitle(title);
    this.TITLE = title;
  }
}