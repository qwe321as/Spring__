package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardInsertController {

	final String command = "/insert.bd";
	final String getPage = "WriterForm";
	final String gotoPage = "redirect:/list.bd";
	
	@Autowired    
	BoardDao boardDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("bo") @Valid BoardBean board,
								HttpServletRequest request) {
		 
		board.setIp(request.getRemoteAddr());
		System.out.println(board.getIp());
		
		ModelAndView mav = new ModelAndView();
		boardDao.insertBoard(board);
		mav.setViewName(gotoPage);
		return mav;
		
	}
	
}
