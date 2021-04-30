package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		//현재 방식
		List<String> list = new LinkedList<>(); //VectorTest02에서 Vector를 ArrayList로만 바꿈!!
		
		list.add("마이콜");
		list.add("둘리");
		list.add("또치");
		
		//순회1(전통적인 방식)
		int count = list.size();
		for(int i=0;i<count;i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		//순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		//순회3
		for(String s : list) {
			System.out.println(s);
		}
		
	}

}
