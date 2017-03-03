package cn.itcast.web.vote.entity;

public class Vote {
	private int id;
	private String content;
	 private int ticket;
	 public Vote(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	 
	 
}
