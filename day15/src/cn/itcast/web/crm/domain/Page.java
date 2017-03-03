package cn.itcast.web.crm.domain;

import java.util.ArrayList;
import java.util.List;

public class Page {
  private int perpageNo = 3;
  private int currentPageNO;
  private int allRecordNo;
  private int allPageNO;
  private List<Customer> listCustomer = new ArrayList<Customer>();
  
  public Page(){}

public int getPerpageNo() {
	return perpageNo;
}

public void setPerpageNo(int perpageNo) {
	this.perpageNo = perpageNo;
}

public int getCurrentPageNO() {
	return currentPageNO;
}

public void setCurrentPageNO(int currentPageNO) {
	this.currentPageNO = currentPageNO;
}

public int getAllRecordNo() {
	return allRecordNo;
}

public void setAllRecordNo(int allRecordNo) {
	if(allRecordNo % this.perpageNo==0){
		this.allPageNO = allRecordNo / this.perpageNo;
	}
	else{
		this.allPageNO = allRecordNo / this.perpageNo+1;
		
	}
	this.allRecordNo = allRecordNo;
}

public int getAllPageNO() {
	return allPageNO;
}

public void setAllPageNO(int allPageNO) {
	this.allPageNO = allPageNO;
}


public List<Customer> getListCustomer() {
	return listCustomer;
}

public void setListCustomer(List<Customer> listCustomer) {
	this.listCustomer = listCustomer;
}
  
  
}
