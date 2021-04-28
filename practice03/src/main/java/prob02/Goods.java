package prob02;

public class Goods {
	private String name;
	private int cost;
	private int num;
	
	public void setName(String n) {
		this.name = n;
	}
	public String getName() {
		return this.name;
	}
	public void setCost(int c) {
		this.cost = c;
	}
	public int getCost() {
		return this.cost;
	}
	public void setNum(int n) {
		this.num = n;
	}
	public int getNum() {
		return this.num;
	}
	
	public void printAll() {
		System.out.printf("%s(가격:%d)이 %d개 입고 되었습니다.\n",this.name,this.cost,this.num);
	}
}
