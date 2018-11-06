package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.StatisticWork;
import com.neuedu.XiaoRyi.service.Neu_StatisticService;

/**
 * 服务端 管理员 统计分析(考勤报表)
 * @author Administrator
 *
 */
public class ManagerStatisticalAnalysisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Neu_StatisticService neu_statisticservice=(Neu_StatisticService) FactoryUtil.getInstanceObjectByName("Neu_StatisticService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startin=request.getParameter("startin");
		String startout=request.getParameter("startout");
		List<StatisticWork> list=neu_statisticservice.findAll(startin, startout);
		
		Result rs=new Result(1,list,null);
		response.setContentType("application/JSON");
		response.getWriter().append(rs.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
