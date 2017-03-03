package com.dream.entity.view;

/**
 * 买家购买店面商品类
 * @author 晓风 2016-3-4上午11:04:50
 */
public class Pugousst {
	//store表
    private int sid;
	private String sName; // 店面名字
	private String sPhone;// 店面的电话
	private String sAddress;// 店面的位置
	private String sUid; //店主ID
	
	//goods表
	private int gId;
	private String gName;// 商品的名字
	private double gPrice; // 商品价格
	private String gType;// 商品类型
	private String gAddress;// 商品产地
	private String gPic;// 商品图片
	private String gDescribe; // 商品描述
	
	//user表
	private int uId;    //用户ID
	private String uName; //用户名
	private String uPwd;  //用户密码
	private String sex; //	性别
	private String uBir; //生日
	private String uPhone;  //电话
	private String uMail; //邮箱
	private String uAddress; //常用地址
	private String uFlag; //权限	普通用户 卖家 后台管理
	private String uLevel;//会员等级
	
	//purchase表
	private int pId; //购买下单ID
    private int pSid; //店面的ID	
    private int pGid; //商品的ID
    private int pUid; //买家ID
    private int  pNum; //库存的数量

	public Pugousst() {
		// TODO Auto-generated constructor stub
	}

	public Pugousst(int sid, String sName, String sPhone, String sAddress,
			String sUid, int gId, String gName, double gPrice, String gType,
			String gAddress, String gPic, String gDescribe, int uId,
			String uName, String uPwd, String sex, String uBir, String uPhone,
			String uMail, String uAddress, String uFlag, String uLevel,
			int pId, int pSid, int pGid, int pUid, int pNum) {
		super();
		this.sid = sid;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sAddress = sAddress;
		this.sUid = sUid;
		this.gId = gId;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gType = gType;
		this.gAddress = gAddress;
		this.gPic = gPic;
		this.gDescribe = gDescribe;
		this.uId = uId;
		this.uName = uName;
		this.uPwd = uPwd;
		this.sex = sex;
		this.uBir = uBir;
		this.uPhone = uPhone;
		this.uMail = uMail;
		this.uAddress = uAddress;
		this.uFlag = uFlag;
		this.uLevel = uLevel;
		this.pId = pId;
		this.pSid = pSid;
		this.pGid = pGid;
		this.pUid = pUid;
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

	public String getsUid() {
		return sUid;
	}

	public void setsUid(String sUid) {
		this.sUid = sUid;
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

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getuBir() {
		return uBir;
	}

	public void setuBir(String uBir) {
		this.uBir = uBir;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getuMail() {
		return uMail;
	}

	public void setuMail(String uMail) {
		this.uMail = uMail;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getuFlag() {
		return uFlag;
	}

	public void setuFlag(String uFlag) {
		this.uFlag = uFlag;
	}

	public String getuLevel() {
		return uLevel;
	}

	public void setuLevel(String uLevel) {
		this.uLevel = uLevel;
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

	public int getpUid() {
		return pUid;
	}

	public void setpUid(int pUid) {
		this.pUid = pUid;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	@Override
	public String toString() {
		return "Pugousst [sid=" + sid + ", sName=" + sName + ", sPhone="
				+ sPhone + ", sAddress=" + sAddress + ", sUid=" + sUid
				+ ", gId=" + gId + ", gName=" + gName + ", gPrice=" + gPrice
				+ ", gType=" + gType + ", gAddress=" + gAddress + ", gPic="
				+ gPic + ", gDescribe=" + gDescribe + ", uId=" + uId
				+ ", uName=" + uName + ", uPwd=" + uPwd + ", sex=" + sex
				+ ", uBir=" + uBir + ", uPhone=" + uPhone + ", uMail=" + uMail
				+ ", uAddress=" + uAddress + ", uFlag=" + uFlag + ", uLevel="
				+ uLevel + ", pId=" + pId + ", pSid=" + pSid + ", pGid=" + pGid
				+ ", pUid=" + pUid + ", pNum=" + pNum + "]";
	}

	

}
