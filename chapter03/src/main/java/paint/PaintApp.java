package paint;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point();
		Point point2 = new Point(20,30);
		point1.setX(10);
		point1.setY(20);
		point1.show();
		point2.show(true);
		
		point1.show(false);
		
		Point point3 = new ColorPoint();
		point3.setX(50);
		point3.setY(50);
		((ColorPoint)point3).setColor("red"); //다운캐스팅으로 명시를 해야 자식 함수 사용 가능
		
		//동일 결과 (boolean있는거는 override안했지만 코드 재사용으로 같은 결과가 나옴)
		point3.show();
		point3.show(true); 
	}
}
