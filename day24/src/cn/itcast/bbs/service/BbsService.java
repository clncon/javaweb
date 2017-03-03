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
	 ////���һ���ظ���ָ����������
	 public void addReplyByTopic_Id(int topic_id,Reply reply) throws Exception{
		 try {
			replydao.addReplyByTopic_IdAndReply(topic_id, reply);
		} catch (SQLException e) {
			throw new Exception();
		}
	 }
	//��ָ�������������һ������
	public void addTopicByType_Id(int type_id,Topic topic) throws Exception{
		try {
			topicdao.addTopicByType_Id(topic, type_id);
		} catch (SQLException e) {
			throw new Exception();
		}
	}
	 //����id���Ҷ�Ӧ������
	 public Topic findTopicByid(int id) throws Exception{
		    Topic topic;
		 try {
			topic = topicdao.findTopicByid(id);
		} catch (SQLException e) {
			 throw new Exception();
		}
		 return topic;
	 }
	//����ָ�������������еĻظ�
	public List<Reply> findAllReplyByTopic_Id(int topic_id) throws Exception{
		try {
			return replydao.findAllReplyByTopic_Id(topic_id);
		} catch (SQLException e) {
			throw new Exception();
			//e.printStackTrace();
		}
	}
	  //���ݰ��������click
	  public void updateClickByType(int type_id) throws  updateClickException{
		   try {
			typedao.updateClickByType(type_id);
		} catch (SQLException e) {
			throw new updateClickException();
		}
	  }
	  //����type_id��Ѱtopic
	  public List<Topic> findTopicBytype(int typeid) throws Exception{
		  List<Topic> listTopic=null;
		  try {
		 listTopic = topicdao.findTopicByType(typeid);
		  for(Topic topic:listTopic){
			   //���ÿ������Ļظ���
			 int count =  replydao.findReplyCountByTopic_id(topic.getId());
			 topic.setReplyCount(count);
			 //ȡ��ÿ�������Ӧ�İ��
			  Type type = typedao.findTypeById(typeid);
			  //��������Ͱ��
			    topic.setType(type);
		  }
		} catch (Exception e) {
			 throw e;
			//e.printStackTrace();
		}
		  return listTopic;
	  }
	 //�û���¼
	 public  User login(User user) throws Exception{
		 User usert = null;
		  //����û�����
		 String password = user.getPassword();
		 //��������м���
		  try {
			password = Encode.encodeByMd5(password);
			user.setPassword(password);
			usert = userdao.login(user);
		} catch (Exception e) {
			throw e;
			
		}
		  return usert;
		 
	 }
	//�ж��û��Ƿ����ߣ��Ƿ���true �񷵻� false
	 public boolean checkOnline(User user,List<String> listuserName){
		  boolean flag=false;
		     //�жϼ����Ƿ�Ϊ��
		   if(listuserName==null&&listuserName.size()==0){
			   //������
			   flag = false;
			   //���뼯��
			   listuserName.add(user.getUsername());
		   }else{
			     //�жϼ������Ƿ��и��û�
			   if(listuserName.contains(user.getUsername())){
				   //����
				    flag=true;
			   }else{
				   //������
				    flag = false;
				    //���뼯��
				    listuserName.add(user.getUsername());
			   }
		   }
		  return flag;
	 }
	 //ע�����û�
	 public void Register(User user) throws Exception{
		 // ����û�����
		  String password = user.getPassword();
		  //����MD5(ʮ������)����
		  try {
			password = Encode.encodeByMd5(password);
			user.setPassword(password);
			userdao.Register(user);
			
		} catch (Exception e) {
			 throw e;
			
		}
	 }
	 //�������еİ��
      public List<Type> findAllType() throws Exception{
		try {
			listAllType = typedao.findAllByType();
			for(Type type:listAllType){
				 //ȡ�ð��İ���
				Admin admin = admindao.findAdminByTitle(type.getTitle());
				 //���ð���
				type.setAdmin(admin);
				 //ȡ�����µ�����
				 Topic newTopic =topicdao.findTopicByTypeAndNewDate(type.getId());
				  //��������
				  type.setNewTopic(newTopic);
				  //ȡ�øð��������������
				   int topicNum = topicdao.findTopicNumByType(type.getId());
				   //����������
				    type.setTopicNum(topicNum);
			}
		} catch (Exception e) {
			throw e;
		}
		return listAllType;
      }
      //����ָ����ip��ѯ��ַ
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
        //����true��ʾ�ѵ������
	public boolean isClicked(int type_id, List<Integer> typeIdList) {
		boolean flag=false;
		if(typeIdList!=null&&typeIdList.size()==0){
			 //δ�����
			flag=false;
			typeIdList.add(type_id);
		}else{
			 //�Ѿ������
			if(typeIdList.contains(type_id)){
				//�������Ѿ��������
				flag = true;	
			}else{
				//�ð��δ�����
				flag=false;
				typeIdList.add(type_id);
			}
		}
		return flag;
		
		
	}
	 //��������ͨ��id
	public void updateTopicById(int id,Topic topic) throws Exception {
		 try {
			topicdao.updateTopicById(id, topic);
		} catch (SQLException e) {
			throw new Exception();
		}
		
	}
}
