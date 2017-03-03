package cn.itcast.web.domain;

public class Book {
      private String id ;
      private String name;
      private String athor;
      private double price;
     public Book(){}

	public Book(String id, String name, String athor, double price) {
		super();
		this.id = id;
		this.name = name;
		this.athor = athor;
		this.price = price;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAthor() {
		return athor;
	}

	public void setAthor(String athor) {
		this.athor = athor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
     
     
}
