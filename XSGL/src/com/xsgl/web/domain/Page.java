package com.xsgl.web.domain;

import java.util.ArrayList;
import java.util.List;

public class Page {
   private int perPageNo = 5;
   private int currentPageNo;
   private int allRecoderNo;
   private int allPageNo;
   private List<Student> listStudent = new ArrayList<Student>();
   public Page(){}
public int getPerPageNo() {

	return perPageNo;
}
public void setPerPageNo(int perPageNo) {
	this.perPageNo = perPageNo;
}
public int getCurrentPageNo() {
	return currentPageNo;
}
public void setCurrentPageNo(int currentPageNo) {
	this.currentPageNo = currentPageNo;
}
public int getAllRecoderNo() {
	return allRecoderNo;
}
public void setAllRecoderNo(int allRecoderNo) {
	if(allRecoderNo % this.perPageNo==0){
		this.allPageNo = allRecoderNo / this.perPageNo;
	}
	else{
		this.allPageNo = allRecoderNo / this.perPageNo+1;
		
	}
	this.allRecoderNo = allRecoderNo;
}
public int getAllPageNo() {
	return allPageNo;
}
public void setAllPageNo(int allPageNo) {
	this.allPageNo = allPageNo;
}
public List<Student> getListStudent() {
	return listStudent;
}
public void setListStudent(List<Student> listStudent) {
	this.listStudent = listStudent;
}
   
   
}
