package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Emp;
import com.neuedu.XiaoRyi.service.Neu_AccountService;

/**
 * 管理员 创建员工用户唯一验证
 * @author Administrator
 *
 */
public class UniquenessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Neu_AccountService neu_userservice=(Neu_AccountService) FactoryUtil.getInstanceObjectByName("Neu_UserService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String username=request.getParameter("username");
//		System.out.println(username);
//		
//		Neu_Emp user=new Neu_Emp();
//		user.setNeu_name(username);
//		
//		if(neu_userservice.findByExample(user).size()>0) {
//			 
//			 response.getWriter().append("true");
//		}else {
//			response.getWriter().append("false");
//		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
