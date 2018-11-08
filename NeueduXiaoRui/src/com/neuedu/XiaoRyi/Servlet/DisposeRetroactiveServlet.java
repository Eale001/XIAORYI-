package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.service.Neu_ClockInService;

/**
 * 服务端 处理补签请求(即准驳)
 * @author Administrator
 *
 */
public class DisposeRetroactiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Neu_ClockInService neu_clockinservice=(Neu_ClockInService) context.getBean("autoClockService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
