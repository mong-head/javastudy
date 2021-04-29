package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10,10); //Point : 부를 수 있는 함수가 없음 but Object의 함수 부를 수 있음
		
		//Class cl = p.getClass();
		System.out.println("p.getClass(): "+p.getClass()); //reflection : 클래스 정보 알아냄
		System.out.println("p.hashCode(): "+p.hashCode()); //hashing:모든 것을 정수로 바꿈. 정수로 비교할 때 빠름
														   //여기서는 address기반 해싱값(객체의 ID값)
														   //address, reference가 아님
		System.out.println("p.toString(): "+p.toString()); //기본적으로는 getClass() + "@" + hashCode()
		System.out.println("p	    : "+p);
		
		
	}

}
