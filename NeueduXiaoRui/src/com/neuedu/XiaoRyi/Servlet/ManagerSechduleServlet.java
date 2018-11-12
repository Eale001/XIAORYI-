package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.common.Page;
import com.neuedu.XiaoRyi.pojo.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.pojo.Neu_CLOCKIN;
import com.neuedu.XiaoRyi.service.Neu_ClockInService;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

/**
 * 服务端 管理员待处理的事项
 * @author Administrator
 *
 */
public class ManagerSechduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) context.getBean("autoleaveService");
	
	Neu_ClockInService neu_clockinservice=(Neu_ClockInService) context.getBean("autoClockService");
	
	//private Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) FactoryUtil.getInstanceObjectByName("Neu_ask_leaveService");
	//private Neu_ClockInService neu_clockinservice=(Neu_ClockInService) FactoryUtil.getInstanceObjectByName("Neu_ClockInService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//待完善(根据时间显示请假事件 还有是否处理显示)
		
		String page1=request.getParameter("page");
		int p=Integer.valueOf(page1);
		
		String total=request.getParameter("total");
		int t=Integer.valueOf(total);
		
		//String startin=request.getParameter("startin");
		//String startout=request.getParameter("startout");
		
		Page page=new Page();
		page.setPageSize(t);
		page.setCurrentPage(p);
		
		Neu_Ask_Leave leave=new Neu_Ask_Leave();
		
		//leave.setAsk_leave_begin(Long.parseLong(startin));
		//leave.setAsk_leave_end(Long.parseLong(startout));
		leave.setAsk_leave_accept((long)0);
		//待处理
		//查询请假事件
		
		List<Neu_Ask_Leave> list1=neu_ask_leaveservice.findByPageEmp(page, leave);
		
		//查询补签事件
		Neu_CLOCKIN  clockin=new Neu_CLOCKIN();
		clockin.setNeu_clockin_startin(null);
		clockin.setNeu_clockin_startout(null);
		List<Neu_CLOCKIN> list2=neu_clockinservice.findByExample(clockin);
		
		Set set=new HashSet();
		set.addAll(list1);
		List list = new ArrayList(set);
		
		Result rs=new Result(1,list,null);
		response.setContentType("application/JSON");
		response.getWriter().append(rs.toString());
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
