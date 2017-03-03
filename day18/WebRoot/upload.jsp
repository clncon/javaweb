<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Login</title>
      <script type="text/javascript">
         var count =0;
         function upfile(addButton){
            count++;
            var  div = document.createElement("div");
            var input = document.createElement("input");
            input.type="file";
            input.name="name";
            var input2 = document.createElement("input");
            input2.type="button";
            input2.value="删除";
            input2.onclick=function(){
               //取得需要删除节点的父父节点
               var parent = this.parentNode.parentNode;
               //删除父节点
               parent.removeChild(this.parentNode);
               count--;
               if(count<5){
                 //按钮生效
                 addButton.disabled=false;
               }
            }
            var outDiv = document.getElementById("out");
           div.appendChild(input);
           div.appendChild(input2);
           outDiv.appendChild(div);
           if(count==5){
            //按钮失效
            addButton.disabled=true;
           }
  		}
      </script>
  </head>
  <body>
      <form action="${pageContext.request.contextPath}/uploadServlet?method=upload" method="Post"
      enctype="multipart/form-data">
          <table  border="1" align="center">
              <caption>上传界面</caption>
               <tr>
                 <th>用户名:</th>
                 <td>
                    <input type="text" name="username"/>
                 </td>
               </tr>
                  <tr>
                     <th></th>
                     <td>
                     <div id="out">
                          <%--
  						<div>
							<input type="file" name="upfile"/>
							<input type="button" value="删除"/>  							
  						</div>
  						--%>
                      </div> 
                    </td>               
                  </tr>
                <tr>
                    <th></th>
                   <td>
                     <input type="button" value="添加上传文件"  onclick="upfile(this)"/>
                   </td>
                </tr>
               <tr>
                  <td colspan="2" align="center">
                     <input type="submit" value="提交"/>
                     <a href="${pageContext.request.contextPath}/ListFileServlet">
                                                          查看下载列表
                     </a>
                  </td>
               </tr>
          </table> 
      </form>
  </body>
</html>
