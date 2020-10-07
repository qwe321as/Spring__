package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {

	//key ��ǰ��ȣ, value �ֹ����� Map�� �������̽�
	private Map<Integer,Integer> orderlists =null;
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();		
	}
	public void addOrder(int num, int orderqty) {
		if (orderlists.containsKey(num)) {//�̹��ִ� ��
			 int oldqty=orderlists.get(num);
			orderlists.put(num, orderqty+oldqty);
		}else {//����ǰ
			orderlists.put(num, orderqty);
		}
	}
	public Map<Integer, Integer> getAllOrderLists() {
		
		return orderlists;
	}
}
