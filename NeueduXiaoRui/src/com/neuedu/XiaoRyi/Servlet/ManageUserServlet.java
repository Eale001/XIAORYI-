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

import com.neuedu.XiaoRyi.common.Page;
import com.neuedu.XiaoRyi.pojo.Neu_Emp;
import com.neuedu.XiaoRyi.service.Neu_EmpService;

/**
 * 服务端 管理员 员工管理  增删改查
 * @author Administrator
 *
 */
public class ManageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Neu_EmpService neu_empservice=(Neu_EmpService) context.getBean("autoempService");
	
	//private Neu_EmpService neu_empservice=(Neu_EmpService) FactoryUtil.getInstanceObjectByName("Neu_EmpService");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg=request.getParameter("msg");
		System.out.println(msg);
		if("1".equals(msg)) {
			//查找
			String p=request.getParameter("page");
			String t=request.getParameter("total");
			Page page=new Page();
			page.setPageSize(Integer.parseInt(t));
			page.setCurrentPage(Integer.parseInt(p));
			
			
			List<Neu_Emp> list= neu_empservice.findByPage(page);
			Result rs=new Result(1,list,null);
			response.setContentType("application/JSON");
			response.getWriter().append(rs.toString());
		}else if("2".equals(msg)) {
			//增加
			Neu_Emp emp=new Neu_Emp();
			
			String neu_empno=request.getParameter("addneuaccount");
			Long empno=Long.parseLong(neu_empno);
			String neu_empname=request.getParameter("addneupassword");
			String neu_empaddre=request.getParameter("addneupowerlevel");
			
			String neu_empemail=request.getParameter("addneuaccount");
			
			String neu_emptel=request.getParameter("addneupassword");
			Long tel=Long.parseLong(neu_emptel);
			String neu_empage=request.getParameter("addneupowerlevel");
			Long age=Long.parseLong(neu_empage);
			String neu_gender=request.getParameter("addneupassword");
			Long sex=Long.parseLong(neu_gender);
			String neu_delete=request.getParameter("addneupowerlevel");
			Long neudelete=Long.parseLong(neu_delete);
			emp.setNeu_addre(neu_empaddre);
			emp.setNeu_email(neu_empemail);
			emp.setNeu_name(neu_empname);
			emp.setNeu_empno(empno);
			emp.setNeu_sex(sex);
			emp.setNeu_tel(tel);
			emp.setNeu_age(age);
			emp.setNeu_delete(neudelete);
			neu_empservice.add(emp);
			
			
			response.getWriter().append("true");
		}else if("3".equals(msg)) {
			//修改
			Neu_Emp emp=new Neu_Emp();
			
			String neu_empno=request.getParameter("updateempno");
			Long empno=Long.parseLong(neu_empno);
			String neu_empname=request.getParameter("updateempname");
			String neu_empaddre=request.getParameter("updateempaddre");
			
			String neu_empemail=request.getParameter("updateempemail");
			
			String neu_emptel=request.getParameter("updateemptel");
			Long tel=Long.parseLong(neu_emptel);
			String neu_empage=request.getParameter("updateempage");
			Long age=Long.parseLong(neu_empage);
			String neu_gender=request.getParameter("updateempsex");
			Long sex=Long.parseLong(neu_gender);
//			String neu_delete=request.getParameter("addneupowerlevel");
//			Long neudelete=Long.parseLong(neu_delete);
			emp.setNeu_addre(neu_empaddre);
			emp.setNeu_email(neu_empemail);
			emp.setNeu_name(neu_empname);
			emp.setNeu_empno(empno);
			emp.setNeu_sex(sex);
			emp.setNeu_tel(tel);
			emp.setNeu_age(age);
//			emp.setNeu_delete(neudelete);
			neu_empservice.update(emp);
			response.getWriter().append("true");
		}else if("4".equals(msg)) {
			//删除
			String de_id=request.getParameter("de_id");
			Long id=Long.parseLong(de_id);
			neu_empservice.deleted(id);
			response.getWriter().append("true");
		}else if("5".equals(msg)) {
			String upid=request.getParameter("upid");
			Long id=Long.parseLong(upid);
			Optional<Neu_Emp> opt=neu_empservice.findById(id);
			Neu_Emp emp=opt.get();
			
			Result rs=new Result(1,emp,null);
			response.setContentType("application/JSON");
			response.getWriter().append(rs.toString());
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
