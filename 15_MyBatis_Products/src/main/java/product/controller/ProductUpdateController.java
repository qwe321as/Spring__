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
public class ProductUpdateController {
final String command = "/update.prd";
final String getpage="ProductUpdateForm";
final String gotoPage="redirect:/list.prd";
@Autowired
ProductDao dao;
@Autowired
ServletContext servletContext;
@RequestMapping(value=command, method = RequestMethod.GET)
public String doAction(@RequestParam("num") String num, Model model, HttpSession session) {
	if (session.getAttribute("loginInfo")==null) {
		session.setAttribute("destination", "redirect:/update.prd?num="+num);
		return "redirect:/loginForm.me";
	}
	Product product = new Product();
	product= dao.Content(num);
	model.addAttribute("product",product);
	return getpage;
}
@RequestMapping(value=command, method = RequestMethod.POST)
public String doAction(@Valid Product product,BindingResult result) throws IllegalStateException, IOException {
	if (result.hasErrors()) {
		return getpage;
	}
	String uploadPath=servletContext.getRealPath("/resources/");
	MultipartFile multi = product.getUpload();
	File file = new File(uploadPath+product.getImage());
	File delfile = new File(uploadPath+product.getUploadOld());
	delfile.delete();
	multi.transferTo(file);
	dao.update(product);
	return gotoPage;
}
}
