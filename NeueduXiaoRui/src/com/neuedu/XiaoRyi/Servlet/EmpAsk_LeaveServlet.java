package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

/**
 * 客户端 处理  请假 响应
 * @author Administrator
 *
 */
public class EmpAsk_LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) FactoryUtil.getInstanceObjectByName("Neu_ask_leaveService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			HttpSession session=request.getSession();
			Long empno=(Long) session.getAttribute("empno");
			
			//String emp=request.getParameter("empno");
			//Long empno=Long.parseLong(emp);
			
			String leave_begin=request.getParameter("leave_begin").trim();
			Long leave_begintime=format.parse(leave_begin.toString()).getTime();
			
			String leave_end=request.getParameter("leave_end").trim();
			Long leave_endtime = format.parse(leave_end.toString()).getTime();
			
			String leave_type=request.getParameter("leave_type");
			String leave_reason=request.getParameter("leave_reason");
			
			System.out.println(leave_type);
			System.out.println(leave_reason);
			
			System.out.println(leave_begintime);
			System.out.println(leave_endtime);
			
			Neu_Ask_Leave leave=new Neu_Ask_Leave();
			leave.setEmpno(empno);
			leave.setAsk_leave_begin(leave_begintime);
			leave.setAsk_leave_end(leave_endtime);
			leave.setAsk_leave_type(leave_type);
			leave.setAsk_leave_reason(leave_reason);
			
			neu_ask_leaveservice.add(leave);
			
			response.getWriter().append("true");
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
