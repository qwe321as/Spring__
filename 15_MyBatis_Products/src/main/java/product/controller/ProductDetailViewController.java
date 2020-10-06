package product.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDetailViewController {
	final String command="/detail.prd";
	final String getPage="ProductDetailView";
	@Autowired
	ProductDao dao;
	@RequestMapping(command)
	public String doaction(@RequestParam(value = "num", required = true) String num , Model model) {
		Product product = new Product();
		product= dao.Content(num);
		System.out.println(product.getName());
		model.addAttribute("product", product);
		return getPage;
	}
}
