
package cn.itcast.bbs.domain;

public class Type {
   //°å¿éÄ£ÐÍ
	 private int id ;
	 private String title ; 
	 private String image; 
	 private String click ;
	 private Admin admin;
	 private int topicNum;
	 private Topic newTopic;
	 public Type(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getClick() {
		return click;
	}
	public void setClick(String click) {
		this.click = click;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public int getTopicNum() {
		return topicNum;
	}
	public void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}
	public Topic getNewTopic() {
		return newTopic;
	}
	public void setNewTopic(Topic newTopic) {
		this.newTopic = newTopic;
	}
	 
	 
}
