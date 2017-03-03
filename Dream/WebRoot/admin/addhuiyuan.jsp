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
		<title>梦之队• 当然果园店面管理系统 | 添加会员</title>
		
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="admin/css/style.css" />
		<script type="text/javascript" src="admin/js/jquery.min.js"></script>
		<script type="text/javascript" src="admin/js/jconfirmaction.jquery.js"></script>
		<script language="javascript" type="text/javascript" src="admin/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			$('.ask').jConfirmAction();
		});
		function submit(){
			${"form"}[0].submit();
		}
	</script>
	<link rel="stylesheet" href="css/dengluzhuce.css" type="text/css"></link></head>

	<body>
		<div class="right_content">
			<h2>添加会员</h2>
			<div class="top-input"><table id="top-table"><tbody></tbody></table><br><table id="top-table"><tbody>
			            <form action="VipServlet?todo=searchUser" method="post">
			            <div class="search" >
                                    <input  type="text" class="field"  placeholder="请输入用户账号" name="uphone" />
                                    <input type="submit" class="button" value="搜索非会员"  />
                                </div>
						</form>
		</tbody> 
						 
					</table>
					
				</div>
				
				<table id="rounded-corner">
					<thead>
						 <tr>
                    <th width="38" class="rounded-company" scope="col"><input type="checkbox" name="input" /></th>
                    <th width="42" class="rounded" scope="col">会员编号</th>
                    <th width="166" class="rounded" scope="col">用户账号</th>
                    <th width="166" class="rounded" scope="col">用户姓名</th>
                    <th width="42" class="rounded" scope="col">会员性别</th> 
                    <th width="166" class="rounded" scope="col">用户生日</th>                                     
                    <th width="104" class="rounded" scope="col">用户邮箱</th>
                    <th width="85" class="rounded-q4" scope="col">常用地址</th>   
                    <th width="85" class="rounded-q4" scope="col">添加</th>   
                          
                </tr>
					</thead>
					<tbody>
						<!-- 单条记录 -->
						<c:forEach var="user" items="${listuser}" >
							                <tr>
                    <td><input type="checkbox" name="" /></td>
                    <td>${user.uId}</td>
                    <td>${user.uPhone}</td>
                    <td>${user.uName}</td>
                    <td>${user.sex}</td>
                    <td>${user.uBir}</td>                  
                    <td>${user.uMail}</td>
                    <td>${user.uAddress}</td>
                    <td><a href="VipServlet?todo=addVip&&uid=${user.uId}"><img src="admin/images/user_edit.png" alt="" title="" border="0" /></a></td>          
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
						<a href="VipServlet?todo=searchVip" class="bt_green">返回</a>&nbsp;
								 
									</div> 			
					</div>
						
					<!--end 按钮 -->

					<!-- 页码 -->
					<div class="page-navigator">
					<%-- 	<div class="page-navigator-left">
							每页
							<select class="select-short" name="pagesize" onchange="submit()">
								<option value="5" ${sessionScope.pagesize==5?"selected":""}>5</option>
								<option value="10" ${sessionScope.pagesize==10?"selected":""}>10</option>
							</select>
							条
						</div>
						--%>
							<div class="page-navigator-right">
							<a href="VipServlet?todo=searchUser&pageNo=1" class="first">«</a>
							<a href="VipServlet?todo=searchUser&pageNo=${page.pageNo-1}"
								class="prev">‹</a> &nbsp;第 ${page.pageNo} 页&nbsp; &nbsp;共<td>${page.pageCount}</td>页&nbsp;
							<a href="VipServlet?todo=searchUser&pageNo=${page.pageNo+1}"
								class="next">›</a>
							<a href="VipServlet?todo=searchUser&pageNo=${page.pageCount}"
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
