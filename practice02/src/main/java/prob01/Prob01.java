package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.print("금액 : ");
		int money = scanner.nextInt();
		int num = 0;
		for(int m : MONEYS) {
			num = money/m;
			money = money%m;
			System.out.println(m+"원 : "+num+"개");
		}
		
		scanner.close();
 	}
}