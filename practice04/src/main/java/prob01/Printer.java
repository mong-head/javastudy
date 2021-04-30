package prob01;

public class Printer {
//	public static void println(int a) {
//		System.out.println(a);
//	}
//	public static void println(boolean a) {
//		System.out.println(a);
//	}
//	public static void println(double a) {
//		System.out.println(a);
//	}
//	public static void println(String a) {
//		System.out.println(a);
//	}
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.print(t);
			System.out.print(" ");
		}
		System.out.print("\n");
	}

	//가변변수!
	public int sum(Integer... nums) {
		Integer sum = 0;
		for(Integer i : nums) {
			sum +=  i;
		}
		return sum;
	}
}
