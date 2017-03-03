<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    <form action = "/day13/userServlet?method=upload" method = "post">
  	<table border="1" align="center">
  			<tr>
  				<th>上传像片</th>
  				<td>
  					<input type="file" name="filepath"/>
  				</td>
  			</tr>
  			<tr>
  				<td colspan="2" align="center">
  					<input type="submit" value="保存到数据库"/>
  				</td>
  			</tr>
  		</table>
  	</form>
      </form>
  </body>
</html>
