package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.boardBean;
import board.model.boardDao;
import board.utility.Paging;
@Controller
public class BoardList_Controller {
	private final String gotoList = "list.bo";
	private final String gotoListPage = "list";
	
	@Autowired
	private boardDao boardDao;
	
	@RequestMapping(gotoList)
	public ModelAndView insert(
			@RequestParam(value = "searchColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			@RequestParam(value="searchColumn",required=false) String searchColumn,
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			@RequestParam(value="pageSize", required = false) String pageSize,
							   @RequestParam(value="searchWord",required=false) String searchWord,
							   HttpServletRequest request) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("searchColumn", searchColumn);
		map.put("searchWord", "%"+searchWord+"%");
		int totalCount = boardDao.getboardCount(map);
		String url =request.getContextPath()+"/"+gotoList;
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		
		List<boardBean> lists = boardDao.getboardList(pageInfo,map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists",lists);
		mav.setViewName(gotoListPage);
		mav.addObject("pageInfo",pageInfo);
		mav.addObject("totalCount", totalCount);
		return mav;
	}

}
