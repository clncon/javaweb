<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>upload</title>
  </head>
  
  <body>
    <html:form action="/upload" method="post" enctype="multipart/form-data">
       <table align="center" border="1">
          <caption><h1>文件上传</h1></caption>
           <tr>
             <th>用户名：</th>
             <td>
               <html:text property="username"/>
             </td>
           </tr>
              <tr>
               <th>文件1：</th>
               <td>
                  <input type="file" name="upfile[0]"/>
               </td>
            </tr>
              <tr>
               <th>文件1：</th>
               <td>
                  <input type="file" name="upfile[1]"/>
               </td>
            </tr>
               <tr>
               <th>文件2：</th>
               <td>
                  <input type="file" name="upfile[2]"/>
               </td>
            </tr>
             <tr>
                <td colspan="2" align="center">
                   <html:submit value="上传"/>
                </td>
             </tr>
       </table>
    </html:form>
       <html:link action="/download">
                               下载
       </html:link>
  </body>
</html:html>
