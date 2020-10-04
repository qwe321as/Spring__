package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.boardBean;
import board.model.boardDao;
import board.utility.Paging;
@Controller
public class BoardContent_Controller {
	private final String gotoList = "content.bo";
	private final String gotoListPage = "content";
	
	@Autowired
	private boardDao boardDao;
	
	@RequestMapping(gotoList)
	public String insert(@RequestParam("num") int num,Model model) {
		boardBean bean = boardDao.getOneboard(num);
		model.addAttribute("bean",bean);
		return gotoListPage;

	}

}
