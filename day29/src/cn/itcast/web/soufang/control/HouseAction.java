package cn.itcast.web.soufang.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.itcast.web.soufang.domain.House;
import cn.itcast.web.soufang.form.HouseForm;
import cn.itcast.web.soufang.service.HouseService;

public class HouseAction extends MappingDispatchAction {

	
	public ActionForward findHouse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   
		   House house = new House();
		   HouseForm houseform = (HouseForm) form;
		   BeanUtils.copyProperties(house,houseform);
		   HouseService houseservice = new HouseService();
		  List<House> listhouse= houseservice.findHouseByHouse(house);
		  request.setAttribute("ListHouse", listhouse);
		return mapping.findForward("ToIndexJsp");
	}
        
}
