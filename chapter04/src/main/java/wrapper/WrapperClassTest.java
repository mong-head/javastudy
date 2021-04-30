package wrapper;

public class WrapperClassTest {

	public static void main(String[] args) {
		//안쓰이는 형태
		Integer i = new Integer(10);
		
		// Auto Boxing
		//쓰이는 형태 - 같은 값을 가지는 객체는 한 번만 저장하기 위함
		Integer j1 = 10; 
		Integer j2 = 10; 
		System.out.println("j1 == j2 : "+(j1==j2));
		System.out.println("i == j1 : "+(i==j1));
		
		// Auto Unboxing
		//int j3 = j1.intValue(); 안쓰이는 형태
		int j3 = j1;
	}

}
