package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductInsertController {
	final String command = "/insert.prd";
	final String getPage = "ProductInsertForm";
	final String gotoPage = "redirect:/list.prd";
	@Autowired
	ProductDao dao;	
	@Autowired
	ServletContext servletContext;
	@RequestMapping(value = command,method = RequestMethod.GET)
	public String doAction(HttpSession session) {

		System.out.println("loginInfo : " + session.getAttribute("loginInfo")); // null

		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/insert.prd");
			return "redirect:/loginForm.me";
		}
		else {
			return getPage;
		}
	}

	@RequestMapping(value = command,method = RequestMethod.POST)
	public ModelAndView doAction(@Valid Product product,BindingResult result) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
			//return new ModelAndView(getPage);
		}
		else {
		/* request.getcontextPath() */
		System.out.println("servletContext.getRealPath: "+servletContext.getRealPath("/"));
		// C:\Spring__\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\15_MyBatis_Products\
		String uploadPath=servletContext.getRealPath("/resources");
		System.out.println("uploadPath= "+uploadPath);
		MultipartFile multi = product.getUpload();
		// uploadPath= C:\Spring__\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\15_MyBatis_Products\resources
		System.out.println("선택한 파일명: "+product.getImage());
		File file = new File(uploadPath + File.separator +product.getImage());
		multi.transferTo(file);
		//파일정보를 올릴떄  transferto이거 사용한다.
		dao.insertData(product);
		mav.setViewName(gotoPage);
		return mav;
		}
	}
}









