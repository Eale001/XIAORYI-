package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.XiaoRyi.Util.FactoryUtil;
import com.neuedu.XiaoRyi.entity.Neu_Account;
import com.neuedu.XiaoRyi.service.Neu_AccountService;

/**
 * 管理员 管理员工 注册处理
 * @author Administrator
 *
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Neu_AccountService neu_userservice=(Neu_AccountService) FactoryUtil.getInstanceObjectByName("Neu_UserService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String user_name=request.getParameter("user[login]");
//		String user_pwd=request.getParameter("user[password]");
//		
//		Neu_Account account=new Neu_Account();
//		account.setNei_empno(nei_empno);
//		System.out.println(user_name);
//		System.out.println(user_pwd);
//		
//		neu_userservice.register(user_name, user_pwd);
		
		request.getRequestDispatcher("NeueduSign_In.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
