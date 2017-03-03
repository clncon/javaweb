package cn.itcast.web.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import cn.itcast.web.jdbc.dao.thransferDao;
import cn.itcast.web.jdbc.domian.Account;
import cn.itcast.web.jdbc.util.jdbcUtils;

public class thransferService {
	public void transfer(int sid,int tid,float money) throws Exception{
		Connection conn = null;
		conn = jdbcUtils.getMySqlConnection();
		Account sAccount = thransferDao.findAccountById(sid,conn);
		Account tAccount = thransferDao.findAccountById(tid,conn);
		 if(sAccount!=null&&tAccount!=null){
			 if(sAccount.getSalary()-money>0){
			   try {
				   //设置手动提交事务
				   conn.setAutoCommit(false);
				   //转出账户
				   sAccount.setSalary(sAccount.getSalary()-money);
				   thransferDao.updateAccountById(sAccount,conn);
				    int i= 12/0;
				   //转入账户
				   tAccount.setSalary(tAccount.getSalary()+money);
				   thransferDao.updateAccountById(tAccount,conn);
				   conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
				conn.commit();
				throw e;
			}
			 }
			 else {
				 throw new Exception();
			 }
			 }
		 }

}
