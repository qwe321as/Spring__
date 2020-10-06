package member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;

@Controller
public class MemberRegisterController {
	final String command = "registerForm.me";
	final String getPage = "MemberRegisterForm";
	final String gotoPage = "redirect:/list.me"; // MemberListController
	
	@Autowired
	MemberDao memberDao;
	
	// MemberLoginForm.jsp ���� ��û��
	@RequestMapping(value=command, method=RequestMethod.GET) // MemberLoginForm.jsp���� �Ѿ��
	public String doAction() {
		
		return getPage;
	}
	
	//MemberRegisterForm.jsp ���� ��û�� 
	@RequestMapping(value=command, method=RequestMethod.POST) // MemberLoginForm.jsp���� �Ѿ��
	public ModelAndView doAction(@Valid Member member,
							BindingResult result) {
		 
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		memberDao.insertData(member);
		
		 
		mav.setViewName(gotoPage);
		return mav;
	}
}


