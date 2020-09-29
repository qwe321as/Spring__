package travel.controller;

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

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {
	final String command = "/update.tv";
	final String getPage = "TravelUpdateForm";
	final String gotoPage = "redirect:/list.tv";

	@Autowired
	TravelDao travelDao;

	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(@RequestParam("num") int num, Model model,
			@RequestParam(value = "pageNumber") int pageNumber
			) {
		TravelBean travel = travelDao.getOneTravel(num);
		model.addAttribute("travel", travel);
		model.addAttribute("pageNumber", pageNumber );
		return getPage;
	}
	@RequestMapping(value=command,method=RequestMethod.POST)
	   public ModelAndView update( @RequestParam("pageNumber") int pageNumber,
	                         @ModelAttribute("travel") @Valid TravelBean travel,
	                        BindingResult result) {
	      
	      ModelAndView mav = new ModelAndView();
	      if(result.hasErrors()) {
	         mav.addObject("pageNumber",pageNumber);
	         mav.setViewName(getPage);
	         return mav;
	      }
	      int cnt = travelDao.updateTravel(travel);
	      if(cnt>=1) {
	         mav.setViewName(gotoPage+"?pageNumber="+pageNumber);
	      }
	      else {
	         mav.setViewName(getPage);
	      }
	      return mav;
	      
	   }
}






