package cn.itcast.web.zhuangbei.listen;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.itcast.web.zhuangbei.domain.Borrow;
import cn.itcast.web.zhuangbei.service.EquipService;

public class TimeListener implements ServletContextListener{
     Timer timer = new Timer();
     EquipService equipservice = new EquipService();
     boolean flag=false;
	
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

	
	public void contextInitialized(final ServletContextEvent sce) {
		
		final ServletContext context=sce.getServletContext();
		
		 timer.schedule(new TimerTask() {
		 	
			public void run() {
				try {
					 flag=false;
					List<Borrow> listBorrow = equipservice.findAllBorrow();
		
					for(Borrow borrow : listBorrow){
						//取得每个borrow的借贷时间
						Date date = borrow.getTime();
						//检测每个借带时间和当前的时间差
						Long time = System.currentTimeMillis()-date.getTime();
						String tip = (String) context.getAttribute("tip");
						//判断时间差是否大于3小时
						if(time>24*60*60){

							if(tip==null){

								context.setAttribute("tip","你有装备必须在近期归还");
								flag=true;
							}


						}
					}
					if(flag=false){
					context.removeAttribute("tip");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		 }, 0, 1000);
		
	}

}
