package singleton;

public class MyClassTest {

	public static void main(String[] args) {
		MyClass myclass01 = MyClass.getInstance();
		MyClass myclass02 = MyClass.getInstance();
		
		System.out.println(myclass01 == myclass02);

	}

}
