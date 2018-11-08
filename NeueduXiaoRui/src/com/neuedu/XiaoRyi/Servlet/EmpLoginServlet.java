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
 * 处理 员工 登录请求
 * @author Administrator
 *
 */
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Neu_AccountService neu_accountservice=(Neu_AccountService) context.getBean("autoaccountService");
	
	//private Neu_AccountService neu_accountservice=(Neu_AccountService) FactoryUtil.getInstanceObjectByName("Neu_AccountService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userlogin=request.getParameter("userlogin");
		String userpassword=request.getParameter("userpassword");
		
		Optional<Neu_Account> opt=neu_accountservice.login(userlogin, userpassword);
		if(!opt.isPresent()) {
			String path=request.getContextPath();
			String realpath=path +File.separator+"Neu_Emp_Login.html";
			response.sendRedirect(realpath);
			return;
		}
		HttpSession session=request.getSession();
		session.setAttribute("empno", opt.get().getNei_empno());
		
		Result rs=new Result(1,opt,null);
		response.setContentType("application/JSON");
		response.getWriter().append(rs.toString());
		
		response.sendRedirect("Neuedu_Emp_index.html");
		//request.getRequestDispatcher("Neuedu_Emp_index.html").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
