package math;

public class NoiseMapGen {
	public static int[] mapNoise(int size, float seed){
		int[] map = new int[size*size];
		
		for(int y = 0; y < size; y++){
			for(int x = 0; x < size; x++){
				map[x + y * size] = (int) octaveNoise(1, 10, 1, x, y);
			}
		}
		
		
		return map;
	}
	
	public static float octaveNoise(float octaves, float roughness, float scale, float x, float y){
		
		float noiseSum = 0;
	    float layerFrequency = scale;
	    float layerWeight = 1;
	    float weightSum = 0;

	    for (int octave = 0; octave < octaves; octave++) {
	        noiseSum += fade(x * layerFrequency/ y * layerFrequency) * layerWeight;
	        layerFrequency *= 2;
	        weightSum += layerWeight;
	        layerWeight *= roughness;
	    }
	    return noiseSum / weightSum;
		
	}
	
	private static final float fade(float t)
	{
	   return t * t * t * (t * (t * 6.0f - 15.0f) + 10.0f);
	}

}
