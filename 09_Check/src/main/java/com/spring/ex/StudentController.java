package com.spring.ex;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	@RequestMapping(value="form" ,method=RequestMethod.GET) // url 입력
	public String form() {
		return "form";
	}
	
	@RequestMapping(value="form",method=RequestMethod.POST ) // type="submit"  
	public String form(HttpServletRequest request, 
						@ModelAttribute("stu") @Valid Student st, 
						BindingResult result) { 
		// command 객체
		// 콘솔 출력
		/*
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		Student st = new Student();
		st.setName(name);
		st.setId(id);
		*/
		System.out.println(st.getName());
		System.out.println(st.getId());
		
		String page = "result";
		
		System.out.println("result.hasErrors():"+result.hasErrors());
		//false : 문제가 없을 때 
		//true : 문제가 있을 때
		
		if(result.hasErrors()) {
			page = "form";
		}
		return page;
	}
}







