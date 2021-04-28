package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i=0;i<COUNT_GOODS;i++) {
			String good = scanner.nextLine();
			String[] good_info = good.split(" ");
			Goods temp = new Goods();
			temp.setName(good_info[0]);
			temp.setCost(Integer.parseInt(good_info[1]));
			temp.setNum(Integer.parseInt(good_info[2]));
			goods[i] = temp;
		}
		// 상품 출력
		for(Goods g : goods) {
			g.printAll();
		}
		// 자원정리
		scanner.close();
	}
}
