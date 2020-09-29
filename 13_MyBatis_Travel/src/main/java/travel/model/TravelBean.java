package travel.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	private int num;
	
	//@NotNull(message="name ����")//�̰� �ȵȴ�
	@NotEmpty(message="name ����")
	private String name;
	
	//@Min(value = 10,message = "10�쿡�� 100����� �Է��ϼ���")
	//@Max(value = 100,message = "10�쿡�� 100����� �Է��ϼ���")
	@Range(min = 10, max = 100, message = "10�쿡�� 100����� �Է��ϼ���")
	private int age;
	
	//@NotEmpty(message="���� �ϳ��� �����ϼ���")
	@NotNull(message="���� �ϳ��� �����ϼ���")
	private String area;
	
	//@NotEmpty(message="����Ÿ�� �ϳ��� �����ϼ���")
	@NotNull(message="����Ÿ�� �ϳ��� �����ϼ���")
	private String style;
	
	//@NotNull(message="���� �ϳ��� �����ϼ���")//�̰� �ȵȴ�
	//@NotEmpty(message="���� �ϳ��� �����ϼ���")
	private String price;
	
	public TravelBean() {
		
	}
	
	public TravelBean(int num, String name, int age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	

}
