package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import member.model.Member;
import member.model.MemberDao;
import oracle.net.ns.SessionAtts;

@Controller
public class MemberLoginController {

	final String command = "/loginForm.me";
	final String getPage = "MemberLoginForm";
	
	@Autowired
	MemberDao memberDao;
	
	// ProductInsertController���� get������� �Ѿ��
	@RequestMapping(value=command , method=RequestMethod.GET)
	public String doAction() {
		System.out.println(getClass() + " GET���"); // MemberLoginController GET���
		return getPage;
	}
	
	//MemberLoginForm.jsp���� post������� �Ѿ��
	@RequestMapping(value=command , method=RequestMethod.POST)
	public ModelAndView doAction(Member member, HttpServletResponse response, HttpSession session) throws IOException {
		System.out.println(getClass() + " POST���"); // MemberLoginController POST���
		
		System.out.println("�Է��� id:"+member.getId());
		System.out.println("�Է��� password:" + member.getPassword());
		
		Member dbMember = memberDao.getData(member.getId());
		
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html;charset=UTF-8");
		//ModelAndView mav = new ModelAndView();
		if(dbMember == null) {
			System.out.println("�������� �ʴ� ȸ��");
			//pw.println("�������� �ʴ� ȸ��");
			
			pw.println("<script type='text/javascript'>");
			pw.println("alert('�ش� ���̵� �������� �ʽ��ϴ�.');");
			pw.println("</script>");
			pw.flush();
			return new ModelAndView(getPage);
			
		}
		else {
			System.out.println("�����ϴ� ȸ��");
			/*
			pw.println("<script type='text/javascript'>");
			pw.println("alert('�����ϴ� ȸ���Դϴ�.');");
			pw.println("</script>");
			pw.flush();
			*/
			if(member.getPassword().equals(dbMember.getPassword())) {
				session.setAttribute("loginInfo",dbMember);
				System.out.println(session.getAttribute("destination"));
				//return (String)session.getAttribute("destination");
				//mav.setViewName((String) session.getAttribute("destination"));
				//return mav;
				return new ModelAndView((String) session.getAttribute("destination"));
				//"redirect:/insert.prd"�� �̵�
			}
			else {
				System.out.println("���̵�� ��ġ,����� ����ġ");
				
				pw.println("<script type='text/javascript'>");
				pw.println("alert('����� ��ġ���� �ʽ��ϴ�.');");
				pw.println("</script>");
				pw.flush();
				return new ModelAndView(getPage);
			}
		}
		
	}
}







