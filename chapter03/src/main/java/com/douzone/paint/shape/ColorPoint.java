package com.douzone.paint.shape;

public class ColorPoint extends Point {
	private String color;
	public ColorPoint() {
		super();
		this.color = null;
	}
	public ColorPoint(int x, int y, String color) {
//		setX(x);
//		setY(y);
		super(x,y);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		System.out.printf("점[%d,%d,%s]에 점을 그렸습니다.\n",getX(),getY(),color);
	}
	
}
