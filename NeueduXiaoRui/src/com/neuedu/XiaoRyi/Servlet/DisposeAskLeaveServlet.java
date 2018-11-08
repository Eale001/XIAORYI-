package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.pojo.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

/**
 * 服务端 处理 请假请求(即 准驳)
 * @author Administrator
 *
 */
public class DisposeAskLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) context.getBean("autoleaveService");
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg=request.getParameter("msg");
		if("1".equals(msg)) {
			String AgreeID=request.getParameter("AgreeID");
			Long agreeid=Long.valueOf(AgreeID);
			
			Neu_Ask_Leave leave=new Neu_Ask_Leave();
			leave.setAsk_leave_id(agreeid);
			leave.setAsk_leave_accept((long)1);
			
			neu_ask_leaveservice.update(leave);
			
			response.getWriter().append("true");
			
			
//			Result rs=new Result(1,null,"成功");
//			response.setContentType("application/JSON");
//			response.getWriter().append(rs.toString());
//			System.out.println(rs.toString());
		}else if("2".equals(msg)) {
			String DISAGREEID=request.getParameter("DISAGREEID");
			Long disagreeid=Long.valueOf(DISAGREEID);
			
			Neu_Ask_Leave leave=new Neu_Ask_Leave();
			leave.setAsk_leave_id(disagreeid);
			leave.setAsk_leave_accept((long)2);
			
			neu_ask_leaveservice.update(leave);
			
			response.getWriter().append("true");
			
			
//			Result rs=new Result(1,null,"处理成功");
//			response.setContentType("application/JSON");
//			response.getWriter().append(rs.toString());
			
			
		}
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
