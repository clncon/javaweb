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
						//ȡ��ÿ��borrow�Ľ��ʱ��
						Date date = borrow.getTime();
						//���ÿ�����ʱ��͵�ǰ��ʱ���
						Long time = System.currentTimeMillis()-date.getTime();
						String tip = (String) context.getAttribute("tip");
						//�ж�ʱ����Ƿ����3Сʱ
						if(time>24*60*60){

							if(tip==null){

								context.setAttribute("tip","����װ�������ڽ��ڹ黹");
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
