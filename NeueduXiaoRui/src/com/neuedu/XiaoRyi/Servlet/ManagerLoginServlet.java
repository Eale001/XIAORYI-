package com.neuedu.XiaoRyi.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.pojo.Neu_Account;
import com.neuedu.XiaoRyi.service.Neu_AccountService;

/**
 * 管理员  处理 登录 请求
 * @author Administrator
 *
 */
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Neu_AccountService neu_userservice=(Neu_AccountService) context.getBean("autoaccountService");
	
	//private Neu_AccountService neu_userservice=(Neu_AccountService) FactoryUtil.getInstanceObjectByName("Neu_AccountService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name=request.getParameter("user[login]").trim();
		String user_pwd=request.getParameter("user[password]").trim();
		
		
		System.out.println(user_name);
		System.out.println(user_pwd);
		
		//验证登录
		Optional<Neu_Account> opt=neu_userservice.login(user_name, user_pwd);
		if(!opt.isPresent()) {
			String path=request.getContextPath();
			String realpath=path +File.separator+"Neu_Account_login.html";
			response.sendRedirect(realpath);
			return;
		}
		HttpSession session=request.getSession();
		session.setAttribute("account", opt.get().getNei_empno());	
		request.getRequestDispatcher("Neuedu_Home.html").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
