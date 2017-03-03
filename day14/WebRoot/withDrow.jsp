<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
        <form action = "/day14/thransferServlet?method=withDrow" method = "post">
        <table border = "1" align = "center">
          <caption>取款界面</caption>
          <tr>              
               <th>账号</th>
               <td>
                 <input type = "text" name = "id"/>
               </td>
           </tr>  
           <tr>
            <th>金额</th>
               <td>
                 <input type = "text" name = "money"/>
               </td>
           </tr>  
           <tr>
             <td colspan = "2" align = "center">
                 <input type = "submit" value = "取出"/>
             </td>
           </tr>   
        </table>
      </form>
  </body>
</html>
