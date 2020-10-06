package product.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {
final String command = "/delete.prd";
final String gotoPage="redirect:/list.prd";
@Autowired
ProductDao dao;
@Autowired
ServletContext servletContext;
@RequestMapping(command)
public String doAction(@RequestParam("num") String num, Model model, HttpSession session) throws IllegalStateException, IOException {
	if (session.getAttribute("loginInfo")==null) {
		session.setAttribute("destination", "redirect:/update.prd");
		return "redirect:/loginForm.me";
	}
	Product product = new Product();
	product= dao.Content(num);
	String uploadPath=servletContext.getRealPath("/resources/");
	File file = new File(uploadPath+product.getImage());
	file.delete();
	dao.delete(num);
	return gotoPage;
}

}
