package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		String s1 = new String("둘리");
		String s2 = "둘리";
		
		s.add(s1);
		s.add("마이콜");
		s.add("또치");
		
		System.out.println(s.size());
		System.out.println(s.contains(s2)); //내용으로 체크(객체가 같은지 보는게 아님)
		
		//순회
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
	}

}
