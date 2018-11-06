package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.StatisticWork;
import com.neuedu.XiaoRyi.service.Neu_StatisticService;

/**
 * 客户端 处理 考勤预览 请求
 * @author Administrator
 *
 */
public class EmpPreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Neu_StatisticService neu_statisticservice=(Neu_StatisticService) FactoryUtil.getInstanceObjectByName("Neu_StatisticService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Long empno=(Long) session.getAttribute("empno");
		System.out.println(empno);
//		String emp=request.getParameter("empno");
//		Long empno=Long.parseLong(emp);
		
		String startin=request.getParameter("startin");
		String startout=request.getParameter("startout");
		Optional<StatisticWork> opt=neu_statisticservice.findbyEmpno(empno, startin, startout);
		
		StatisticWork stw=opt.get();
		
		Result rs=new Result(1,stw,null);
		response.setContentType("application/JSON");
		response.getWriter().append(rs.toString());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
