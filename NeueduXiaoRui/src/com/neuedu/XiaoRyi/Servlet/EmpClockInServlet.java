package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_CLOCKIN;
import com.neuedu.XiaoRyi.service.Neu_ClockInService;

/**
 * 客户端 处理  打卡时间
 * @author Administrator
 *
 */
public class EmpClockInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Neu_ClockInService neu_clockinservice=(Neu_ClockInService) FactoryUtil.getInstanceObjectByName("Neu_ClockInService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nowtimestamp=request.getParameter("date");
		String empno=request.getParameter("empno");
		
		Long nowstamp=Long.parseLong(nowtimestamp);
		Long empid=Long.parseLong(empno);
		
		System.out.println(nowtimestamp);
		System.out.println(empno);
		
		//格式化
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//获取当天9:00 和 9:10
		LocalDate nowdate=LocalDate.now();
		LocalDateTime localtime=LocalDateTime.of(nowdate,LocalTime.of(9, 00));
		LocalDateTime localtime1=LocalDateTime.of(nowdate,LocalTime.of(9, 30));
		//获取当天的 17:30到18:00
		LocalDateTime localtime3=LocalDateTime.of(nowdate,LocalTime.of(17, 30));
		LocalDateTime localtime4=LocalDateTime.of(nowdate,LocalTime.of(18, 00));
		

		try {
			String time=dtf.format(localtime);
			Long time1=format.parse(time).getTime();
			
			String time4=dtf.format(localtime1);
			Long time5=format.parse(time4).getTime();
			
			String time6=dtf.format(localtime3);
			Long time7=format.parse(time6).getTime();
			
			String time8=dtf.format(localtime4);
			Long time9=format.parse(time8).getTime();
			
			if(time1.longValue()<=nowstamp.longValue() && nowstamp.longValue()<=time5.longValue()) {
				
				Neu_CLOCKIN clockin=new Neu_CLOCKIN();
				
				clockin.setNeu_clockin_startin(nowstamp);
				clockin.setNeu_clockin_startout(nowstamp);
				clockin.setNeu_empno(empid);
				
				neu_clockinservice.add(clockin);
				
				response.getWriter().append("1");
			}else if(time7.longValue()<=nowstamp.longValue() && nowstamp.longValue()<=time9.longValue()){
				
				Neu_CLOCKIN clockin=new Neu_CLOCKIN();
				
				clockin.setNeu_clockin_startout(nowstamp);
				
				neu_clockinservice.update(clockin);
				response.getWriter().append("2");
			}else {
				response.getWriter().append("现在时间不能打卡!");
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
