package math;

public class NoiseMapGen {
	
	public static int[] mapNoise(int size, int seed){
		int[] map = new int[size*size];
		
		for(int y = 0; y < size; y++){
			for(int x = 0; x < size; x++){
				map[x + y * size] = (int) noise(x, y) * 0xffffff;
			}
		}
		
		
		return map;
	}
	
	
	public static double noise (int x, int y){
		double t = (x + Math.PI) * (x + Math.PI) * (y + Math.PI) * (y + Math.PI);
		double m = t * t * t *(t * (t * 6 - 15) + 10);
		return m;
	}
	
	public static double noise2(int x, int y, int seed){
		int n = x * y * 573;
		n = (n << 13) ^ n;
		return (1 - ( ( n * ( n * n * 15731 * seed) + 1376312589 ) & 0x7fffffff ) / 1073741824);
	}
	
}
