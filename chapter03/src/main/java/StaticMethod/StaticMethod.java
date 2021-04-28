package StaticMethod;

public class StaticMethod {
	int n;
	static int m;
	
	//f1~f4 : instance function
	void f1() {
		System.out.println(n);
	}
	void f2() {
		//같은 문장 : 같은 클래스의 클래스 변수 접근에서는 생략이 가능 but 기본은 명시하는 것임
		System.out.println(StaticMethod.m); //instance function은 static 변수 접근 가능
		System.out.println(m);
	}
	void f3() {
		f2(); // instance function 은 instance function 접근 가능
	}
	void f4() {
		//밑의 두 문장은 같은 문장 : 같은 클래스 내에서는 생략 가능
		s1(); // instance function 에서 instance function 접근 가능
		StaticMethod.s1();
	}
	
	//s1~s4 : static function
	static void s1() {
		//error : static method는 instance variance 접근 불가능
		//System.out.println(n); 
	}
	static void s2() {
		System.out.println(StaticMethod.m); // static method -> static variance 접근 가능
	}
	static void s3() {
		//error : static method -x-> instance method
		//f2(); 
	}
	static void s4() {
		StaticMethod.s1(); // static method -> static method
	}
}
