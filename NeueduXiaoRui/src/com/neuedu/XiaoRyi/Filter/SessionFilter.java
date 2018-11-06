package com.neuedu.XiaoRyi.Filter;

import java.io.File;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 客户端 验证用户登录是否失效
 * @author Administrator
 *
 */
public class SessionFilter implements Filter {

   
    public SessionFilter() {
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
		
        HttpSession session=req.getSession();
        Long empno=(Long) session.getAttribute("empno");
        if(null==empno) {
        	String path=req.getContextPath();
			String realpath=path +File.separator+"Neu_Emp_Login.html";
        	res.sendRedirect(realpath);
        	return;
        }
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
