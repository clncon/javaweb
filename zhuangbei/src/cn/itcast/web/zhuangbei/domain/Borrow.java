package cn.itcast.web.zhuangbei.domain;

import java.util.Date;

public class Borrow {
	private int id ;
	private String name;
	private int count;
	private Date time;
	
	public Borrow(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

    
}
