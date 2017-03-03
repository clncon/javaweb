<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
      <form action = "/day14/thransferServlet" method = "post">
        <table border = "1" align = "center">
          <caption>转账界面</caption>
          <tr>              
               <th>转出账号</th>
               <td>
                 <input type = "text" name = "sid"/>
               </td>
           </tr>    
           <tr>
             <th>
                                         转入账号
             </th>
             <td>
               <input type = "text" name = "tid"/>
             </td>
           </tr>
           <tr>
             <th>转出金额</th>
             <td>
               <input type = "text" name = "salary"/>
             </td>
           </tr>     
           <tr>
             <td colspan = "2" align = "center">
                 <input type = "submit" value = "转出"/>
             </td>
           </tr>   
        </table>
      </form>
  </body>
</html>
