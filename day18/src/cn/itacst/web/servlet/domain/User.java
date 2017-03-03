package cn.itacst.web.servlet.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class User {
	private  String username;
	private  List<FileItem> fileItems = new ArrayList<FileItem>();
	
	public User(){}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<FileItem> getFileItems() {
		return fileItems;
	}

	public void setFileItems(List<FileItem> fileItems) {
		this.fileItems = fileItems;
	}
	
	

}
