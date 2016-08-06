package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import entities.Player;
import entities.lighting.Light;
import entities.lighting.LightMap;
import entities.particle.ParticleSpawner;
import graphics.Render;
import graphics.Window;
import graphics.map.Map;
import input.Keyboard;


public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static final int Width = 300;
	public static final int Height = Width / 16*9;
	public static final int scale = 4;
	
	private boolean running = false;
	
	Window window;
	Thread thread;
	
	Render render;
	
	Keyboard keyboard;
	
	Map mapTest;
	
	Player player;
	ParticleSpawner spawner;
	LightMap map;
	
	BufferedImage image = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public int DeltaTime = 1;
	
	public Game(){
		window = new Window(Width * scale, Height * scale, "This is the Title", this);
		render = new Render(Width, Height);
		
		mapTest = new Map("res/maps/blank.csv");
		
		player = new Player(mapTest.getSpawnX() - (Width/2-8), mapTest.getSpawnY() - (Height/2-8));
		
		spawner = new ParticleSpawner(mapTest.getSpawnX()+16, mapTest.getSpawnY(), 10);
		
		map = new LightMap();
		
		map.addLight(new Light(150, 100, 50, 50));
		map.addLight(new Light(200, 100, 50, 50));
		map.addLight(new Light(250, 100, 50, 50));
		map.addLight(new Light(300, 100, 50, 50));
		
		
		keyboard = new Keyboard();
		this.requestFocus();
		this.addKeyListener(keyboard);
		
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this);
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
		
		mapTest.render(render);
		
		spawner.render(DeltaTime, render);
		
		player.render(DeltaTime, render);
		
		map.renderLightMap(render.screen, render.xOffset, render.yOffset, Width, Height);
		
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = map.output.pixels[i];
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
		player.update(DeltaTime, mapTest);
		
		spawner.update(DeltaTime, mapTest);
		
		render.setOffsets(player.playerX, player.playerY);
		
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
