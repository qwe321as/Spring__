package board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.boardBean;
import board.model.boardDao;

@Controller
public class Boardreply_Controller {
	
	final String gotoInsert = "reply.bo";
	final String gotoInsertPage = "replyForm";
	final String gotoListPage = "redirect:/list.bo";
	
	@Autowired
	private boardDao boardDao;
	
	@RequestMapping(value=gotoInsert,method=RequestMethod.GET)
	public String insert() {
		return gotoInsertPage;
	}
	
	@RequestMapping(value=gotoInsert,method=RequestMethod.POST)
	public ModelAndView insert(@Valid boardBean board,BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(gotoInsertPage);
			return mav;
		}
		int cnt = boardDao.insertboard(board);
		mav.setViewName(gotoListPage);
		return mav;
	}
	

}
