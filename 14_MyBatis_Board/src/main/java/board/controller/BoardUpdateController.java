package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardUpdateController {
	
	final String command = "/update.bd";
	final String getPage = "UpdateForm";
	final String gotoPage = "redirect:/list.bd";
	
	@Autowired    
	BoardDao boardDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(@RequestParam("num")int num,
							Model model							
			) {
		BoardBean board = boardDao.getoneBoardList(num);
		model.addAttribute("board", board);				
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("bo") @Valid BoardBean board,
								HttpServletRequest request) {
		 		
		ModelAndView mav = new ModelAndView();
		boardDao.updateBoard(board);
		mav.setViewName(gotoPage);
		return mav;
		
	}
}
