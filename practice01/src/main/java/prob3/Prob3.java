package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.printf("숫자를 입력하세요:");
		int n = scanner.nextInt();
		int result = 0;
		
		if(n%2==1) {
			result = (int)Math.pow(n/2+1,2);
		}
		else {
			result = (int)((n*n/2+n)/2);
		}
		System.out.printf("결과값: %d",result);
		scanner.close();
	}
}
