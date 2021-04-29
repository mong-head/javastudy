package com.douzone.paint.main;

import com.douzone.paint.i.*;
import com.douzone.paint.shape.*;
import com.douzone.paint.text.*;

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
		Circle cir = new Circle();
//		drawShape(rect);
//		drawShape(tri);
//		drawShape(cir);
		draw(rect);
		draw(tri);
		draw(cir);
		
		Drawable drawable = new GraphicText("hello");
		draw(drawable);
		
		// instanceof test
		System.out.println("\nCircle cir = new Circle()");
		System.out.println("cir instanceof Object: "+(cir instanceof Object)); //true
		System.out.println("cir instanceof Shape: "+(cir instanceof Shape)); //true
		System.out.println("cir instanceof Circle: "+(cir instanceof Circle)); //true
		//System.out.println("cir instanceof Rect: "+(cir instanceof Rect)); 
		//사용불가능: class는 hierarchy 상 하위만 instanceof연산자 가능
		System.out.println("cir instanceof Rect : 사용 불가능");
		
		Shape s= new Circle();
		System.out.println("\nShape s= new Circle()");
		System.out.println("s instanceof Object: "+(s instanceof Object));
		System.out.println("s instanceof Shape: "+(s instanceof Shape));
		System.out.println("s instanceof Circle: "+(s instanceof Circle));
		System.out.println("s instanceof Rect: "+(s instanceof Rect));
		
		//interface는 hierarchy상관없이 instanceof 사용가능
		System.out.println("\ninferface");
		System.out.println("s instanceof Drawable: "+(s instanceof Drawable));
		System.out.println("s instanceof Runnable: "+(s instanceof Runnable)); //Runnable : thread관련
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
