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
	//���һ���ظ�ͨ��topic_id
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
					request.setAttribute("message", "����ظ��ɹ�");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			   }
		   }
		   } catch (Exception e) {
			    
			   request.setAttribute("message", "����ظ�ʧ��");
			   request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			   e.printStackTrace();
		   }
	}
	//ת�����ظ�ҳ��
	protected void toSendReply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String topic_id = request.getParameter("topic_id");
		  request.setAttribute("topic_id", topic_id);
		  request.getRequestDispatcher("/WEB-INF/jsp/sendReply.jsp").forward(request, response);
		
	}
	//ת����updateTopicҳ��
	protected void toUpdateJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		          String id = request.getParameter("id");
		          request.setAttribute("id", id);
		          request.getRequestDispatcher("/WEB-INF/jsp/updateTopic.jsp").forward(request, response);
	}
	//������������ͨ��id
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
			request.setAttribute("message", "��������ɹ�");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("message", "��������ʧ��");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			e.printStackTrace();
		}
		
	}
	//����ָ�������������еĻظ�
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
			 request.setAttribute("message", "��ʾ�ظ�ҳ��ʧ��");
			 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	//���ݰ����ʾ����
	protected void findTopicByType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   int type_id = Integer.parseInt(request.getParameter("type_id"));
		   BbsService bbsservice = new BbsService();
		   HttpSession session = request.getSession();
		   try { 
			      //��session�����µĲŸ���click
			     if(!session.isNew()){
			    	  //ȡ��һ��type_id�ļ���
			    	  List<Integer> TypeIdList = (List<Integer>) session.getAttribute("TypeIdList");
			    	  //�������Ϊ�գ��ʹ����������
			    	   if(TypeIdList==null){
			    		   TypeIdList = new ArrayList<Integer>();
			    		   session.setAttribute("TypeIdList", TypeIdList);
			    	   }
			    	   //����������Ƿ��Ѿ��������
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
			   request.setAttribute("message","���µ����ʧ����");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				e.printStackTrace();
		   }
		   catch (Exception e) {
			request.setAttribute("message","��ѯ����ʧ��");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
   	
	
	  //��ȫ�˳�


	


	protected void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		   //ȡ�����е��û����б�
		   List<String> listuserName = (List<String>) request.getServletContext().getAttribute("listuserName");
		    //ȡ�õ�ǰ�û���Session����
		     HttpSession session = request.getSession();
		     //ȡ�õ�ǰ�û���Session�д洢���û�����
		      User user =  (User) session.getAttribute("user");
		      //ȡ���û�������û���
		       String userName = user.getUsername();
		       //���û��б���ɾ����ǰ�û���
		        listuserName.remove(userName);
		        //�������session
		          session.invalidate();
		          //�ض���indexҳ��
		           response.sendRedirect(request.getServletContext().getContextPath()+"/index.jsp");
		   
	}
	
	//��¼ģ�顢
	
	protected void Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  //�ռ�����Ϣ
		   Enumeration<String> enumes = request.getParameterNames();
		   User user = new User();
		   while(enumes.hasMoreElements()){
			  String key = enumes.nextElement();
			  String[] values = request.getParameterValues(key);
			  if(!key.equals("method")){
				  try {
					BeanUtils.setProperty(user, key, values);
				} catch (Exception e) {
					request.setAttribute("message","��¼ʧ��");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
					e.printStackTrace();
				}
			  }
		   }
		   //��֤����
		   LoginForm lf = new LoginForm(user);
		     boolean flag = lf.validate();
		     BbsService bbsservice = new BbsService();
		    if(flag){
		    	 //�ж��Ƿ���ڼ���lisetUserName���洢�����û�
		    	List<String> listuserName = (List<String>) this.getServletContext().getAttribute("listuserName");
		    	if(listuserName==null){
		    		listuserName = new ArrayList<String>();
		    		this.getServletContext().setAttribute("listuserName", listuserName);
		    	}else{
		    		//����û��Ƿ�����
		    		bbsservice.checkOnline(user, listuserName);
		    		 
		    	}
		    	//������ݿ��Ƿ�������û�
		    	 try {
					user = bbsservice.login(user);
					if(user!=null){
						request.getSession().setAttribute("user", user);
						request.setAttribute("message","��¼�ɹ�");
						request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
					}
				} catch (Exception e) {
					request.setAttribute("message", "��¼ʧ��");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
					e.printStackTrace();
				}
		    }else{
		    	request.setAttribute("LoginForm", lf);
		    	request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		    	
		    }
	}
	
	//ע��ģ��
	protected void Register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=utf-8");
		    //��ȡ�����е�������
		   Enumeration<String> enumes =  request.getParameterNames();
		   User user = new User();
		   while(enumes.hasMoreElements()){
			  String key = enumes.nextElement();
			  String[] value = request.getParameterValues(key);
			  if(!key.equals("method")){
				  try {
					  //���������ռ���User������
					BeanUtils.setProperty(user, key, value);
				} catch (Exception e) {
					request.setAttribute("message","ע��ʧ��");
					request.getRequestDispatcher("/WEB-INF/jsp/Message.jsp").forward(request, response);
					e.printStackTrace();
				} 
			  }
		   }
		   //���뵽������֤ģ��
		   RegisterForm rf = new RegisterForm(user);
		   boolean flag = rf.Validate();
		   if(flag){
			    //ע������
			    BbsService bbsservice = new BbsService();
			    try {
					bbsservice.Register(user);
					request.setAttribute("message","ע��ɹ�");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("message","ע�����");
					request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				}
		   }else{
			   // System.out.println(rf.getErrors().get("email"));
			   request.setAttribute("RegisterForm", rf);
			   request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
		   }
		
	}


	


	//�������еİ��
	protected void findAllType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	       BbsService bbsservice = new BbsService();
	       try {
			List<Type> listAllType = bbsservice.findAllType();
			request.setAttribute("LISTALLTYPE", listAllType);
			request.getRequestDispatcher("/WEB-INF/jsp/listAllType.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message","��ѯ���е�����ʧ��");
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
	//���һ������ͨ������
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
					 request.setAttribute("message","��������ɹ�");
					 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				 }
			  
			  }
			 } catch (NumberFormatException e) {
				 
				 request.setAttribute("message","type_id��ʽ����ȷ");
				 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				 e.printStackTrace();
			 } catch (Exception e) {
				 
				 request.setAttribute("message","��������ʧ��");
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
