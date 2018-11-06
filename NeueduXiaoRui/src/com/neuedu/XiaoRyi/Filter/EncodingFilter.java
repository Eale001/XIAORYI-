package com.neuedu.XiaoRyi.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 过滤器--处理字符编码
 * @author Administrator
 *
 */
public class EncodingFilter implements Filter {
	private String encoding =null;
   
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=utf-8");
		
		chain.doFilter(request, response);
	}



	public void init(FilterConfig fConfig) throws ServletException {
		encoding=fConfig.getInitParameter("Encoding");
	}

}
