package mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import mall.cart.ShoppingInfo;
import product.model.Product;
import product.model.ProductDao;

@Controller
public class CartListController { // CartAddController���� �Ѿ�� 

   final String command = "list.mall";
   final String getPage = "MallList"; 
   @Autowired
   ProductDao dao;
   
   @RequestMapping(value=command) 
   public String doAction(HttpSession session) {
      
      MyCartList mycart = (MyCartList)session.getAttribute("mycart");
      
      Map<Integer,Integer> maplists = mycart.getAllOrderLists();
      System.out.println("��ٱ��� ��ǰ ���� : "+maplists.size());
      
      Set<Integer> keylist = maplists.keySet();
      System.out.println("keylist : " + keylist);
      List<ShoppingInfo> shoplists = new ArrayList<ShoppingInfo>();
int totalAmount = 0;
      for (Integer pnum : keylist) {
    	  Integer oqty = maplists.get(pnum);
    	  System.out.println(pnum+":"+oqty);
    	  System.out.println(maplists.toString());
    	  Product bean = dao.Content(pnum);
    	  ShoppingInfo shopingInfo = new ShoppingInfo();
    	  shopingInfo.setPnum(bean.getNum());
    	  shopingInfo.setPname(bean.getName());
    	  shopingInfo.setQty(oqty);
    	  shopingInfo.setPrice(bean.getPrice());
    	  shopingInfo.setAmount(bean.getPrice()*oqty);
    	  shoplists.add(shopingInfo);
    	  totalAmount += bean.getPrice() * oqty;
    	  
	}
      session.setAttribute("totalAmount", totalAmount);
      session.setAttribute("shoplists", shoplists);
      return getPage;//��ȣ, ��ǰ��, �ֹ�����, �ܰ� , �ݾ�
   }
         
         
}






