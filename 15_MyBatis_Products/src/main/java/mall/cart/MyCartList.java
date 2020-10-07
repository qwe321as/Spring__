package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {

	//key 상품번호, value 주문수량 Map은 인터페이스
	private Map<Integer,Integer> orderlists =null;
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();		
	}
	public void addOrder(int num, int orderqty) {
		if (orderlists.containsKey(num)) {//이미있는 것
			 int oldqty=orderlists.get(num);
			orderlists.put(num, orderqty+oldqty);
		}else {//새상품
			orderlists.put(num, orderqty);
		}
	}
	public Map<Integer, Integer> getAllOrderLists() {
		
		return orderlists;
	}
}
