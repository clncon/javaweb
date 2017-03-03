<%@page import="com.dream.biz.impl.UserBizImpl"%>
<%@page import="com.dream.biz.UserBiz"%>
<%@page import="com.dream.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="content">
        <nav class="navbar ">
            <div class="container-fluid">
               
                <div  style="padding:0px;float:left"> <a href="index.jsp"><img src="img/login5.png.png" /></a> </div>
                <div class="collapse navbar-collapse" >
                                    <ul class="nav navbar-nav" id="navcon">
                        <li class="">
                            <a href="index.jsp">
                                首页
                                <span>Home</span>
                            </a> <em></em>
                        </li>
                        <li class="">
                            <a href="RepertoryServlet?todo=searchCondition&pageNo=1" target="_blank">
                                鲜果
                                <span>Fruit</span>
                            </a> <em></em>
                        </li>
                        <!--  <li class="">
                            <a href="fruit.jsp" target="_blank">
                                生鲜
                                <span>Fresh</span>
                            </a>
                            <em></em>
                        </li>
                        -->
                        <li class="">
                            <a href="RepertoryServlet?todo=searchGiftCondition&pageNo=1" target="_blank">
                                礼品
                                <span>Gift</span>
                            </a>
                            <em></em>
                        </li>
                        <li class="">
                            <a href="qiangxianla.jsp" target="_blank">
                                抢鲜啦！
                                <span>Sale</span>
                            </a>
                            <em></em>
                        </li>
<!--                        <li class="">
                            <a href="/kjt" target="_blank">
                                跨境鲜
                                <span>Duty free</span>
                            </a>
                            <em></em>
                        </li>-->
                             <li class="">
                              <% User user= (User)session.getAttribute("user"); 
                              if(user!=null){
                               %> <a href="huiyuan.jsp" target="_blank">   会员中心
                                <span>VIP Club</span>
                            </a><% 
                              }else{
                              %><a href="login.jsp" target="_blank">   会员中心
                                <span>VIP Club</span>
                            </a><% 
                              }
                                     %>
                            <em></em>
                        </li>
                    </ul>
                    <div class="navbar-right">
                        <form action="RepertoryServlet?todo=searchGname&pageNo=1" method="post" >                    
                        <div class="p-common-topsearch">

                            <input id="search-keyword" name="gname" type="text" placeholder="请输入关键字" value=""/>                            
                            <button id="search-button" type="submit">
                                <i class="iconfont">&#xe600;</i>                      
                            </button>
                         
                            </form>
                               <div class="hotsearch">
                                热门：
                                                                <a href="RepertoryServlet?todo=searchCondition&gtype=蓝莓&pageNo=1" target="_blank">蓝莓</a>
                                                                <a href="RepertoryServlet?todo=searchCondition&gtype=橙子&pageNo=1" target="_blank">橙子</a>
                                                                <a href="RepertoryServlet?todo=searchCondition&gtype=奇异果&pageNo=1" target="_blank">奇异果</a> 
                                                            </div>
                        </div>
                    </div>
                                    </div>
        
        </nav>

  </body>
</html>
