package cn.itcast.web.soufang.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.web.soufang.dao.HouseDao;
import cn.itcast.web.soufang.domain.House;

public class HouseService {
    public List<House> findHouseByHouse(House house) throws Exception{
       HouseDao dao = new HouseDao();
    	try {
			return dao.findHouseByHouse(house);
		} catch (SQLException e) {
			 throw new Exception();
		}
    }
}
