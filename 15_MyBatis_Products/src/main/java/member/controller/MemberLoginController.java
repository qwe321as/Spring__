package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberLoginController {

	final String command = "/loginForm.me";
	final String getPage = "MemberLoginForm";
	
	
	// ProductInsertController���� �Ѿ��
	@RequestMapping(command)
	public String doAction() {
		
		return getPage;
	}
}
