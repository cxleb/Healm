package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import graphics.Render;
import graphics.Window;
import input.Keyboard;
import input.Mouse;
import level.Level;


public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static final int Width = 300; // 300
	public static final int Height = 168; // 168
	public static final int scale = 3;
	
	private boolean running = false;
	
	Window window;
	Thread thread;
	
	Render render;
	
	Keyboard keyboard;
	Mouse mouse;
	
	Level currentLevel;
	
	BufferedImage image = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public int DeltaTime = 1;
	
	public Game(){
		window = new Window(Width * scale, Height * scale, "This is the Title", this);
		render = new Render(Width, Height);
		
		currentLevel = new Level("res/maps/dungeon1.csv", "res/spritesheets/i_spritesheet", 128, 16);
		
		keyboard = new Keyboard();
		mouse = new Mouse();
		this.requestFocus();
		this.addKeyListener(keyboard);
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Game Thread");
		thread.start();	
	}
	public synchronized void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		render.clear();
		
		currentLevel.render(render, DeltaTime);
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = render.screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.white);
		g.drawImage(image, 0, 0, Width * scale, Height * scale, null);
		
		g.dispose();
		bs.show();
	}
	private void update(){
		currentLevel.update(DeltaTime);
		
		render.setOffsets(currentLevel.player.playerX, currentLevel.player.playerY);
		
	}
	
	public void run()
	  {
	    long lastTime = System.nanoTime();
	    double amountOfUps = 60;
	    double delta = 0.0;
	    double ns = 1000000000 / amountOfUps;
	    long timer = System.currentTimeMillis();
	    int frames = 0;
	    int updates = 0;
	    while (this.running)
	    {
	      long now = System.nanoTime();
	      delta += (now - lastTime) / ns;
	      lastTime = now;
	      while (delta >= 1.0D)
	      {
	        update();
	        updates++;
	        delta -= 1.0D;
	      }
	      render();
	      
	      frames++;
	      if (System.currentTimeMillis() - timer > 1000L)
	      {
	        timer += 1000L;
	        //if (this.fpsInTitle) {
	          this.window.updateTitle("FPS: " + frames + " UPS: " + updates);
	        //} else {
	        //  System.out.println("FPS: " + frames + " UPS: " + updates);
	        //}
	        frames = 0;
	        updates = 0;
	      }
	    }
	  }
	

}
