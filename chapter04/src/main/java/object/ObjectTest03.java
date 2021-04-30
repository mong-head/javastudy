package object;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("ABC");
		String s2 = new String("ABC");
		
		System.out.println("== :"+(s1 == s2));
		System.out.println("equals :"+(s1.equals(s2)));
		System.out.println(s1.hashCode()+":"+s2.hashCode()); //오버라이딩 후의 해쉬코드
		System.out.println(System.identityHashCode(s1)+":"+System.identityHashCode(s2)); //주소기반의 해쉬코드
		
		System.out.println("=====================================================");
		
		String s3 = "ABC";
		String s4 = "ABC";
		
		System.out.println("== :"+(s3 == s4));
		System.out.println("equals :"+(s3.equals(s4)));
		System.out.println(s3.hashCode()+":"+s4.hashCode()); //오버라이딩 후의 해쉬코드
		System.out.println(System.identityHashCode(s3)+":"+System.identityHashCode(s4)); //주소기반의 해쉬코드
 
	}

}
