package good2;

public class Goods2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods2 goods = new Goods2();
		Goods2 goods2 = new Goods2("coffee",1000,20,60);
		goods.setName("Nikon");
		goods.setPrice(10000);
		goods.setCountSold(20);
		goods.setCountStock(30);
		
		System.out.println("할인된 값:"+goods.f(0.5));
		goods.setPrice(-1); //메소드로 잘못된 값을 미리 감지할 수 있어서 보호가능
		goods.showInfo();
		
		goods2.showInfo();
	}

}
