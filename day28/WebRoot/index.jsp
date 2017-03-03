<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>index</title>
  </head>
  
  <body>
       <html:link action="/RegisterUI">
                                         用户注册
        </html:link><br/>
         <html:link action="/LoginUI">
                                     用户登录
         </html:link><br/>
          <html:link action="/EditUI">
                                       编辑
          </html:link>
          <br/>
           <html:link action="/book?method=add">
                                         增加图书
           </html:link>
            <html:link action="/book?method=delete">
                                         删除图书
           </html:link>
            <html:link action="/book?method=update">
                                         更新图书
           </html:link>
           <html:link action="/book?method=find">
                                         查找图书
           </html:link>
            
  </body>
</html>
