package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.Member;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetail;
import orderdetail.model.OrderDetailDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController {//mallList.jsp 결재하기 클릭했을떄
	final String command = "calculate.mall";
	final String gotoPage="redirect:/list.prd";
	@Autowired
	MemberDao mamberdao;
	@Autowired
	ProductDao productdao;
	@Autowired
	OrderDao orderdao;
	@Autowired
	OrderDetailDao orderdetaildao;
	@RequestMapping(value = command)
	public String doaction(HttpSession session ) {
	      MyCartList mycart = (MyCartList)session.getAttribute("mycart");
	      Map<Integer, Integer>  maplists =mycart.getAllOrderLists();
	      Set<Integer> keylist = maplists.keySet();
		System.out.println("keylist : "+keylist);
		Member member = (Member)session.getAttribute("loginInfo");
		orderdao.insertDate(member.getId());
		int maxoid = orderdao.getMaxoid();
		for (Integer pnum : keylist){
			Integer qty = maplists.get(pnum);
			productdao.updateStock(pnum,qty);
			OrderDetail odBean = new OrderDetail();
			odBean.setOid(maxoid);
			odBean.setPnum(pnum);
			odBean.setQty(qty);
			orderdetaildao.insertData(odBean);
		}
		mamberdao.updatepoint(member.getId(),100);
		session.removeAttribute("mycart");
		return gotoPage;
	}
}
