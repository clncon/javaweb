package cn.itcast.web.shopcar.dao;

import java.util.Map;

import cn.itcast.web.domain.Book;
import cn.itcast.web.shopcar.db.DB;

public class BookDao {
	//����ͼ���б�
    public  Map<String,Book> findAllBook(){
    	return DB.findAllBook();
    }
    //�����ݿ��в���ͼ��
    public Book findBookById(String id){
    	return DB.findBookById(id);
    }
}
