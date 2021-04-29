package good;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1
		Goods goods = new Goods();
		goods.name = "camera"; 
		//goods.price = 1000;  //만약 다른 패키지면 error
		//goods.countStock = 50;  //만약 다른 패키지면 error
		//goods.countSold = 20; //error
		
		System.out.println(goods.name);
		
		//2
//		Goods goods1 = new Goods();
//		Goods goods2 = new Goods();
//		
//		System.out.println(Goods.countOfGoods); //2 출력
	}

}
