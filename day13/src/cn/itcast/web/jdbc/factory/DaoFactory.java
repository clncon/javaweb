package cn.itcast.web.jdbc.factory;

import cn.itcast.web.jdbc.dao.IUserDao;
import cn.itcast.web.jdbc.dao.userDao;
//DAO����
public class DaoFactory {
	private static DaoFactory daofactory;
	private DaoFactory(){}
	public static DaoFactory getDaoFactory(){
		if(daofactory==null){
			daofactory = new DaoFactory();
		}
		return daofactory;
	}
     public IUserDao getUserDao(){
    	 return new userDao();
     }
}
