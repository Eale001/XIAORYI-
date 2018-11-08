package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.pojo.Neu_Account;
import com.neuedu.XiaoRyi.service.Neu_AccountService;

/**
 * 员工 工号表的操作(增删改查)
 * @author Administrator
 *
 */
public class ManageAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Neu_AccountService neu_accountservice=(Neu_AccountService) context.getBean("autoaccountService");
	
	//private Neu_AccountService neu_accountservice=(Neu_AccountService) FactoryUtil.getInstanceObjectByName("Neu_AccountService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg=request.getParameter("msg");
		System.out.println(msg);
		if("1".equals(msg)) {
			//查找
			String page=request.getParameter("page");
			String total=request.getParameter("total");
			List<Neu_Account> list=neu_accountservice.findPage(page, total);
			
			Result rs=new Result(1,list,null);
			response.setContentType("application/JSON");
			response.getWriter().append(rs.toString());
		}else if("2".equals(msg)) {
			//增加
			Neu_Account account=new Neu_Account();
			
			String neu_account=request.getParameter("addneuaccount");
			Long account_no=Long.parseLong(neu_account);
			String neu_password=request.getParameter("addneupassword");
			String neu_power_level=request.getParameter("addneupowerlevel");
			Long power_level=Long.parseLong(neu_power_level);
			
			account.setNei_empno(account_no);
			account.setNeu_pwd(neu_password);
			account.setNeu_power_level(power_level);
			
			neu_accountservice.register(account);
			
			response.getWriter().append("true");
		}else if("3".equals(msg)) {
			//修改
			Neu_Account account=new Neu_Account();
			
			String neu_account=request.getParameter("addneuaccount");
			Long account_no=Long.parseLong(neu_account);
			String neu_password=request.getParameter("addneupassword");
			String neu_power_level=request.getParameter("addneupowerlevel");
			Long power_level=Long.parseLong(neu_power_level);
			
			account.setNei_empno(account_no);
			account.setNeu_pwd(neu_password);
			account.setNeu_power_level(power_level);
			
			neu_accountservice.update(account);
			response.getWriter().append("true");
			
		}else if("4".equals(msg)) {
			//删除
			String _id=request.getParameter("m_id");
			Long id=Long.parseLong(_id);
			
			neu_accountservice.delete(id);
			response.getWriter().append("true");
		}else if("5".equals(msg)) {
			//查询单个
			String fid=request.getParameter("f_id");
			Long id=Long.parseLong(fid);
			System.out.println(id);
			Optional<Neu_Account> opt=neu_accountservice.findById(id);
			Neu_Account account=opt.get();
			System.out.println(account.getNei_empno());
			
			Result rs=new Result(1,account,null);
			response.setContentType("application/JSON");
			response.getWriter().append(rs.toString());
		}else if("6".equals(msg)) {
			//查询单个2
			String fid=request.getParameter("Vid");
			Long id=Long.parseLong(fid);
			System.out.println(id);
			Optional<Neu_Account> opt=neu_accountservice.findById(id);
			Neu_Account account=opt.get();
			System.out.println(account.getNei_empno());
			
			Result rs=new Result(1,account,null);
			response.setContentType("application/JSON");
			response.getWriter().append(rs.toString());
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
