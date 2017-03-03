package cn.itcast.web.zhuangbei.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.web.zhuangbei.Exception.CountException;
import cn.itcast.web.zhuangbei.domain.Borrow;
import cn.itcast.web.zhuangbei.domain.Equipment;
import cn.itcast.web.zhuangbei.utils.jdbcUtils;

public class EquipmentDao {
	 //根据id查找Borrow对象
	 public Borrow findBorrowById(int id) throws SQLException{
		QueryRunner runner = new QueryRunner(jdbcUtils.getDatasource());
		  String sql = "select * from borrow where id=?";
		Borrow borrow = runner.query(sql, id, new BeanHandler<Borrow>(Borrow.class));
		 return borrow;
	 }
	//删除借贷信息根据id
	 public void deleteBorrowById(int id) throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getDatasource());
		 String sql = "delete from borrow where id=?";
		 runner.update(sql, id); 
	 }
	 //根据借贷数量添加到equipment上
	  public void addEquipCountByBorrow(Borrow borrow) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getDatasource());
		  String sql = "update equipment set count = count+? where name=?";
		  runner.update(sql, new Object[]{borrow.getCount(),borrow.getName()});
	  }
	//根据借贷的名称，删除装备表的装备数量
	 public void deleteEquipmentByBorrow(Borrow borrow) throws SQLException, CountException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getDatasource());
		 String sql = "UPDATE equipment SET count = count-? WHERE name = ? ";
		
		 runner.update(sql, new Object[]{borrow.getCount(),borrow.getName()});
		 
	 }
	//添加一条借贷信息
	 public void addBorrow(Borrow borrow) throws SQLException{
		 QueryRunner runner = new QueryRunner(jdbcUtils.getDatasource());
		 String sql = "insert into borrow(name,count)values(?,?)";
		 runner.update(sql, new Object[]{borrow.getName(),borrow.getCount()});
	 }
	 //查找所有的借贷装备的信息
	  public List<Borrow> findAllBorrow() throws SQLException{
		QueryRunner runner = new QueryRunner(jdbcUtils.getDatasource());
		  String sql = "select * from borrow";
		  List<Borrow> listBorrow = runner.query(sql, new BeanListHandler<Borrow>(Borrow.class));
		  return listBorrow;
		  
	  }
	 //删除一条装备信息
	  public void deleteEquipmentById(int id) throws SQLException{
		  QueryRunner runner = new QueryRunner(jdbcUtils.getDatasource());
		   String sql = "delete from equipment where id=?";
		  runner.update(sql, id);
	  }
	 //查询所有的装备
      public List<Equipment> findAllEquipment() throws SQLException{
    	   QueryRunner runner = new QueryRunner(jdbcUtils.getDatasource());
    	   String sql = "select * from equipment";
    	   List<Equipment> equipments = runner.query(sql, new BeanListHandler<Equipment>(Equipment.class));
		return equipments;
    	  
      }
      //添加一条装备信息、
       public void addEquipment(Equipment equipment) throws SQLException{
    	   QueryRunner runner = new QueryRunner(jdbcUtils.getDatasource());
    	   String sql = "insert into equipment(name,count,function,position)values(?,?,?,?)";
    	   runner.update(sql, new Object[]{equipment.getName(),equipment.getCount(),equipment.getFunction(),equipment.getPosition()});
       }
} 
