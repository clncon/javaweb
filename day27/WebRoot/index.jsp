<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import = "java.util.*"%>
<%@ page import = "cn.itcast.web.struts.domain.Student" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>index</title>
  </head>
  
  <body>
      <a href="${pageContext.request.contextPath}/RegisterUI.do">转发到注册页面</a><br/>
      <hr/>
       <html:link action="/RegisterUI.do">
                               用户注册 
      </html:link><br/>
       <hr/>
        <%
           request.setAttribute("username", "english");
         %>
       <html:link  action="/RegisterUI.do" paramId="username" paramName="username">
            html:link传递单个变量
       </html:link><br/>
        <hr/>
          <%
             Date date = new Date();
             request.setAttribute("date", date);
           %>
         <html:link 
         action="RegisterUI.do"
          paramId="nowKey" 
          paramName="date" 
          paramProperty="time">
             html:link传递单个javaBean的内置对象
         </html:link>
         <hr/>
           <%
              Student student = new Student();
               student.setId(20160204);
               student.setUsername("jack");
               student.setPassword("123456");
              request.setAttribute("student", student);
            %>
          <html:link 
          action="/RegisterUI.do"
           paramId="idKey"
           paramName="student"
           paramProperty="id"
          >
                               编号
          </html:link>
           <html:link action="RegisterUI.do"
           paramId="nameKey"
           paramName="student"
           paramProperty="username"
           >
                                        姓名
           </html:link>
            <html:link action="RegisterUI.do"
               paramId="passwordKey"
               paramName="student"
               paramProperty="password"
            >
                                             密码
            </html:link>
             <hr/>
             
             <%
                 Map<String,String> map = new HashMap<String,String>();
                  map.put("1","jack");
                  map.put("2","marry");
                  map.put("3","xixi");
                 request.setAttribute("map",map);
              %>
              <html:link action="/RegisterUI.do" name="map">
                                                      传多个变量
              </html:link>
  </body>
</html>
