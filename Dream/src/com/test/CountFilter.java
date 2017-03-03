package com.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CountFilter implements Filter {
//访问数量
	
	private int count;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String param=filterConfig.getInitParameter("count");
		count=Integer.valueOf(param);

	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		count++;
		//将ServletRequest转换成HttpServletRequest
		HttpServletRequest req=(HttpServletRequest)request;
		//获取ServletContext
		ServletContext context=req.getSession().getServletContext();
		context.setAttribute("count", count);
		chain.doFilter(request,response);

	}

	
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
