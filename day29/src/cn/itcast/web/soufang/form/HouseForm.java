package cn.itcast.web.soufang.form;

import org.apache.struts.action.ActionForm;

public class HouseForm extends ActionForm {
	
	private String area;
	private String address;
	private String space ;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	
	
} 
