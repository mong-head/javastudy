package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		try {
			MyClass.danger();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
