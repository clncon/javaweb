package cn.itcast.web.struts1.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import cn.itcast.web.struts1.form.uploadForm;

public class uploadAction extends Action {
     
    public ActionForward execute(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
    	   response.setContentType("text/html;charset=utf-8");
    	     uploadForm uf = (uploadForm) form;
    	      List<FormFile> upfileList = uf.getUpfileList();
    	      Iterator<FormFile> it = upfileList.listIterator();
    	      while(it.hasNext()){
    	    	   FormFile upfile = it.next();
    	    	   String fileName = upfile.getFileName();
    				InputStream is = upfile.getInputStream();
    				OutputStream os = new FileOutputStream("d:\\" + fileName);
    				byte[] buf = new byte[2048];
    				int len = 0;
    				while((len=is.read(buf))>0){
    					os.write(buf,0,len);
    				}
    				is.close();
    				os.close();
    	      }
    	      response.getWriter().write("上传成功");
    	return null;
    }
}
