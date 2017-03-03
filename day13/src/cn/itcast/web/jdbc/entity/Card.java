package cn.itcast.web.jdbc.entity;

public class Card {
   private int id;
   private String location;
   private person per;
   
   public Card(){}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public person getPer() {
	return per;
}

public void setPer(person per) {
	this.per = per;
}
   
   
}
