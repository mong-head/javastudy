package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		stack.push("둘리");
		stack.push("마이콜");
		stack.push("도우너");
		
		while(!stack.isEmpty()) {
			String str = stack.pop();
			System.out.println(str);
		}
		
		// 빈 경우 exception error (cf. queue : 빈 경우 null)
		//stack.pop();
		
		stack.push("둘리");
		stack.push("마이콜");
		stack.push("도우너");
		
		System.out.println(stack.pop());
		System.out.println(stack.peek()); //가장 위에 무엇이 있는 지 봄
		System.out.println(stack.pop());

	}

}
