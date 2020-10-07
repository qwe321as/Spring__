package order.model;

import java.sql.Date;

public class Order {
	 private int oid;
	 private String mid;
	 private  Date orderdate;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Order() {
		super();
	}
	public Order(int oid, String mid, Date orderdate) {
		super();
		this.oid = oid;
		this.mid = mid;
		this.orderdate = orderdate;
	}
	 
}
