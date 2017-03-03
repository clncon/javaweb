package cn.itcast.bbs.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.bbs.dao.AddressDao;
import cn.itcast.bbs.dao.AdminDao;
import cn.itcast.bbs.dao.ReplyDao;
import cn.itcast.bbs.dao.TopicDao;
import cn.itcast.bbs.dao.TypeDao;
import cn.itcast.bbs.dao.UserDao;
import cn.itcast.bbs.domain.Address;
import cn.itcast.bbs.domain.Admin;
import cn.itcast.bbs.domain.Reply;
import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.domain.Type;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.encode.Encode;
import cn.itcast.bbs.exception.updateClickException;

public class BbsService {
	TypeDao typedao = new TypeDao();
	AdminDao admindao = new AdminDao();
	AddressDao addressdao = new AddressDao();
	 UserDao userdao = new UserDao();
	 TopicDao topicdao = new TopicDao();
	 ReplyDao replydao = new ReplyDao();
	List<Type> listAllType;
	 ////添加一条回复在指定的主题下
	 public void addReplyByTopic_Id(int topic_id,Reply reply) throws Exception{
		 try {
			replydao.addReplyByTopic_IdAndReply(topic_id, reply);
		} catch (SQLException e) {
			throw new Exception();
		}
	 }
	//在指定的主题下添加一个主题
	public void addTopicByType_Id(int type_id,Topic topic) throws Exception{
		try {
			topicdao.addTopicByType_Id(topic, type_id);
		} catch (SQLException e) {
			throw new Exception();
		}
	}
	 //根据id查找对应的主题
	 public Topic findTopicByid(int id) throws Exception{
		    Topic topic;
		 try {
			topic = topicdao.findTopicByid(id);
		} catch (SQLException e) {
			 throw new Exception();
		}
		 return topic;
	 }
	//查找指定的主题下所有的回复
	public List<Reply> findAllReplyByTopic_Id(int topic_id) throws Exception{
		try {
			return replydao.findAllReplyByTopic_Id(topic_id);
		} catch (SQLException e) {
			throw new Exception();
			//e.printStackTrace();
		}
	}
	  //根据板块来更新click
	  public void updateClickByType(int type_id) throws  updateClickException{
		   try {
			typedao.updateClickByType(type_id);
		} catch (SQLException e) {
			throw new updateClickException();
		}
	  }
	  //根据type_id查寻topic
	  public List<Topic> findTopicBytype(int typeid) throws Exception{
		  List<Topic> listTopic=null;
		  try {
		 listTopic = topicdao.findTopicByType(typeid);
		  for(Topic topic:listTopic){
			   //获得每个主题的回复数
			 int count =  replydao.findReplyCountByTopic_id(topic.getId());
			 topic.setReplyCount(count);
			 //取得每个主题对应的版块
			  Type type = typedao.findTypeById(typeid);
			  //关联主题和版块
			    topic.setType(type);
		  }
		} catch (Exception e) {
			 throw e;
			//e.printStackTrace();
		}
		  return listTopic;
	  }
	 //用户登录
	 public  User login(User user) throws Exception{
		 User usert = null;
		  //获得用户密码
		 String password = user.getPassword();
		 //对密码进行加密
		  try {
			password = Encode.encodeByMd5(password);
			user.setPassword(password);
			usert = userdao.login(user);
		} catch (Exception e) {
			throw e;
			
		}
		  return usert;
		 
	 }
	//判断用户是否在线，是返回true 否返回 false
	 public boolean checkOnline(User user,List<String> listuserName){
		  boolean flag=false;
		     //判断集合是否为空
		   if(listuserName==null&&listuserName.size()==0){
			   //不在线
			   flag = false;
			   //加入集合
			   listuserName.add(user.getUsername());
		   }else{
			     //判断集合中是否有该用户
			   if(listuserName.contains(user.getUsername())){
				   //在线
				    flag=true;
			   }else{
				   //不在线
				    flag = false;
				    //加入集合
				    listuserName.add(user.getUsername());
			   }
		   }
		  return flag;
	 }
	 //注册新用户
	 public void Register(User user) throws Exception{
		 // 获得用户密码
		  String password = user.getPassword();
		  //进行MD5(十六进制)加密
		  try {
			password = Encode.encodeByMd5(password);
			user.setPassword(password);
			userdao.Register(user);
			
		} catch (Exception e) {
			 throw e;
			
		}
	 }
	 //查找所有的版块
      public List<Type> findAllType() throws Exception{
		try {
			listAllType = typedao.findAllByType();
			for(Type type:listAllType){
				 //取得板块的版主
				Admin admin = admindao.findAdminByTitle(type.getTitle());
				 //设置版主
				type.setAdmin(admin);
				 //取得最新的主题
				 Topic newTopic =topicdao.findTopicByTypeAndNewDate(type.getId());
				  //设置主题
				  type.setNewTopic(newTopic);
				  //取得该板块下所有主题数
				   int topicNum = topicdao.findTopicNumByType(type.getId());
				   //设置主题数
				    type.setTopicNum(topicNum);
			}
		} catch (Exception e) {
			throw e;
		}
		return listAllType;
      }
      //根据指定的ip查询地址
       public Address findAddressByIp(String ip) throws Exception{
    	   Address address;
    	     try {
				address = addressdao.findAddressByIp(ip);
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
				
			}
    	     return address;
       }
        //返回true表示已点击过了
	public boolean isClicked(int type_id, List<Integer> typeIdList) {
		boolean flag=false;
		if(typeIdList!=null&&typeIdList.size()==0){
			 //未点击过
			flag=false;
			typeIdList.add(type_id);
		}else{
			 //已经点击过
			if(typeIdList.contains(type_id)){
				//这个板块已经点击过了
				flag = true;	
			}else{
				//该板块未点击过
				flag=false;
				typeIdList.add(type_id);
			}
		}
		return flag;
		
		
	}
	 //更新主题通过id
	public void updateTopicById(int id,Topic topic) throws Exception {
		 try {
			topicdao.updateTopicById(id, topic);
		} catch (SQLException e) {
			throw new Exception();
		}
		
	}
}
