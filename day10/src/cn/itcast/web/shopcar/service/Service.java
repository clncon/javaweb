package cn.itcast.web.shopcar.service;

import java.util.Map;

import cn.itcast.web.domain.Book;
import cn.itcast.web.domain.Car;
import cn.itcast.web.domain.item;
import cn.itcast.web.shopcar.dao.BookDao;

public class Service {
	//����ͼ���б�
	private BookDao  bookdao = new BookDao();
       public Map<String,Book> findAllBook(){
    	   return bookdao.findAllBook();
       }
       //����ͼ��
       public Book findBookById(String id ){
    	   return bookdao.findBookById(id);
       }
       //����ͼ��
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
	 //ɾ�������ͼ��
	public void deleteBook(String id, Car car) {
		Map<String,item> map = car.getMap();
		map.remove(id);
	}
	//��չ��ﳵ
	public void clearCar(Car car) {
		car.getMap().clear();
		
	}
	//����ͼ������
	public void updateBook(String id,int num ,Car car) {
		Map<String,item> map = car.getMap();
		item it = map.get(id);
		it.setNum(num);
		
	}
	
}
