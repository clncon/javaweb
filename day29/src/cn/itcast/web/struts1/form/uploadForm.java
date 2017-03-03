package cn.itcast.web.struts1.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class uploadForm extends ActionForm {
     private String username;
     int i=0;
     private List<FormFile> upfileList = new ArrayList<FormFile>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<FormFile> getUpfileList() {
		return upfileList;
	}
	//框架自动调用该方法封装upfile,但是注意index从最大数开始减少
	public void setUpfile(int index,FormFile upfile) {
		
		this.upfileList.add(i++, upfile);
		if(index==0){
			i=0;
		}
	}
	
	
    
    
}
