package swap;

public class Swaptest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		
		System.out.println(a+":"+b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println(a+":"+b);
	}

}
