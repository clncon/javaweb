package cn.itcast.web.zhuangbei.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.web.zhuangbei.Exception.CountException;
import cn.itcast.web.zhuangbei.dao.EquipmentDao;
import cn.itcast.web.zhuangbei.domain.Borrow;
import cn.itcast.web.zhuangbei.domain.Equipment;

public class EquipService {
	EquipmentDao equipmentdao = new EquipmentDao();
	 //根据id查找一个borrow
	  public Borrow findBorrowById(int id) throws Exception{
		  try {
			return equipmentdao.findBorrowById(id);
		} catch (SQLException e) {
			throw new Exception();
		}
	  }
	 //删除一条借贷信息
	  public void deleteBorrow(Borrow borrow) throws Exception{
		  try {
			equipmentdao.deleteBorrowById(borrow.getId());
			equipmentdao.addEquipCountByBorrow(borrow);
		} catch (SQLException e) {
			throw new Exception();
		}
		  
	  }
	 //添加一条借贷信息
	   public void addBorrow(Borrow borrow) throws SQLException, CountException{
		  
			equipmentdao.addBorrow(borrow);
			equipmentdao.deleteEquipmentByBorrow(borrow);
		 
		
	   }
	 //查找所有的借贷装备信息
	 public List<Borrow> findAllBorrow() throws Exception{
		 try {
			return equipmentdao.findAllBorrow();
		} catch (SQLException e) {
			throw new Exception();
		}
		 
	 }
	//删除一条装备信息
	public void deleteEquipmentById(int id) throws Exception{
		try {
			equipmentdao.deleteEquipmentById(id);
		} catch (SQLException e) {
			throw new Exception();
		}
	}
    //查找所有的装备
	public List<Equipment> findAllEquiment() throws Exception{
		try {
			return equipmentdao.findAllEquipment();
		} catch (SQLException e) {
			throw new Exception();
			
		}
     }
	//添加一条装备信息、
	 public void addEquiment(Equipment equipment) throws Exception{
		 try {
			equipmentdao.addEquipment(equipment);
		} catch (SQLException e) {
			throw new Exception();
			
		}
	 }
}
