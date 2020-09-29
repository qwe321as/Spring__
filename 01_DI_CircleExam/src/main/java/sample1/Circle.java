package sample1;

public class Circle {
	private double radius; // 반지름
	private Point point;
	
	public Circle(double radius, Point point) {
		super();
		this.radius = radius;
		this.point = point;
	}
	
	public void display() {
		System.out.println("원의 중심 : " + point.getXpos() +"," + point.getYpos());
		System.out.println("원의 면적 : " + getArea());
	}
	public double getArea(){
		return Math.PI * Math.pow(radius, 2.0); // 3.14 * radius의 2.0승
	}
}
