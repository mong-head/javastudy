package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;
	
	public RectTriangle(double w, double h) {
		width = w;
		height = h;
	}
	
	public double getArea() {
		return (width * height)/2;
	}
	public double getPerimeter() {
		double middle = Math.sqrt(height*height+width*width);
		return width+height+middle;
	}
}
