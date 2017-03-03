package com.dream.entity;

/**
 * 销售类
 * 
 * @author 葛睿 2016-3-3下午9:09:06
 */
public class Sale {
	private int saId;
	private String saSname;// 店面的名字
	private int saNum;// 订单数量
	private double saPrice;// 销售金额
	private int saVisitor;// 访客数量

	public Sale() {
		// TODO Auto-generated constructor stub
	}

	public Sale(int saId, String saSname, int saNum, double saPrice,
			int saVisitor) {
		super();
		this.saId = saId;
		this.saSname = saSname;
		this.saNum = saNum;
		this.saPrice = saPrice;
		this.saVisitor = saVisitor;
	}

	public int getSaId() {
		return saId;
	}

	public void setSaId(int saId) {
		this.saId = saId;
	}

	public String getSaSname() {
		return saSname;
	}

	public void setSaSname(String saSname) {
		this.saSname = saSname;
	}

	public int getSaNum() {
		return saNum;
	}

	public void setSaNum(int saNum) {
		this.saNum = saNum;
	}

	public double getSaPrice() {
		return saPrice;
	}

	public void setSaPrice(double saPrice) {
		this.saPrice = saPrice;
	}

	public int getSaVisitor() {
		return saVisitor;
	}

	public void setSaVisitor(int saVisitor) {
		this.saVisitor = saVisitor;
	}

	@Override
	public String toString() {
		return "Sale [saId=" + saId + ", saSname=" + saSname + ", saNum="
				+ saNum + ", saPrice=" + saPrice + ", saVisitor=" + saVisitor
				+ "]";
	}

}
