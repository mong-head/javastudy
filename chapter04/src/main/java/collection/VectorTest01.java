package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		//옛날 버전의 vector
		Vector<String> v = new Vector<>();

		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("또치");
		
		//순회1
		System.out.println("1. 순회1");
		int count = v.size();
		for(int i=0;i<count;i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		//삭제
		v.removeElementAt(2);
		
		//순회2
		System.out.println("2. 순회2");
		Enumeration<String> e= v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}
	}

}
