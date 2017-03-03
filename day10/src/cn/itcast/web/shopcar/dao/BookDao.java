package cn.itcast.web.shopcar.dao;

import java.util.Map;

import cn.itcast.web.domain.Book;
import cn.itcast.web.shopcar.db.DB;

public class BookDao {
	//返回图书列表
    public  Map<String,Book> findAllBook(){
    	return DB.findAllBook();
    }
    //在数据库中查找图书
    public Book findBookById(String id){
    	return DB.findBookById(id);
    }
}
