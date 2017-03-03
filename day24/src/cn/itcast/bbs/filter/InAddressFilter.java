package cn.itcast.bbs.filter;

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

import cn.itcast.bbs.domain.Address;
import cn.itcast.bbs.service.BbsService;

public class InAddressFilter implements Filter {

	
	public void destroy() {
		

	}

	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		  //接口强制转换
		   HttpServletResponse response = (HttpServletResponse) res;
		   HttpServletRequest request = (HttpServletRequest) req;
		   //取得HttpSession对象
		   HttpSession session = request.getSession();
		   //查看session是否有address属性
		   Address address = (Address) session.getAttribute("address");
		   if(address==null){
			   BbsService bbsservice = new BbsService();
			   try {
				address = bbsservice.findAddressByIp(request.getRemoteAddr());
				session.setAttribute("address",address);
			} catch (Exception e) {
				e.printStackTrace();
			}
		   }
		    //放行资源
		   chain.doFilter(request, response);

	}

	
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
