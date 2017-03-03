package cn.itcast.web.vote.entity;

import java.sql.Date;

public class Info {
	private int id ;
	private String ip;
	private Date votetime;
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Info(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getVotetime() {
		return votetime;
	}

	public void setVotetime(Date votetime) {
		this.votetime = votetime;
	};
	
	
}
