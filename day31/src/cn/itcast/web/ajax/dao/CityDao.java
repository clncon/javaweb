package cn.itcast.web.ajax.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.web.ajax.domain.City;
import cn.itcast.web.ajax.utils.jdbcUtils;

public class CityDao {
    public List<City> findAllCityByProvince(String province) throws SQLException{
    	QueryRunner runner = new QueryRunner(jdbcUtils.getDatasource());
    	 String sql = "select * from city where province_name=?";
    	 List<City> listCity = runner.query(sql, province, new BeanListHandler<City>(City.class));
    	 return listCity;
    }
}
