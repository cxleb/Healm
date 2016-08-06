package entities.lighting;

import java.util.ArrayList;
import java.util.List;

import graphics.Screen;
import math.Tinting;

public class LightMap {
	
	private List<Light> lights;
	public Screen output;
	
	public LightMap(){
		lights = new ArrayList<Light>();
	}
	
	public void addLight(Light light){
		lights.add(light);
	}
	
	public void renderLightMap(Screen screen, int xoffset, int yoffset, int width, int height){
		output = new Screen(screen.Width, screen.Height);
		for(int t = 0; t < output.pixels.length; t++){
			output.pixels[t] = screen.pixels[t];
		}
		for(Light light: lights){
			if(light.getX() > xoffset && light.getY() > yoffset && light.getX() < xoffset+width && light.getY() < yoffset+height){
				int xx = light.getX() - xoffset;
				int yy = light.getY() - yoffset;
				double x = 0;
				double y = 0;
				int intenisty = light.intensity;
				for(int dist = 0; dist < light.radius; dist++){
					for(int currad = 0; currad < 360; currad++ ){
						x = Math.sin(Math.toRadians(currad)) * dist + xx;
						y = Math.cos(Math.toRadians(currad)) * dist + yy;
						if(y < 0 || y >= screen.Height || x < 0 || x >= screen.Width) {
						}else{
							int incol = output.pixels[(int)x + (int)y * width];
							output.pixels[(int)x + (int)y * width] = Tinting.changeBrightness(incol, intenisty);
						}
					}
					intenisty--;
				}
			}
		}
		
		
		
	}

}
