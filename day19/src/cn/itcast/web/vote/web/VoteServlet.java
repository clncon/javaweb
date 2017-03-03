package cn.itcast.web.vote.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.vote.entity.Content;
import cn.itcast.web.vote.entity.Info;
import cn.itcast.web.vote.entity.User;
import cn.itcast.web.vote.entity.Vote;
import cn.itcast.web.vote.exception.noTimeException;
import cn.itcast.web.vote.exception.overTicketException;
import cn.itcast.web.vote.service.VoteService;

public class VoteServlet extends HttpServlet {

	private Object lock = new Object();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
            if("findAllVote".equals(method)){
            	this.findAllVote(request, response);
            }else if("findVoteById".equals(method)){
            	this.findVoteById(request, response);
            }else if("toLoginJsp".equals(method)){
            	this.toLoginJsp(request, response);
            }else if("exit".equals(method)){
            	this.exit(request, response);
            }else if("addVote".equals(method)){
            	this.updateVoteById(request, response);
            }else if("findAllInfo".equals(method)){
            	this.findAllInfo(request, response);
            }else if("toManagerLogin".equals(method)){
            	request.getRequestDispatcher("/WEB-INF/jsp/managerLogin.jsp").forward(request,response);
            }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		String method = request.getParameter("method");
		if("login".equals(method)){
			this.login(request, response);
		}
	}
	
	  //��ѯͶƱ�˵���Ϣ

	protected void findAllInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    VoteService voteservice = new VoteService();
		    try {
				List<Info> listinfo = voteservice.finALLInfo();
				
				request.setAttribute("LISTINFO", listinfo);
				request.getRequestDispatcher("/WEB-INF/jsp/listAllInfo.jsp").forward(request, response);
			} catch (SQLException e) {
				request.setAttribute("message","��ѯʧ��");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				e.printStackTrace();
			}
	}

	 //����vote���Ʊ��
	
	protected void updateVoteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  
		try {
			String parameter = request.getParameter("id");
			int id = Integer.parseInt(parameter);
			String ip = request.getRemoteAddr();
			VoteService voteservice = new VoteService();
			
			synchronized (lock) {
				voteservice.updateVoteById(id, ip);
			}
			response.sendRedirect(request.getContextPath()+"/welcome.jsp");
		}catch(noTimeException e){
			request.setAttribute("message","<font color='red' size='44'>���һ���Ӻ���ͶƱ</font");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
		} 
		 catch(overTicketException e){
			 request.setAttribute("message","<font color='red' size='44'>���ֻ��Ͷ100Ʊ</font");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		 }
		 catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message","ͶƱʧ��");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}

	}
	//��ȫ�˳�
	
	
		protected void exit(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			   request.getSession().invalidate();
			   response.sendRedirect(request.getContextPath()+"/welcome.jsp");
			
		}
	
	

	//�ض��򵽵�¼ҳ��
	protected void toLoginJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  response.sendRedirect(request.getContextPath()+"/login.html");
	}
     

	//��ȫ��¼
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 String username = request.getParameter("username");
		 if(username!=null&&username.trim().length()>0){
			 ServletContext context = this.getServletContext();
			 List<String> userList = (List<String>) context.getAttribute("userList");
			 //�ж��û��Ƿ�����
			 if(userList==null){
				 
				   userList= new ArrayList<String>();
			 }
			 VoteService voteService = new  VoteService();
			 boolean flag = voteService.checkOnLine(username,userList);
			 context.setAttribute("userList", userList);
			 if(flag){
				 //����
				 request.setAttribute("message","���û��Ѿ�����");
				 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			 }else{
				User user = new User();
				user.setUsername(username);
				request.getSession().setAttribute("user",user);
			    response.sendRedirect(request.getContextPath()+"/welcome.jsp");
				 
			 }
		 }
		 else 
			 
		 {   request.setAttribute("message","�������û���");
			 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		 }
		    
		
	}

	//����ָ����id����Vote��Content����
	protected void findVoteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
		    try {
		    	int id = Integer.parseInt(request.getParameter("id"));
			    VoteService voteService = new VoteService();
				Content content = voteService.findContentById(id);
				request.setAttribute("Content",content);
				request.getRequestDispatcher("/WEB-INF/jsp/listContent.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message","��ѯ��ѡ����Ϣʧ��");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			}
	}

	//�������е�Vote��Ϣ
	protected void findAllVote(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    VoteService voteService = new VoteService();
		     try {
		    	 
				List<Vote> listVote=voteService.findAllVote();
				List<Vote> listVoteDesc = voteService.findAllVoteByDesc();
				request.setAttribute("LISTVOTE",listVote);
				request.setAttribute("LISTVOTEDESC",listVoteDesc);
				request.getRequestDispatcher("/WEB-INF/jsp/listVote.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "�鿴���е��û���Ϣʧ��");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				
			}
		     
	}

}
