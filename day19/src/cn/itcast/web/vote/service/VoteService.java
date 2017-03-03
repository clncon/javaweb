package cn.itcast.web.vote.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.web.vote.dao.addressDao;
import cn.itcast.web.vote.dao.adminDao;
import cn.itcast.web.vote.dao.contentDao;
import cn.itcast.web.vote.dao.imageDao;
import cn.itcast.web.vote.dao.infoDao;
import cn.itcast.web.vote.dao.voteDao;
import cn.itcast.web.vote.entity.Address;
import cn.itcast.web.vote.entity.Admin;
import cn.itcast.web.vote.entity.Content;
import cn.itcast.web.vote.entity.Image;
import cn.itcast.web.vote.entity.Info;
import cn.itcast.web.vote.entity.Vote;
import cn.itcast.web.vote.exception.noTimeException;
import cn.itcast.web.vote.exception.overTicketException;

public class VoteService {
    
	 voteDao votedao = new voteDao();
	 contentDao contentdao = new contentDao();
	 infoDao infodao = new infoDao();
	 imageDao imagedao = new imageDao();
	 addressDao addressdao = new addressDao();
	 adminDao admindao = new adminDao();
	 //根据用户名和密码查询唯一的Admin
	 public Admin finAdminByUsernameAndPassword(String username,String password) throws Exception{
		 try {
			return admindao.findAdminByUsernameAndPassword(username, password);
		} catch (SQLException e) {
			throw new Exception();
		}
	 }
	 //查询所有的投票人信息
	 public List<Info> finALLInfo() throws SQLException{
		 //取得infoList对象
		 List<Info> infoList = infodao.findInfoAll();
		 //遍历infoList集合，
		  for(Info info:infoList){
			  //System.out.println(info.getIp());
			  //获得对应的address对象，
			 Address address = addressdao.findAddressByip(info.getIp());
			 if(address==null){
				address = new Address();
				address.setLocation("合肥");
			 }
			 //并将其关联到info中
			   info.setAddress(address);			  
		  }
		 return infoList;
	 }
 	 //查找所有的Vote信息
     public List<Vote> findAllVote() throws SQLException{
    	  return votedao.findAllVote();
     }
     //按票数升序查找所有的Vote信息
     public List<Vote> findAllVoteByDesc() throws SQLException{
    	 return votedao.findAllVoteByDesc();
     }
     //根据id号查询指定Vote
     public Vote findVoteById(int id) throws SQLException{
    	 return votedao.findVoteById(id);
     }
     //根据id查询指定Content
     public Content findContentById(int id) throws SQLException{
    	 Vote vote = findVoteById(id);
    	 Image image = imagedao.findImageById(id);
    	 Content content = contentdao.findContentById(id);
    	 content.setVote(vote);
    	 //将content和image关联
    	 content.setImage(image);
    	 return content;
    	 
     }
     //根据id来更新vote表的票数和info表的信息
     public void updateVoteById(int id,String ip) throws SQLException, noTimeException, overTicketException{
    	   //是不是最后一次的投票
    	     Info info = infodao.findInfoById(ip);
    	     Vote vote = votedao.findVoteById(id);
    	     
    	     if(vote.getTicket()<100)
    	     //如果是第一次投票
    	      if(info==null){
    	    	  info = new Info();
    	    	  info.setIp(ip);
    	    	  infodao.addInfo(info);
    	    	  votedao.updateVoteById(id);
    	      }
    	        //如果不是
    	      else {
    	    	   //取得最后一次的投票时间
    	    	  long endTime = info.getVotetime().getTime();
    	    	  //取得现在的时间
    	    	  long nowTime= System.currentTimeMillis();
    	    	  //取得时间差
    	    	  long  middle = (nowTime-endTime)/1000;
    	    	  if(middle>60){
    	    		  info = new Info();
        	    	  info.setIp(ip);
        	    	  infodao.addInfo(info);
        	    	  votedao.updateVoteById(id);
    	    	  }else{
    	    		  throw new noTimeException(); 
    	    	  }
    	      }else 
    	      {
    	    	   throw new overTicketException();
    	    	  
    	      }
    	    	  
    	      }
	public boolean checkOnLine(String username, List<String> userList) {
		 boolean flag = true;
		 if(userList.size()==0){
			 //该用户不在线
			 flag=false;
			 userList.add(username);
		 }else{
			 for(String userName:userList){
				 if(userName.equals(username)){
					 //在线
					 flag=true;
					 return flag;
				 }
			 }
			 //不在线
			 flag=false;
			 userList.add(username);

		 }
		 return flag;
	} 
}


