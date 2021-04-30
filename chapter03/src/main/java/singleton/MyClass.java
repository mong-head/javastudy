package singleton;

//Calendar 이해하기 위함

public class MyClass {
	private static MyClass instance;
	
	private MyClass() {
		
	}
	//Singleton + Factory method
	//Singleton : 객체 딱 하나만 있는거
	public static MyClass getInstance() {
		if(instance == null) {
			instance = new MyClass();
		}
		return instance;
	}
}
