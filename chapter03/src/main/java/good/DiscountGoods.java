package good;

public class DiscountGoods extends Goods {
	private float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		//price : 부모의 protected 변수
		return price * discountRate;
	}
}
