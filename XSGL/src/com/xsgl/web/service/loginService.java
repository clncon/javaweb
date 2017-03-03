package com.xsgl.web.service;

import java.sql.SQLException;

import com.xsgl.web.dao.rootDao;
import com.xsgl.web.domain.Root;
import com.xsgl.web.exception.NoRootException;

public class loginService {
	//����һ��DAO����
	rootDao rd = new rootDao();
	 //����Ƿ���ڸù���Ա�����з���true�����򷵻�false
   public boolean checkRoot(String rootName,String rootPassword) throws NoRootException{
	     boolean flag = true;
	     try {
			Root root = rd.checkRoot(rootName, rootPassword);
		   if(root.getRootName()==null||root.getRootPassword()==null){
			   flag=false;
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
			
		}
			
	     return flag;
	   
   }
}
