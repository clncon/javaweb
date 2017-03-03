<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">
		<title>梦之队• 当然果园店面管理系统 | 会员信息管理</title>
		
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
		<script type="text/javascript" src="admin/js/jquery.min.js"></script>
		<script type="text/javascript" src="admin/js/jconfirmaction.jquery.js"></script>
		<script language="javascript" type="text/javascript" src="admin/js/My97DatePicker/WdatePicker.js"></script>
	  
	   <script type="text/javascript">

	   function select11(){
	     var sel= document.getElementById("select1").value;
	     //var s=ocument.getElementById("pagesize").value=sel;
         //page.value.innerText="123";
	  // alert(sel);
	  
	  
	  if (window.XMLHttpRequest) {//其他IE容器
			ht = new XMLHttpRequest();
		} else if (window.ActiveXObject) {//IE容器
			try {
				ht = new ActiveXObject("MsXML2.XMLHTTP");
			} catch (e) {
				try {
					ht = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alter("对象实例化有问题！");
				}
			}
		}
	
		ht.onreadystatechange = call123; //回调函数
		//以GET方式发送
		//ht.open("GET","servlet/checkuser?userId="+userId,true); //true异步
		//ht.send();//发送请求到服务器端

		ht.open("post", "VipServlet", true);
		ht.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded");
		ht.send("todo="+"searchVipAjax"+"&"+"pagesize="+sel); // ?参数 
	  
	  
	  
	  
	  
	  
	  var s= document.getElementById("pagesize").value=sel;
	   // window.location.href="VipServlet?todo=searchVip?pagesize=10";
	      //window.location.href="admin/index.jsp";
	       
	      
	   }
	   
	   function call123(){
	   if (ht.readyState == 4) {//4 (完成)数据接收完毕
			if (ht.status == 200) {
			
				//alert(ht.responseText);
				
				var list = document.getElementById("listvipajax");
				list.items = ht.responseText;
				
			}
	   }
	   
	}
	   </script>
	  
	<link rel="stylesheet" href="css/dengluzhuce.css" type="text/css"></link></head>
 
	<body>
		<div class="right_content">
			<h2>会员信息管理</h2>
			<div class="top-input"><table id="top-table"><tbody></tbody></table><br><table id="top-table"><tbody>
			           <form action="VipServlet?todo=searchVip" method="post">
			            <div class="search" >
                                    <input  type="text" class="field"  placeholder="请输入用户账号" name="uphone" />
                                    <input  type="submit" class="button" value="搜索会员" class="bt_green" />
                                </div>
						</form>
						</tbody> 
						 
					</table>
					
				</div>
				
				<table id="rounded-corner">
					<thead>
						 <tr>
                    <th width="38" class="rounded-company" scope="col"><input type="checkbox" name="input" /></th>
                    <th width="166" class="rounded" scope="col">用户账号</th>
                    <th width="42" class="rounded" scope="col">会员名</th>
                    <th width="86" class="rounded" scope="col">会员等级</th>
                    <th width="104" class="rounded" scope="col">用户邮箱</th>
                    <th width="85" class="rounded-q4" scope="col">常用地址</th>
                    <th width="84" class="rounded" scope="col">修改</th>
                    <th width="110" class="rounded-q4" scope="col">删除</th>           
                </tr>
					</thead>
					<tbody >					
						<!-- 单条记录 -->
						<c:forEach  var="vip" items="${listvip}" >
							                <tr>
                    <td><input type="checkbox" name="" /></td>
                    <td>${vip.uPhone}</td>
                    <td>${vip.uName}</td>
                    <td>${vip.uLevel}</td>
                    
                    <td>${vip.uMail }</td>                    
                    <td>${vip.uAddress }</td>
                    <td><a href="VipServlet?todo=searchUpdateVip&uid=${vip.uId }"><img src="admin/images/user_edit.png" alt="" title="" border="0" /></a></td>
                    <td><a href="VipServlet?todo=delVip&uid=${vip.uId }" class="ask"><img src="admin/images/trash.png" alt="" title="" border="0" /></a></td>
                </tr>
								<!-- <td style="padding-right: 20px;">
									<a href="StorageServlet?do=del&sid=${s.storageId}" class="ask">
										<img src="images/trash.png" alt="" title="" border="0" />
									</a>
								</td> -->
							</tr>
						</c:forEach>
						<!--end 单条记录 -->
					</tbody>
				</table>

				<!-- 页码 + 按钮 -->
				<div class="btns-pagenav">
					<!-- 按钮 -->
					<div class="div-btns">
							
						<div class="div-btns"> 
						<a href="VipServlet?todo=searchUser&pageNo=1" class="bt_green">添加会员</a>&nbsp;
						
								 
									</div> 			
					</div>
						
					<!--end 按钮 -->

					<!-- 页码 -->
					<div class="page-navigator">
					<%-- 	<div class="page-navigator-left">
							每页
							<select class="select-short" name="select1" id="select1"  onchange="select11() ">
								<option value="5" >5</option>	
								<option value="10" >10</option>	
							</select>
                                
							条
							
						</div>
						--%>
						<div class="page-navigator-right">
							<a href="VipServlet?todo=searchVip&pageNo=1" class="first">«</a>
							<a href="VipServlet?todo=searchVip&pageNo=${page.pageNo-1}"
								class="prev">‹</a> &nbsp;第 ${page.pageNo} 页&nbsp; &nbsp;共<td>${page.pageCount}</td>页&nbsp;
							<a href="VipServlet?todo=searchVip&pageNo=${page.pageNo+1}"
								class="next">›</a>
							<a href="VipServlet?todo=searchVip&pageNo=${page.pageCount}"
								class="last">»</a>
						</div>
					</div>
					<!--End 页码 -->
				</div>
				<!-- / 页码 + 按钮 -->
		</div>
		<div class="clear"></div>
	</body>
</html>
