package com.dream.entity.view;

/**
 * 商品库存店面类
 * @author 葛睿
 *2016-3-4上午11:02:18
 */
public class Regost {
	private int gId;  
	private String gName;//商品的名字
	private double gPrice; //商品价格
	private String gType;//商品类型
	private String gAddress;//商品产地
	private String gPic;//商品图片
	private String gDescribe; //商品描述
	private int rNum;//库存的数量
	private int sId;//店面Id
	private String sName;  //店面名字
	private String sPhone;//店面的电话
	private String sAddress;//店面的位置
	public Regost() {
			// TODO Auto-generated constructor stub
		}
	public Regost(int gId, String gName, double gPrice, String gType,
			String gAddress, String gPic, String gDescribe, int rNum, int sId,
			String sName, String sPhone, String sAddress) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gType = gType;
		this.gAddress = gAddress;
		this.gPic = gPic;
		this.gDescribe = gDescribe;
		this.rNum = rNum;
		this.sId = sId;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sAddress = sAddress;
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
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	@Override
	public String toString() {
		return "Regost  gId=" + gId + ", gName=" + gName + ", gPrice=" + gPrice
				+ ", gType=" + gType + ", gAddress=" + gAddress + ", gPic="
				+ gPic + ", gDescribe=" + gDescribe + ", rNum=" + rNum
				+ ", sId=" + sId + ", sName=" + sName + ", sPhone=" + sPhone
				+ ", sAddress=" + sAddress + " ";
	}
		
  
}
