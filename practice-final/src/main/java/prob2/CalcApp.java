package prob2;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오 >>");
		int a = scan.nextInt();
		int b = scan.nextInt();
		String cal = scan.next();
		
		switch(cal) {
			case "+":{
				Add result = new Add();
				System.out.println(result.calculate(a, b));
				break;
			}
			case "-":{
				Sub result = new Sub();
				System.out.println(result.calculate(a, b));
				break;
			}
			case "*":{
				Mul result = new Mul();
				System.out.println(result.calculate(a, b));
				break;
			}
			case "/":{
				Div result = new Div();
				System.out.println(result.calculate(a, b));
				break;
			}
		}
	}

}
