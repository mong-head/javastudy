package prob06;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {
			System.out.print( ">> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 2 ] );
			
			Cal cal;
			switch( tokens[ 1 ] ) {
				case "+" : {
					cal = new Add();
					break;
				}
				case "-" : {
					cal = new Sub();				
					break;
				}
				case "*" : {
					cal = new Mul();					
					break;					
				}
				case "/" : {
					cal = new Div();
					break;
				}
				default :  {
					System.out.println( ">> 알 수 없는 연산입니다.");
					continue;
				}
			}
			cal.setValue( lValue, rValue );
			int result = cal.calculate();
			System.out.println( ">> " + result );
		}
		
		scanner.close();

	}

}
