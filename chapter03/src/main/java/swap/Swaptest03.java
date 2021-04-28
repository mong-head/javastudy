package swap;

public class Swaptest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Value a = new Value();
		Value b = new Value();
		a.val = 10;
		b.val = 20;
		
		System.out.println(a.val+":"+b.val);
		swap(a,b);
		System.out.println(a.val+":"+b.val); //안바뀜
	}
	
	public static void swap(Value x,Value y) {
		int temp = x.val;
		x.val = y.val;
		y.val = temp;
	}


}
