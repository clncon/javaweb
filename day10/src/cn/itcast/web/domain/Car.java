package cn.itcast.web.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Car {
	private  Map<String,item> map = new LinkedHashMap<String, item>();
	private double totalPrice;
	
	
	public Car(){}


	

	public Map<String, item> getMap() {
		return map;
	}




	public void setMap(Map<String, item> map) {
		this.map = map;
	}


	public double getTotalPrice() {
		double sum =0;
		Set<Entry<String,item>> entryset = map.entrySet();
		for(Entry<String, item> entry : entryset){
			item it = entry.getValue();
			
			sum = sum +it.getItemPirce();
		}
		this.totalPrice = sum;
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	


}