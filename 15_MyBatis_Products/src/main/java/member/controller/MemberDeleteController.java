package member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;
import utility.Paging;

@Controller
public class MemberDeleteController {
	final String command = "/delete.me";
	final String getPage = "redirect:/list.me";
	//final String gotoPage = "redirect:/list.me";
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(@RequestParam("id") String id) {
		
		memberDao.delete(id);
		 
		ModelAndView mav = new ModelAndView();
		mav.setViewName(getPage);
		return mav;
	}
}