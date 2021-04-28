package swap;


public class Swaptest02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		
		System.out.println(a+":"+b);
		swap(a,b);
		System.out.println(a+":"+b); //안바뀜
	}
	
	public static void swap(int x,int y) {
		int temp = x;
		x = y;
		y = temp;
	}

}
