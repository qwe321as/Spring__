package Basic2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//RectangleImpl myRectangleImpl = new RectangleImpl();
@Component("myRectangleImpl")
public class RectangleImpl implements Rectangle{
	@Autowired
	@Qualifier("PointY")
	Shape pointy; // new PointY()
	int x;
	int y;
	int radius;
	
	public Shape getPointy() {
		return pointy;
	}

//	public void setPointy(Shape pointy) {
//		this.pointy = pointy;
//		System.out.println("setPointy(Shape pointy)");
//	}

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




