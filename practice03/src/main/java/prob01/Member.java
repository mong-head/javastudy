package prob01;

public class Member {
	private String id;
	private String name;
	private int point;
	
	public void setName(String n){
		this.name = n;
	}
	public String getName(){
		return this.name;
	}
	public void setPoint(int p){
		this.point = p;
	}
	public int getPoint(){
		return this.point;
	}
	public void setId(String i){
		this.id = i;
	}
	public String getId(){
		return this.id;
	}
}