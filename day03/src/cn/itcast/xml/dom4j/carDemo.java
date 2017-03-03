package cn.itcast.xml.dom4j;

public class carDemo implements Comparable<carDemo> {
	private String carTime;
    private String  carLog;
    private String carProduce;
    private double carPrice;
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	public String getCarTime() {
		return carTime;
	}
	public void setCarTime(String carTime) {
		this.carTime = carTime;
	}
	public String getCarLog() {
		return carLog;
	}
	public void setCarLog(String carLog) {
		this.carLog = carLog;
	}
	public String getCarProduce() {
		return carProduce;
	}
	public void setCarProduce(String carProduce) {
		this.carProduce = carProduce;
	}

	public int compareTo(carDemo o) {
		if(this.carPrice>o.getCarPrice()){
			return -1;
		}
		else if(this.carPrice<o.getCarPrice()){
			return 1;
		}
		else 
		{
			return 0;
		}
       
	}
    
    

}
