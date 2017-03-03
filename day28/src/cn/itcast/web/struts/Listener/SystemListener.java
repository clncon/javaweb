package cn.itcast.web.struts.Listener;

import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class SystemListener implements ServletContextListener {

	
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	
	public void contextInitialized(ServletContextEvent arg0) {
		  //×¢²áÒ»¸ö×ª»»Æ÷String->Date
	    ConvertUtils.register(new DateLocaleConverter(Locale.CHINA, "yyyy-MM-dd"), Date.class);

	}

}
