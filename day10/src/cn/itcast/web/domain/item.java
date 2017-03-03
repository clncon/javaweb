package cn.itcast.web.domain;

public class item {
  private Book book;
  private int num;
  private double itemPirce;
  
  public item(){}

public Book getBook() {
	return book;
}

public void setBook(Book book) {
	this.book = book;
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public double getItemPirce() {
	
	return this.book.getPrice()*this.num;
}

public void setItemPirce(double itemPirce) {
	this.itemPirce = itemPirce;
}
  
}
