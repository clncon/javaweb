<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Login</title>
  </head>
  
  <body>
      <form action="${pageContext.request.contextPath}/uploadServlet?method=upload" method="Post"
      enctype="multipart/form-data">
          <table width="500" border="1" align="center">
              <caption>上传界面</caption>
               <tr>
                 <th>用户名:</th>
                 <td>
                    <input type="text" name="username"/>
                 </td>
               </tr>
                <tr>
                 <th>上传路径:</th>
                 <td>
                    <input type="file" name="upfile"/>
                 </td>
               </tr>
               <tr>
                  <td colspan="2" align="center">
                     <input type="submit" value="提交"/>
                  </td>
               </tr>
          </table> 
      </form>
  </body>
</html>
