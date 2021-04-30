package practice_final;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GugudanTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<Gugudan> s = new HashSet<>();
		
		//문제 구구단
		int left = (int)(Math.random()*10);
		int right = (int)(Math.random()*10);
		Gugudan answer_gugudan = new Gugudan(left,right);
		s.add(answer_gugudan);
		System.out.printf("%d X %d = ?\n\n",left,right);
		
		//set이 9개가 될 때까지 생성
		while(s.size()!=9) {
			left = (int)(Math.random()*10);
			right = (int)(Math.random()*10);
			s.add(new Gugudan(left,right));
		}
		
		//보기 출력
		int cnt = 0;
		for(Gugudan g : s) {
			if(cnt>2) {
				System.out.println();
				cnt = 0;
			}
			System.out.printf("%d\t",g.multiple());
			cnt++;
		}
		
		//입력
		System.out.print("\n\nanswer:");
		int answer = scan.nextInt();
		
		//입력한 값의 구구단객체 찾기
		Gugudan select_gugudan = null;
		for(Gugudan g : s) {
			if(g.multiple() == answer) {
				select_gugudan = g;
			}
		}
		
		if(answer_gugudan.equals(select_gugudan)) {
			System.out.println("\n정답");
		} else {
			System.out.println("\n오답");
		}
	}

}
