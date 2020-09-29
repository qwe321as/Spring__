package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sample")
public class SampleController {
	
	//sample/input¿äÃ» => sample/input.jsp
	//@RequestMapping("sample/input")
	@RequestMapping("/input")
	public String input() {
		return "sample/input";
		// /WEB-INF/views/sample/input
	}
	
	//@RequestMapping("sample/list")
	@RequestMapping("/list")
	public String list() {
		return "sample/list";
		// /WEB-INF/views/sample/input
	}
	
}



