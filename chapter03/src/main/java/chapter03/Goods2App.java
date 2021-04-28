package chapter03;

public class Goods2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods2 goods = new Goods2();
		goods.setName("Nikon");
		goods.setPrice(10000);
		goods.setCountSold(20);
		goods.setCountStock(30);
		
		goods.setPrice(-1); //메소드로 잘못된 값을 미리 감지할 수 있어서 보호가능
		goods.showInfo();
	}

}
