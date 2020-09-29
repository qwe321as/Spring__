package Basic;

public class RectangleImpl implements Rectangle{

	Shape pointy; // new PointY()
	int x;
	int y;
	int radius;
	
	public Shape getPointy() {
		return pointy;
	}

	public void setPointy(Shape pointy) {
		this.pointy = pointy;
		System.out.println("setPointy(Shape pointy)");
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public String make() {
		return pointy.make();
	}

}




