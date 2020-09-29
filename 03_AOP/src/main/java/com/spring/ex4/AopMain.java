package com.spring.ex4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
/*
		StudentImpl student = new StudentImpl();
		student.setName("조정석");
		student.setAge(10);
		student.setGradeNum(3);
		student.setClassNum(5);
		
		student.getStudentInfo(); // 핵심기능
*/	
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("aopExam.xml");
		
		Student student = (Student)ctx.getBean("student");
		student.getStudentInfo();
	
		System.out.println("============");
		
		Worker worker = (Worker)ctx.getBean("worker");
		worker.getWorkerInfo();
	}

}

//Hello
//출근합니다.
//안녕하세요
//이름 : 조정석
//나이 : 10
//학년 : 3
//반 : 5
//퇴근합니다.
//=================
//출근합니다.
//이름 : 윤아
//나이 : 35
//직업 : 개발자
//안녕히 계세요
//퇴근합니다.

/*20분*/




