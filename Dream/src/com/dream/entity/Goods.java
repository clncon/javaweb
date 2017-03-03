package com.dream.entity;

/**
 * 商品类
 * 
 * @author 葛睿 2016-3-3
 */
public class Goods {
	private int gId;
	private String gName;// 商品的名字
	private String gType;// 商品类型
	private Double gPrice;  //商品价格
	private String gAddress;// 商品产地
	private String gPic;// 商品图片
	private String gDescribe; // 商品描述

	public Goods() {
		// TODO Auto-generated constructor stub
	}

	public Goods(int gId, String gName, double gPrice, String gType,
			String gAddress, String gPic, String gDescribe) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gType = gType;
		this.gAddress = gAddress;
		this.gPic = gPic;
		this.gDescribe = gDescribe;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public double getgPrice() {
		return gPrice;
	}

	public void setgPrice(double gPrice) {
		this.gPrice = gPrice;
	}

	public String getgType() {
		return gType;
	}

	public void setgType(String gType) {
		this.gType = gType;
	}

	public String getgAddress() {
		return gAddress;
	}

	public void setgAddress(String gAddress) {
		this.gAddress = gAddress;
	}

	public String getgPic() {
		return gPic;
	}

	public void setgPic(String gPic) {
		this.gPic = gPic;
	}

	public String getgDescribe() {
		return gDescribe;
	}

	public void setgDescribe(String gDescribe) {
		this.gDescribe = gDescribe;
	}

	@Override
	public String toString() {
		return "Goods [gId=" + gId + ", gName=" + gName + ", gPrice=" + gPrice
				+ ", gType=" + gType + ", gAddress=" + gAddress + ", gPic="
				+ gPic + ", gDescribe=" + gDescribe + "]";
	}

}
