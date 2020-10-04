package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.boardBean;
import board.model.boardDao;

@Controller
public class BoardDelete_Controller {
	
	final String gotoInsert = "deleteForm.bo";
	final String gotoInsertPage = "deleteForm";
	final String gotoListPage = "redirect:/list.bo";
	
	@Autowired
	private boardDao boardDao;

	@RequestMapping(value=gotoInsert,method=RequestMethod.GET)
	public String insert() {
		return gotoInsertPage;
	}
	
	@RequestMapping(value=gotoInsert,method=RequestMethod.POST)
	public String delete(@RequestParam("passwd") String passwd,@RequestParam("num") int num
			) {
		int cnt = 0;
		boardBean board = null;
		board = boardDao.deletepasswd(passwd);
		if (num==board.getNum()) {
			cnt = boardDao.deleteboard(num);
		}
		if (cnt>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		return gotoListPage;
	}

}
