package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardContentController {
	
	
	final String command = "/content.bd";
	final String getPage = "contentForm";
	
	@Autowired    
	BoardDao boardDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public ModelAndView doAction(@RequestParam(value="num",required=true) int num) {		
		BoardBean lists = boardDao.getoneBoardList(num);
		 ModelAndView mav = new ModelAndView();      
		 mav.addObject("lists", lists);
		 mav.setViewName(getPage);
		return mav;
	}
}
