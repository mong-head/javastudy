package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10,20);
		Point p2 = new Point(10,20);
		Point p3 = p2;
		
		// == : 두 객체의 동일성(reference가 같은지)
		System.out.println("p1==p2 : "+(p1==p2));
		System.out.println("p3==p2 : "+(p3==p2));
		
		// equals : 두 객체의 동질성(내용이 같은지) - 기본 구현 : 동일성 검사 따라서 오버라이딩해야함
		System.out.println("\np1.equals(p2) : "+(p1.equals(p2)));
		System.out.println("p3.equals(p2) : "+(p3.equals(p2)));
	}

}
