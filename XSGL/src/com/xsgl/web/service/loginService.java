package com.xsgl.web.service;

import java.sql.SQLException;

import com.xsgl.web.dao.rootDao;
import com.xsgl.web.domain.Root;
import com.xsgl.web.exception.NoRootException;

public class loginService {
	//创建一个DAO对象
	rootDao rd = new rootDao();
	 //检查是否存在该管理员对象，有返回true，否则返回false
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
