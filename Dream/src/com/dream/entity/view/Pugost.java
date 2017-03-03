package com.dream.entity.view;

/**
 * 购买店面商品类
 * @author 晓风 2016-3-4上午11:04:50
 */
public class Pugost {
	//store表
    private int sid;
	private String sName; // 店面名字
	private String sPhone;// 店面的电话
	private String sAddress;// 店面的位置
	//goods表
	private int gId;
	private String gName;// 商品的名字
	private double gPrice; // 商品价格
	private String gType;// 商品类型
	private String gAddress;// 商品产地
	private String gPic;// 商品图片
	private String gDescribe; // 商品描述
	//purchase表
	private int pId; //购买下单ID
    private int pSid; //店面的ID	
    private int pGid; //商品的ID
    private int  pNum; //库存的数量

	public Pugost() {
		// TODO Auto-generated constructor stub
	}

	public Pugost(int sid, String sName, String sPhone, String sAddress,
			int gId, String gName, double gPrice, String gType,
			String gAddress, String gPic, String gDescribe, int pId, int pSid,
			int pGid, int pNum) {
		super();
		this.sid = sid;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sAddress = sAddress;
		this.gId = gId;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gType = gType;
		this.gAddress = gAddress;
		this.gPic = gPic;
		this.gDescribe = gDescribe;
		this.pId = pId;
		this.pSid = pSid;
		this.pGid = pGid;
		this.pNum = pNum;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getpSid() {
		return pSid;
	}

	public void setpSid(int pSid) {
		this.pSid = pSid;
	}

	public int getpGid() {
		return pGid;
	}

	public void setpGid(int pGid) {
		this.pGid = pGid;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	@Override
	public String toString() {
		return "Pugost [sid=" + sid + ", sName=" + sName + ", sPhone=" + sPhone
				+ ", sAddress=" + sAddress + ", gId=" + gId + ", gName="
				+ gName + ", gPrice=" + gPrice + ", gType=" + gType
				+ ", gAddress=" + gAddress + ", gPic=" + gPic + ", gDescribe="
				+ gDescribe + ", pId=" + pId + ", pSid=" + pSid + ", pGid="
				+ pGid + ", pNum=" + pNum + "]";
	}

}
