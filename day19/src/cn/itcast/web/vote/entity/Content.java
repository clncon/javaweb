package cn.itcast.web.vote.entity;

public class Content {
	private int id ;
	private int age;
	private String description;
	private Vote vote;
	private Image image;
	
	
	public Content(){}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAge() {
		return age;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Vote getVote() {
		return vote;
	}


	public void setVote(Vote vote) {
		this.vote = vote;
	}
	
	
}
