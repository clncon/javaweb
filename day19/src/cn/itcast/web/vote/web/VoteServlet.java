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
	
	  //查询投票人的信息

	protected void findAllInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    VoteService voteservice = new VoteService();
		    try {
				List<Info> listinfo = voteservice.finALLInfo();
				
				request.setAttribute("LISTINFO", listinfo);
				request.getRequestDispatcher("/WEB-INF/jsp/listAllInfo.jsp").forward(request, response);
			} catch (SQLException e) {
				request.setAttribute("message","查询失败");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				e.printStackTrace();
			}
	}

	 //更新vote表的票数
	
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
			request.setAttribute("message","<font color='red' size='44'>请等一分钟后再投票</font");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			
		} 
		 catch(overTicketException e){
			 request.setAttribute("message","<font color='red' size='44'>最多只能投100票</font");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		 }
		 catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message","投票失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}

	}
	//安全退出
	
	
		protected void exit(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			   request.getSession().invalidate();
			   response.sendRedirect(request.getContextPath()+"/welcome.jsp");
			
		}
	
	

	//重定向到登录页面
	protected void toLoginJsp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  response.sendRedirect(request.getContextPath()+"/login.html");
	}
     

	//安全登录
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 String username = request.getParameter("username");
		 if(username!=null&&username.trim().length()>0){
			 ServletContext context = this.getServletContext();
			 List<String> userList = (List<String>) context.getAttribute("userList");
			 //判断用户是否在线
			 if(userList==null){
				 
				   userList= new ArrayList<String>();
			 }
			 VoteService voteService = new  VoteService();
			 boolean flag = voteService.checkOnLine(username,userList);
			 context.setAttribute("userList", userList);
			 if(flag){
				 //在线
				 request.setAttribute("message","该用户已经在线");
				 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			 }else{
				User user = new User();
				user.setUsername(username);
				request.getSession().setAttribute("user",user);
			    response.sendRedirect(request.getContextPath()+"/welcome.jsp");
				 
			 }
		 }
		 else 
			 
		 {   request.setAttribute("message","请输入用户名");
			 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		 }
		    
		
	}

	//根据指定的id查找Vote和Content对象
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
				request.setAttribute("message","查询候选人信息失败");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			}
	}

	//查找所有的Vote信息
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
				request.setAttribute("message", "查看所有的用户信息失败");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				
			}
		     
	}

}
