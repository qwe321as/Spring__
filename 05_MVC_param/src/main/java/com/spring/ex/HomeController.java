package com.spring.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}

	// person/input요청 => person/result.jsp 
	// http://localhost:8080/ex/person/input?name=kim&age=23
	@RequestMapping("person/input")
	public String input(HttpServletRequest request, Model model) { // new HttpServletRequest()

		String name = request.getParameter("name");
		String age = request.getParameter("age");

		System.out.println("name : " + name); // kim
		System.out.println("age : " + age); // 23

		model.addAttribute("name", name+"씨~"); // name=kim씨~
		model.addAttribute("age", age+"살~");  // age=23살

		return "person/result";
	}

	@RequestMapping("form")
	public String form() {
		return "person/personInput";
	}

	@RequestMapping(value = "person/join1"/* , method=RequestMethod.POST */)
	public String join1(HttpServletRequest request,Model model) {
		System.out.println("join1()");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");

		model.addAttribute("Mname", name+"님~");

		return "person/personView1";
	}

	// person/join2 요청 => person/personView2
	@RequestMapping(value="person/join2")
	public String join2(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("addr") String addr,
			Model model) {

		System.out.println("id:" + id);
		System.out.println("pw:" + pw);
		System.out.println("name:" + name);
		System.out.println("addr:" + addr);

		Person per = new Person(id,pw,name,addr); 
		model.addAttribute("per", per);

		return "person/personView2";
	}//

	// person/join3 요청 => person/personView3
	@RequestMapping(value="person/join3")
	public String join3(Person p) {
		//Person p : command 객체
		/*
		Person p에는 아래의 의미가 들어있다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		Person p = new Person(); 
		p.setId(id);
		p.setPw(pw);
		p.setName(name);
		p.setAddr(addr);
		*/
		
		System.out.println("p.getId():"+p.getId());
		
		return "person/personView3";
	} //
	
	// person/join4 요청 => person/personView4
	@RequestMapping(value="person/join4")
	public String join4( @ModelAttribute("abcd") Person p) {
		
		System.out.println("p.getId():"+p.getId());
		
		return "person/personView4";
	}
}















