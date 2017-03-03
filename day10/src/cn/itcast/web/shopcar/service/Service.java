package cn.itcast.web.shopcar.service;

import java.util.Map;

import cn.itcast.web.domain.Book;
import cn.itcast.web.domain.Car;
import cn.itcast.web.domain.item;
import cn.itcast.web.shopcar.dao.BookDao;

public class Service {
	//返回图书列表
	private BookDao  bookdao = new BookDao();
       public Map<String,Book> findAllBook(){
    	   return bookdao.findAllBook();
       }
       //查找图书
       public Book findBookById(String id ){
    	   return bookdao.findBookById(id);
       }
       //购买图书
	public void buyBook(String id, Car car) {
		Map<String,item> map = car.getMap();
		item it= map.get(id);
		if(it==null){
			 it = new item();
			it.setBook(findBookById(id));
			it.setNum(1);
			map.put(id, it);
		}
		else{
			it.setNum(it.getNum()+1);
		}
		
	}
	 //删除购买的图书
	public void deleteBook(String id, Car car) {
		Map<String,item> map = car.getMap();
		map.remove(id);
	}
	//清空购物车
	public void clearCar(Car car) {
		car.getMap().clear();
		
	}
	//更新图书数量
	public void updateBook(String id,int num ,Car car) {
		Map<String,item> map = car.getMap();
		item it = map.get(id);
		it.setNum(num);
		
	}
	
}
