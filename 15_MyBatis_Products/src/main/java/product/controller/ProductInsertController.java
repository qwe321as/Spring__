package product.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductInsertController {
	final String command = "/insert.prd";
	final String getPage = "ProductInsertForm";
	
	@RequestMapping(command)
	public String doAction(HttpSession session) {
		
		System.out.println("loginInfo : " + session.getAttribute("loginInfo")); // null
		
		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/insert.prd");
			return "redirect:/loginForm.me";
		}
		else {
			return getPage;
		}
	}
}









