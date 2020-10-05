package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardDao;

@Controller
public class BoarddeleteController {
	
	final String command = "/delete.bd";
	final String gotoPage = "redirect:/list.bd";
	
	@Autowired    
	BoardDao boardDao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam(value="num",required=true) int num) {
		
		boardDao.deleteboard(num);
		
		return gotoPage;
	}
}
