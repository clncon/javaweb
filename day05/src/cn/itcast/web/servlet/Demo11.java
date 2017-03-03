package cn.itcast.web.servlet;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demo11 implements Servlet{

  public void destroy(){};
  public ServletConfig getServletConfig(){
  
     return null;

    }
  public String getServletInfo(){

    return null;  
    }
  public void init(ServletConfig config)throws ServletException{};

  public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
      res.getWriter().write("welcome to java web!");
        
     }

}
