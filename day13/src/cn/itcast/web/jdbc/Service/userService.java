package cn.itcast.web.jdbc.Service;

import cn.itcast.web.jdbc.dao.IUserDao;
import cn.itcast.web.jdbc.entity.Page;
import cn.itcast.web.jdbc.entity.User;
import cn.itcast.web.jdbc.factory.DaoFactory;

public class userService {
	private IUserDao iuserdao = DaoFactory.getDaoFactory().getUserDao();
	//µÇÂ¼·þÎñ
	public boolean login(String username,String password){
		//return userdao.find(username, password);
		return iuserdao.find(username, password);
		
	}
    public boolean register(User user){
    	return iuserdao.add(user);
    }
    public Page fy(int currPageNO){
    	int start;
    	Page page = new Page();
    	
    	 page.setAllrecordNO( iuserdao.getAllRecordNO());
    	 start = (currPageNO-1)*page.getPerPageNO();
    	  page.setList(iuserdao.find(start, page.getPerPageNO()));
    	return page;
    }
}
