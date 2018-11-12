package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.common.Page;
import com.neuedu.XiaoRyi.pojo.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

/**
 * 客户端  响应 申请的事
 * @author Administrator
 *
 */
public class EmpScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) context.getBean("autoleaveService");
	
	//private Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) FactoryUtil.getInstanceObjectByName("Neu_ask_leaveService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//待完善(根据时间显示请假事件 还有是否处理显示)
		//待处理,根据个人ID进行分页查询
		//String startin=request.getParameter("startin");
		//String startout=request.getParameter("startout");
		
//		int page=1;
//		int total=3;
		
		HttpSession session=request.getSession();
		Long empno=(Long) session.getAttribute("empno");
		
//		String emp=request.getParameter("empno");
//		Long empno=Long.parseLong(emp);
		
		Neu_Ask_Leave leave =new Neu_Ask_Leave();
		leave.setEmpno(empno);
		
		Page page=new Page();
		page.setPageSize(5);
		page.setCurrentPage(1);
		
		List<Neu_Ask_Leave> list=neu_ask_leaveservice.findByPageEmp(page, leave);
		Result rs=new Result(1,list,null);
		response.setContentType("application/JSON");
		response.getWriter().append(rs.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
