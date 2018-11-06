package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

/**
 * 客户端  响应 待批准的事
 * @author Administrator
 *
 */
public class EmpScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) FactoryUtil.getInstanceObjectByName("Neu_ask_leaveService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//待完善(根据时间显示请假事件 还有是否处理显示)
		//String startin=request.getParameter("startin");
		//String startout=request.getParameter("startout");
		
		HttpSession session=request.getSession();
		Long empno=(Long) session.getAttribute("empno");
		
//		String emp=request.getParameter("empno");
//		Long empno=Long.parseLong(emp);
		
		Neu_Ask_Leave leave =new Neu_Ask_Leave();
		leave.setEmpno(empno);
		
		List<Neu_Ask_Leave> list=neu_ask_leaveservice.findByExample(leave);
		Result rs=new Result(1,list,null);
		response.setContentType("application/JSON");
		response.getWriter().append(rs.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
