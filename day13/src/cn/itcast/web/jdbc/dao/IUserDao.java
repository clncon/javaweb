package cn.itcast.web.jdbc.dao;

import java.util.List;

import cn.itcast.web.jdbc.entity.User;

public interface IUserDao {
	public boolean find(String username,String password);
	public boolean add(User user);
	public List<User> find(int start,int size);
	public int getAllRecordNO();

}
