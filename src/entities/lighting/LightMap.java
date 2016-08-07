package entities.lighting;

import java.util.ArrayList;
import java.util.List;

import graphics.Render;

public class LightMap {
	
	private List<Light> lights;
	
	public LightMap(){
		lights = new ArrayList<Light>();
	}
	
	public void addLight(Light light){
		lights.add(light);
	}
	
	public void renderLightMap(Render render){
		for(Light light: lights){
			render.renderLight(light);
		}
	}

}
