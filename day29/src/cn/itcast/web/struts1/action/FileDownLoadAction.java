package cn.itcast.web.struts1.action;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

public class FileDownLoadAction extends DownloadAction {

	
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		    //绑定要下载的文件
		    File file = new File("d:\\login.png");
		     //通知浏览器以下载的方式打开文件
		    response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(file.getName(), "UTF-8"));
		return new DownloadAction.FileStreamInfo("image/jpeg",file);
	}
      
}
