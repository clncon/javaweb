package cn.itcast.web.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import cn.itcast.web.jdbc.dao.thransferDao2;
import cn.itcast.web.jdbc.domian.Account;
import cn.itcast.web.jdbc.exception.NOAccountException;
import cn.itcast.web.jdbc.exception.NOMoneyException;
import cn.itcast.web.jdbc.util.jdbcUtils;

public class thransferService2 {

	public void transfer(int sid,int tid,float money) throws Exception{
		Connection conn;
		conn = jdbcUtils.getMySqlConnection();
		Account sAccount = thransferDao2.findAccountById(sid);
		Account tAccount = thransferDao2.findAccountById(tid);
		 if(sAccount!=null&&tAccount!=null){
			 if(sAccount.getSalary()-money>0){
			   try {
				   //�����ֶ��ύ����
				   conn.setAutoCommit(false);
				   //ת���˻�
				   sAccount.setSalary(sAccount.getSalary()-money);
				   thransferDao2.updateAccountById(sAccount);
				   // int i= 12/0;
				   //ת���˻�
				   tAccount.setSalary(tAccount.getSalary()+money);
				   thransferDao2.updateAccountById(tAccount);
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
	
	public void withdrow(int id,float money) throws NOMoneyException, NOAccountException, Exception{
		Account account = thransferDao2.findAccountById(id);
		if(account!=null){
			if(account.getSalary()-money>0)
			{
				account.setSalary(account.getSalary()-money);
				thransferDao2.updateAccountById(account);

			}
		else{
			throw new NOMoneyException();
		}
	}
	else{
		throw new NOAccountException();
	}
}


}
