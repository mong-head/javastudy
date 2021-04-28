package StaticMethod;

public class StaticMethodTest {

	public static void main(String[] args) {
		 //Integer의 static method 사용 예제
		String s = "123";
		int i = Integer.parseInt(s);
		
		//Math클래스의 static method 사용 예제
		int j = Math.abs(-1);
		int k = Math.max(10, 20);
		
		System.out.println(i+":"+j+":"+k);
	}

}
