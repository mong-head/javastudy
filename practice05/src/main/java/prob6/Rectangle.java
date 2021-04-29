package prob6;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;
	
	public Rectangle(double w, double h) {
		width = w;
		height = h;
	}
	
	public void resize(double s) {
		width = width * s;
		height = height * s;
	}
	
	public double getArea() {
		return width * height;
	}
	public double getPerimeter() {
		return 2*(width+height);
	}
}
