package cn.itcast.web.soufang.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.web.soufang.domain.House;
import cn.itcast.web.soufang.util.jdbcUtils;

public class HouseDao {
       public List<House> findHouseByHouse(House house) throws SQLException{
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoure());
        /*  System.out.println(house.getArea());
          System.out.println(house.getAddress());
          System.out.println(house.getSpace());*/
          String sql = "select * from fang where area LIKE '%"+house.getArea()+"%' and address LIKE '%"+house.getAddress()+"%' and space LIKE '%"+house.getSpace()+"%'";
         
	    List<House> listHouse = (List<House>) runner.query(sql, new BeanListHandler(House.class));
		
    	   return listHouse;
       }
}
