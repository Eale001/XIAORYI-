package com.neuedu.XiaoRyi.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 服务端 处理 请假请求(即 准驳)
 * @author Administrator
 *
 */
public class DisposeAskLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisposeAskLeaveServlet() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
