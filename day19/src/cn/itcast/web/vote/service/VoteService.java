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
	 //�����û����������ѯΨһ��Admin
	 public Admin finAdminByUsernameAndPassword(String username,String password) throws Exception{
		 try {
			return admindao.findAdminByUsernameAndPassword(username, password);
		} catch (SQLException e) {
			throw new Exception();
		}
	 }
	 //��ѯ���е�ͶƱ����Ϣ
	 public List<Info> finALLInfo() throws SQLException{
		 //ȡ��infoList����
		 List<Info> infoList = infodao.findInfoAll();
		 //����infoList���ϣ�
		  for(Info info:infoList){
			  //System.out.println(info.getIp());
			  //��ö�Ӧ��address����
			 Address address = addressdao.findAddressByip(info.getIp());
			 if(address==null){
				address = new Address();
				address.setLocation("�Ϸ�");
			 }
			 //�����������info��
			   info.setAddress(address);			  
		  }
		 return infoList;
	 }
 	 //�������е�Vote��Ϣ
     public List<Vote> findAllVote() throws SQLException{
    	  return votedao.findAllVote();
     }
     //��Ʊ������������е�Vote��Ϣ
     public List<Vote> findAllVoteByDesc() throws SQLException{
    	 return votedao.findAllVoteByDesc();
     }
     //����id�Ų�ѯָ��Vote
     public Vote findVoteById(int id) throws SQLException{
    	 return votedao.findVoteById(id);
     }
     //����id��ѯָ��Content
     public Content findContentById(int id) throws SQLException{
    	 Vote vote = findVoteById(id);
    	 Image image = imagedao.findImageById(id);
    	 Content content = contentdao.findContentById(id);
    	 content.setVote(vote);
    	 //��content��image����
    	 content.setImage(image);
    	 return content;
    	 
     }
     //����id������vote���Ʊ����info�����Ϣ
     public void updateVoteById(int id,String ip) throws SQLException, noTimeException, overTicketException{
    	   //�ǲ������һ�ε�ͶƱ
    	     Info info = infodao.findInfoById(ip);
    	     Vote vote = votedao.findVoteById(id);
    	     
    	     if(vote.getTicket()<100)
    	     //����ǵ�һ��ͶƱ
    	      if(info==null){
    	    	  info = new Info();
    	    	  info.setIp(ip);
    	    	  infodao.addInfo(info);
    	    	  votedao.updateVoteById(id);
    	      }
    	        //�������
    	      else {
    	    	   //ȡ�����һ�ε�ͶƱʱ��
    	    	  long endTime = info.getVotetime().getTime();
    	    	  //ȡ�����ڵ�ʱ��
    	    	  long nowTime= System.currentTimeMillis();
    	    	  //ȡ��ʱ���
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
			 //���û�������
			 flag=false;
			 userList.add(username);
		 }else{
			 for(String userName:userList){
				 if(userName.equals(username)){
					 //����
					 flag=true;
					 return flag;
				 }
			 }
			 //������
			 flag=false;
			 userList.add(username);

		 }
		 return flag;
	} 
}


