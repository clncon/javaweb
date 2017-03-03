package cn.itcast.web.jdbc.entity;


import java.util.ArrayList;
import java.util.List;

public class Page {
	private int allrecordNO;
	private int currPageNO;
	private int perPageNO=3;
	private int allPageNO;
	private List<User> list = new ArrayList<User>();
	
	public Page(){}

	public int getAllrecordNO() {
		return allrecordNO;
	}

	public void setAllrecordNO(int allrecordNO) {
		this.allrecordNO = allrecordNO;
		if(this.allrecordNO % this.perPageNO==0){
			this.allPageNO = this.allrecordNO/this.perPageNO;
		}
		else{
			this.allPageNO = this.allrecordNO/this.perPageNO+1;
		}
	}

	public int getCurrPageNO() {
		return currPageNO;
	}

	public void setCurrPageNO(int currPageNO) {
		this.currPageNO = currPageNO;
	}

	public int getPerPageNO() {
		return perPageNO;
	}

	public void setPerPageNO(int perPageNO) {
		this.perPageNO = perPageNO;
	}

	public int getAllPageNO() {
		return allPageNO;
	}

	public void setAllPageNO(int allPageNO) {
		this.allPageNO = allPageNO;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	};
	
	

}
