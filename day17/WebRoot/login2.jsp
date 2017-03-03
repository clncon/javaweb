<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>login</title>
  </head>
  
  <body>
        <fmt:setLocale value="${pageContext.request.locale}"/>
        <fmt:setBundle basename="cn/itcast/web/jsp/config/message"/>
       <form>
            <table align ="center" border="1">
                <caption><fmt:message key="login"/></caption>
                 <tr>
                    <th><fmt:message key="username"/></th>
                    <td>
                       <input type="text" name="username">
                    </td>
                 </tr>
                  <tr>
                     <th><fmt:message key="password"/></th>
                     <td>
                      <input type="password" name="password"/>
                      </td>
                      <tr>
                         <td colspan="2" align="center">
                           <input type="submit" value='<fmt:message key="submit"/>'/> 
                         </td>
                      </tr>
                  
            </table>
       </form>
         <hr/>
          <fmt:message key="hello">
             <fmt:param value="jack"/>
             <fmt:param value="marry"/>
             
          </fmt:message>
  </body>
</html>
