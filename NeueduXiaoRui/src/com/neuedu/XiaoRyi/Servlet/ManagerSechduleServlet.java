package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Ask_Leave;
import com.neuedu.XiaoRyi.entity.Neu_CLOCKIN;
import com.neuedu.XiaoRyi.service.Neu_ClockInService;
import com.neuedu.XiaoRyi.service.Neu_ask_leaveService;

/**
 * 服务端 管理员待处理的事项
 * @author Administrator
 *
 */
public class ManagerSechduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Neu_ask_leaveService neu_ask_leaveservice=(Neu_ask_leaveService) FactoryUtil.getInstanceObjectByName("Neu_ask_leaveService");
	private Neu_ClockInService neu_clockinservice=(Neu_ClockInService) FactoryUtil.getInstanceObjectByName("Neu_ClockInService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//待完善(根据时间显示请假事件 还有是否处理显示)
		//String startin=request.getParameter("startin");
		//String startout=request.getParameter("startout");
		
		//查询请假事件
		List<Neu_Ask_Leave> list1=neu_ask_leaveservice.findAll();
		
		Result rs=new Result(1,list1,null);
		response.setContentType("application/JSON");
		response.getWriter().append(rs.toString());
		
		//查询补签时间
		Neu_CLOCKIN  clockin=new Neu_CLOCKIN();
		List<Neu_CLOCKIN> list2=neu_clockinservice.findByExample(clockin);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
