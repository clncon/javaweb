package cn.itcast.bbs.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.bbs.domain.Reply;
import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.domain.Type;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.exception.updateClickException;
import cn.itcast.bbs.form.LoginForm;
import cn.itcast.bbs.form.RegisterForm;
import cn.itcast.bbs.service.BbsService;

public class BbsServlet extends HttpServlet {
	//添加一条回复通过topic_id
	protected void addReplyByTopic_Id(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   String replyName = request.getParameter("replyName");
		   String content = request.getParameter("content");
		   int topic_id = Integer.parseInt(request.getParameter("topic_id"));
		   HttpSession session = request.getSession();
		   try {
		   if(session!=null){
			   User user = (User) session.getAttribute("user");
			   if(user!=null){
				   Reply reply = new Reply();
				   reply.setTitle(replyName);
				   reply.setName(user.getUsername());
				   reply.setContent(content);
				   reply.setTopic_id(topic_id);
				   BbsService bbsservice = new BbsService();
					bbsservice.addReplyByTopic_Id(topic_id, reply);
					request.setAttribute("message", "发表回复成功");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			   }
		   }
		   } catch (Exception e) {
			    
			   request.setAttribute("message", "发表回复失败");
			   request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			   e.printStackTrace();
		   }
	}
	//转发到回复页面
	protected void toSendReply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String topic_id = request.getParameter("topic_id");
		  request.setAttribute("topic_id", topic_id);
		  request.getRequestDispatcher("/WEB-INF/jsp/sendReply.jsp").forward(request, response);
		
	}
	//转发到updateTopic页面
	protected void toUpdateJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		          String id = request.getParameter("id");
		          request.setAttribute("id", id);
		          request.getRequestDispatcher("/WEB-INF/jsp/updateTopic.jsp").forward(request, response);
	}
	//更新主题内容通过id
	protected void updateTopicByid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String topicName = request.getParameter("topicName");
		  String content = request.getParameter("content");
		  int id = Integer.parseInt(request.getParameter("id"));
		  BbsService bbsservice = new BbsService();
		   Topic topic;
		try {
			topic = bbsservice.findTopicByid(id);
			  topic.setTitle(topicName);
			  topic.setContent(content);
			  //Date date = new Date(System.currentTimeMillis());
			  //topic.setTime(date);
			bbsservice.updateTopicById(id,topic);
			request.setAttribute("message", "更新主题成功");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("message", "更新主题失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			e.printStackTrace();
		}
		
	}
	//查找指定的主题下所有的回复
	protected void findAllReplyByTopic_id(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int topic_id = Integer.parseInt(request.getParameter("topic_id"));
		 BbsService bbsservice = new BbsService();
		try {
			  Topic topic = bbsservice.findTopicByid(topic_id);
			List<Reply> listReply =  bbsservice.findAllReplyByTopic_Id(topic_id);
		     request.setAttribute("topic", topic);
		     request.setAttribute("listReply", listReply);
		     request.getRequestDispatcher("/WEB-INF/jsp/listAllReply.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 request.setAttribute("message", "显示回复页面失败");
			 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	//根据板块显示主题
	protected void findTopicByType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   int type_id = Integer.parseInt(request.getParameter("type_id"));
		   BbsService bbsservice = new BbsService();
		   HttpSession session = request.getSession();
		   try { 
			      //当session不是新的才更新click
			     if(!session.isNew()){
			    	  //取得一个type_id的集合
			    	  List<Integer> TypeIdList = (List<Integer>) session.getAttribute("TypeIdList");
			    	  //如果集合为空，就创建这个集合
			    	   if(TypeIdList==null){
			    		   TypeIdList = new ArrayList<Integer>();
			    		   session.setAttribute("TypeIdList", TypeIdList);
			    	   }
			    	   //检查这个板块是否已经被点击过
			    	   boolean flag = bbsservice.isClicked(type_id,TypeIdList);
			    	   if(!flag){
			    		   bbsservice.updateClickByType(type_id);
			    	   }
			     }
			List<Topic> listTopic = bbsservice.findTopicBytype(type_id);
			/* for(Topic topic:listTopic){
				 System.out.println(topic.getTitle()+":"+topic.getName()+":"+topic.getReplyCount());
			 }*/
			request.setAttribute("listTopic", listTopic);
			request.setAttribute("type_id", type_id);
			request.getRequestDispatcher("/WEB-INF/jsp/topic.jsp").forward(request, response);
		} 
		   catch(updateClickException e){
			   request.setAttribute("message","更新点击数失败了");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				e.printStackTrace();
		   }
		   catch (Exception e) {
			request.setAttribute("message","查询主题失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
   	
	
	  //安全退出


	


	protected void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		   //取得所有的用户名列表
		   List<String> listuserName = (List<String>) request.getServletContext().getAttribute("listuserName");
		    //取得当前用户的Session对象
		     HttpSession session = request.getSession();
		     //取得当前用户的Session中存储的用户对象
		      User user =  (User) session.getAttribute("user");
		      //取得用户对象的用户名
		       String userName = user.getUsername();
		       //在用户列表中删除当前用户名
		        listuserName.remove(userName);
		        //销毁这个session
		          session.invalidate();
		          //重定向到index页面
		           response.sendRedirect(request.getServletContext().getContextPath()+"/index.jsp");
		   
	}
	
	//登录模块、
	
	protected void Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  //收集表单信息
		   Enumeration<String> enumes = request.getParameterNames();
		   User user = new User();
		   while(enumes.hasMoreElements()){
			  String key = enumes.nextElement();
			  String[] values = request.getParameterValues(key);
			  if(!key.equals("method")){
				  try {
					BeanUtils.setProperty(user, key, values);
				} catch (Exception e) {
					request.setAttribute("message","登录失败");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
					e.printStackTrace();
				}
			  }
		   }
		   //验证密码
		   LoginForm lf = new LoginForm(user);
		     boolean flag = lf.validate();
		     BbsService bbsservice = new BbsService();
		    if(flag){
		    	 //判断是否存在集合lisetUserName来存储在线用户
		    	List<String> listuserName = (List<String>) this.getServletContext().getAttribute("listuserName");
		    	if(listuserName==null){
		    		listuserName = new ArrayList<String>();
		    		this.getServletContext().setAttribute("listuserName", listuserName);
		    	}else{
		    		//检查用户是否在线
		    		bbsservice.checkOnline(user, listuserName);
		    		 
		    	}
		    	//检查数据库是否有这个用户
		    	 try {
					user = bbsservice.login(user);
					if(user!=null){
						request.getSession().setAttribute("user", user);
						request.setAttribute("message","登录成功");
						request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
					}
				} catch (Exception e) {
					request.setAttribute("message", "登录失败");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
					e.printStackTrace();
				}
		    }else{
		    	request.setAttribute("LoginForm", lf);
		    	request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		    	
		    }
	}
	
	//注册模块
	protected void Register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=utf-8");
		    //获取表单所有的属性名
		   Enumeration<String> enumes =  request.getParameterNames();
		   User user = new User();
		   while(enumes.hasMoreElements()){
			  String key = enumes.nextElement();
			  String[] value = request.getParameterValues(key);
			  if(!key.equals("method")){
				  try {
					  //将表单数据收集到User对象中
					BeanUtils.setProperty(user, key, value);
				} catch (Exception e) {
					request.setAttribute("message","注册失败");
					request.getRequestDispatcher("/WEB-INF/jsp/Message.jsp").forward(request, response);
					e.printStackTrace();
				} 
			  }
		   }
		   //进入到数据验证模块
		   RegisterForm rf = new RegisterForm(user);
		   boolean flag = rf.Validate();
		   if(flag){
			    //注册数据
			    BbsService bbsservice = new BbsService();
			    try {
					bbsservice.Register(user);
					request.setAttribute("message","注册成功");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("message","注册错误");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				}
		   }else{
			   // System.out.println(rf.getErrors().get("email"));
			   request.setAttribute("RegisterForm", rf);
			   request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		   }
		
	}


	


	//查找所有的板块
	protected void findAllType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	       BbsService bbsservice = new BbsService();
	       try {
			List<Type> listAllType = bbsservice.findAllType();
			request.setAttribute("LISTALLTYPE", listAllType);
			request.getRequestDispatcher("/WEB-INF/jsp/listAllType.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message","查询所有的主题失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			e.printStackTrace();
		}
	       
	}


	 
	protected void toSendTopic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String type_id = request.getParameter("type_id");
		 System.out.println(type_id);
		   request.setAttribute("type_id", type_id);
		   request.getRequestDispatcher("/WEB-INF/jsp/sendTopic.jsp").forward(request, response);
	}
	//添加一个主题通过版块号
	protected void addTopicByType_Id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			 String topicName = request.getParameter("topicName");
			 String content = request.getParameter("content");
			 String type_id = request.getParameter("type_id");
			 HttpSession session = request.getSession();
			 try {
			  if(session!=null){
				 User user =  (User) session.getAttribute("user");
				 if(user!=null){
					 String name = user.getUsername();
					 //Date date = new Date(System.currentTimeMillis());
					 Topic topic = new Topic();
					 topic.setTitle(topicName);
					 topic.setName(name);
					// topic.setTime(date);
					 topic.setContent(content);
					 BbsService bbsservice = new BbsService();
					 int type_Id = Integer.parseInt(type_id);
					 bbsservice.addTopicByType_Id(type_Id, topic);
					 request.setAttribute("message","发表主题成功");
					 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				 }
			  
			  }
			 } catch (NumberFormatException e) {
				 
				 request.setAttribute("message","type_id格式不正确");
				 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				 e.printStackTrace();
			 } catch (Exception e) {
				 
				 request.setAttribute("message","发表主题失败");
				 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				 e.printStackTrace();
			 }
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=utf-8");
		   String method = request.getParameter("method");
		   if("findAllType".equals(method)){
			   this.findAllType(request, response);
		   }else if("toRegisterJsp".equals(method)){
			  request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		   }else if("Register".equals(method)){
			   this.Register(request, response);
		   }else if("toLoginJsp".equals(method)){
			   request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		   }else if("Login".equals(method)){
			   this.Login(request, response);
		   }else if("exit".equals(method)){
			   this.exit(request, response);
		   }else if("findTopicByType".equals(method)){
			   this.findTopicByType(request, response);
		   }else if("findAllReplyByTopic_id".equals(method)){
			   this.findAllReplyByTopic_id(request, response);
		   }else if("toSendTopic".equals(method)){
			  this.toSendTopic(request, response);
		   }else if("addTopicByType_Id".equals(method)){
			   this.addTopicByType_Id(request, response);
		   }else if("updateTopicByid".equals(method)){
			   this.updateTopicByid(request, response);
		   }else if("toUpdateJsp".equals(method)){
			   this.toUpdateJsp(request, response);
		   }else if("toSendReply".equals(method)){
			   this.toSendReply(request, response);
		   }else if("addReplyByTopic_Id".equals(method)){
			   this.addReplyByTopic_Id(request, response);
		   }
          
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=utf-8");
	          this.doGet(request, response);

		
	}
	

}
