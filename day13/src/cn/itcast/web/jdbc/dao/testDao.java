package cn.itcast.web.jdbc.dao;

import cn.itcast.web.jdbc.entity.Card;
import cn.itcast.web.jdbc.entity.person;

public class testDao {

	
	public static void main(String[] args) {
		person p = new person();
		p.setName("xixi");
		Card card = new Card();
		card.setLocation("BJ");
		p.setCard(card);
		card.setPer(p);
		dao Dao = new dao();
		Dao.save(p);

	}

}
