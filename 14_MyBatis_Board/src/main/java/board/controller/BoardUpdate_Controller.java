package board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.boardBean;
import board.model.boardDao;

@Controller
public class BoardUpdate_Controller {
	
	final String gotoUpdate = "update.bo";
	final String gotoUpdatePage = "updateForm";
	final String gotoListPage = "redirect:/list.bo";
	
	@Autowired
	private boardDao boardDao;
	
	@RequestMapping(value=gotoUpdate,method=RequestMethod.GET)
	public String update(@RequestParam("num") int num, Model model) {
		boardBean board = boardDao.getOneboard(num);
		model.addAttribute("board",board);
		return gotoUpdatePage;
	}
	
	@RequestMapping(value=gotoUpdate,method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("board") @Valid boardBean board,
						BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(gotoUpdatePage);
		}
		int cnt = boardDao.updateboard(board);
		if(cnt>0) {
			mav.setViewName(gotoListPage);
		}
		else {
			mav.setViewName(gotoUpdatePage);
		}
		return mav;
		
	}

}
