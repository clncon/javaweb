package cn.itcast.web.shopcar.db;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.itcast.web.domain.Book;

public class DB {
	private static Map<String,Book> map = new LinkedHashMap();
    static {
    	  map.put("1", new Book("1","java","’‘",11));
    	  map.put("2", new Book("2","xml","«Æ",23));
    	  map.put("3", new Book("3","servlet","ÀÔ",35));
    	  map.put("4", new Book("4","jsp","¿Ó",44));
    	  map.put("5", new Book("5","struts","÷‹",11));
    	  map.put("6", new Book("6","ajax","Œ‚",11));
    	
    }
    public static Map<String,Book> findAllBook(){
    	return map;
    }
    public static Book findBookById(String id){
    	
    	return map.get(id);
    }
}
