package album.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumDao;

@Controller
public class AlbumDeleteController {
	
	final String command = "delete.ab";
	final String gotoPage = "redirect:/list.ab";
	
	@Autowired
	private AlbumDao albumDao;
	ModelAndView mav = new ModelAndView();

	@RequestMapping(command)
	public ModelAndView doAction(@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize
			) {
		
		albumDao.deleteAlbum(num);
		mav.setViewName(gotoPage+"?pageNumber="+pageNumber+"&pageSize="+pageSize);
		return mav;
		
	}
}








