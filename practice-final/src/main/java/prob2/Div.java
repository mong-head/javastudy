package prob2;

public class Div implements Arithmetic {

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		if(b!=0) {
			return a/b;			
		}else {
			return 0;
		}
	}

}
