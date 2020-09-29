package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PDao;
import com.spring.ex.dto.PDto;

public class PmodifyCommand implements PCommand{

	@Override
	public void execute(HttpServletRequest request) {
		
		int num= Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		PDto dto = new PDto(num, id, name, age);
		PDao dao = PDao.getInstance();
		dao.modify(dto);
		
	}
	
}

