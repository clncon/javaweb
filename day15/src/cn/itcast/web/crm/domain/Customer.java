package cn.itcast.web.crm.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
 private int id;
 private String name;
 private  String gender;
 private  String address;
 private  String tel;
 private  String email;

 //-------------------
  private String year;
  private String month;
  private String day;
  public void setYear(String year) {
	  this.year = year;
  }
  
  public void setMonth(String month) {
	  this.month = month;
  }
  
  public void setDay(String day) {
	  this.day = day;
  }
 //-------------------
  private  Date birthday;
 

public Customer(){}

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

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getBirthday() throws Exception {
	//String -->Date
	try {
		if(this.year!=null&&this.month!=null&&this.day!=null){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.birthday = sdf.parse(this.year+"-"+this.month+"-"+this.day);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw e;
	}
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
}
