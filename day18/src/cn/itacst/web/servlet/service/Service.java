package cn.itacst.web.servlet.service;

import java.sql.SQLException;
import java.util.List;

import cn.itacst.web.servlet.dao.upDao;
import cn.itacst.web.servlet.domain.Up;

public class Service {
	upDao updao = new upDao();
   public void addUps(List<Up> listup ) throws Exception{
	   for(Up up:listup){
		   try {
			updao.addUp(up);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	   }
	   
   }
   public List<Up> findAllFile() throws SQLException{
	   
	   return updao.findAllFile();
   }
   public Up findUuidFileUp(String uuidFileName) throws SQLException{
	   
	   return updao.findUUidFileUp(uuidFileName);
   }
}
