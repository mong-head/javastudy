package paint;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point();
		Point point2 = new Point(20,30);
		point1.setX(10);
		point1.setY(20);
		point1.show();
		point2.show(true);
//		drawColorPoint(point2);
		draw(point2);
		
		point1.show(false);
		
		Point point3 = new ColorPoint();
		point3.setX(50);
		point3.setY(50);
		((ColorPoint)point3).setColor("red"); //다운캐스팅으로 명시를 해야 자식 함수 사용 가능
		
		//동일 결과 (boolean있는거는 override안했지만 코드 재사용으로 같은 결과가 나옴)
//		point3.show();
//		point3.show(true); 
//		
		//drawColorPoint(point3);
		draw(point3);
		
		Point point4 = new ColorPoint(50,100,"red");
		
		Shape rect = new Rect(); //Rect rect = new Rect() 라고 해도 됨
		Shape tri = new Triangle();
		Shape cir = new Circle();
//		drawShape(rect);
//		drawShape(tri);
//		drawShape(cir);
		draw(rect);
		draw(tri);
		draw(cir);
		
		Drawable drawable = new GraphicText("hello");
		draw(drawable);
	}
	
//	public static void drawColorPoint(Point pt) {
//		pt.show();
//	}
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	public static void draw(Drawable drawable) {
		drawable.draw();
	}
}
