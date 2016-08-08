package math;

public class HealmMaths {
	
	public static int divideProtectedI(int a, int b){
		if(a == 0)
			return 0;
		if(b == 0)
			return 0;
		return a / b;
	}
	
	public static double divideProtectedD(double a, double b){
		if(a == 0)
			return 0;
		if(b == 0)
			return 0;
		return a / b;
	}
	
	public static int timesProtectedI(int a, int b){
		if(a <= 0)
			return 0;
		if(b <= 0)
			return 0;
		return a * b;
	}

}
