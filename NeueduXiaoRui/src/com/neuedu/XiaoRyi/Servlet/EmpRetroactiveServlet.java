package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.pojo.Neu_CLOCKIN;
import com.neuedu.XiaoRyi.service.Neu_ClockInService;

/**
 * 客户端 处理 补签 响应
 * @author Administrator
 *
 */
public class EmpRetroactiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Neu_ClockInService neu_clockinservice=(Neu_ClockInService) context.getBean("autoClockService");
	
	//private Neu_ClockInService neu_clockinservice=(Neu_ClockInService) FactoryUtil.getInstanceObjectByName("Neu_ClockInService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			
			
			String restroactivein=request.getParameter("restroactivein").trim();
			String restroactiveinH=request.getParameter("restroactiveinH").trim();
			String restroactiveinZ=restroactivein+" "+restroactiveinH;
			Long restroactiveintime=format.parse(restroactiveinZ.toString()).getTime();
			
			String restroactiveout=request.getParameter("restroactiveout").trim();
			String restroactiveoutH=request.getParameter("restroactiveoutH").trim();
			String restroactiveoutZ=restroactiveout+" "+restroactiveoutH;
			Long restroactiveouttime = format.parse(restroactiveoutZ.toString()).getTime();
			
			String restroactive_reason=request.getParameter("restroactive_reason");
			
			System.out.println(restroactiveintime);
			
			System.out.println(restroactiveouttime);
			System.out.println(restroactive_reason);
			
			Neu_CLOCKIN clockin=new Neu_CLOCKIN();
			//差一个id
			clockin.setNeu_empno((long)11);
			clockin.setNeu_retroactivein(restroactiveintime);
			clockin.setNeu_retroactiveout(restroactiveouttime);
			

			neu_clockinservice.update(clockin);
			response.getWriter().append("3");
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
