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
	//����Զ����ø÷�����װupfile,����ע��index���������ʼ����
	public void setUpfile(int index,FormFile upfile) {
		
		this.upfileList.add(i++, upfile);
		if(index==0){
			i=0;
		}
	}
	
	
    
    
}
