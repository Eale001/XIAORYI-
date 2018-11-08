package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.XiaoRyi.Util.QRCodeUtil;
import com.neuedu.XiaoRyi.pojo.Neu_Emp;
import com.neuedu.XiaoRyi.service.Neu_EmpService;

/**
 * 服务端  管理员 展示二维码  让打卡  
 * @author Administrator
 *
 */
public class ManagerClockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	Neu_EmpService neu_empservice=(Neu_EmpService) context.getBean("autoempService");
	
	//private Neu_EmpService neu_empservice=(Neu_EmpService) FactoryUtil.getInstanceObjectByName("Neu_EmpService");
	
	@Override
	public void init() throws ServletException {
		
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.生成二维码
		//从配置文件中读取(待优化)
		String content="http://10.25.194.67:8088/NeueduXiaoRui/Neu_Emp_Login.html";//
		String path="WebContent/update";
		String name="网址";
		try {
			QRCodeUtil.encode(content,null,path,false,name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将生成的图片用ajax传到前端 实施动态刷新(待优化)
		
		//2.读取需要打卡的人
		String page=request.getParameter("page");
		String total=request.getParameter("total");
		List<Neu_Emp> list= neu_empservice.findByPage(page, total);
		
		Result rs=new Result(1,list,null);
		response.setContentType("application/JSON");
		response.getWriter().append(rs.toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
