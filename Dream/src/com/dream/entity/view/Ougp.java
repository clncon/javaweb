
package com.dream.entity.view;

/**
 * 订单表  购买   商品  用户表
 * @author 林兴鹏
 *
 * 2016-3-11下午1:19:41
 */
public class Ougp {

	  private int oId;
	  private int oPid; //购买下单ID
//	  private int oSid;//店面ID
//	  private int oUid;//用户id
	  private String  oStatus;//订单状态
	  private String oStartdate;//下单时间
	  private String oEnddate;//送达时间
	  private String oAddress;//订单地址
	  
	  private int pId; //购买下单ID
      private int pSid; //店面ID
      private int pGid; //果品ID
      private int pUid; //买家ID
      private int pNum; //数量
      
  	private int gId;  
  	private String gName;//商品的名字
  	private double gPrice; //商品价格
  	private String gType;//商品类型
  	private String gAddress;//商品产地
  	private String gPic;//商品图片
  	private String gDescribe; //商品描述
  	
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
	
	/**
	 * 
	 */
	public Ougp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param oId
	 * @param oPid
	 * @param oStatus
	 * @param oStartdate
	 * @param oEnddate
	 * @param oAddress
	 * @param pId
	 * @param pSid
	 * @param pGid
	 * @param pUid
	 * @param pNum
	 * @param gId
	 * @param gName
	 * @param gPrice
	 * @param gType
	 * @param gAddress
	 * @param gPic
	 * @param gDescribe
	 * @param uId
	 * @param uName
	 * @param uPwd
	 * @param sex
	 * @param uBir
	 * @param uPhone
	 * @param uMail
	 * @param uAddress
	 * @param uFlag
	 * @param uLevel
	 */
	public Ougp(int oId, int oPid, String oStatus, String oStartdate,
			String oEnddate, String oAddress, int pId, int pSid, int pGid,
			int pUid, int pNum, int gId, String gName, double gPrice,
			String gType, String gAddress, String gPic, String gDescribe,
			int uId, String uName, String uPwd, String sex, String uBir,
			String uPhone, String uMail, String uAddress, String uFlag,
			String uLevel) {
		super();
		this.oId = oId;
		this.oPid = oPid;
		this.oStatus = oStatus;
		this.oStartdate = oStartdate;
		this.oEnddate = oEnddate;
		this.oAddress = oAddress;
		this.pId = pId;
		this.pSid = pSid;
		this.pGid = pGid;
		this.pUid = pUid;
		this.pNum = pNum;
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
	}

	/**
	 * @return the oId
	 */
	public int getoId() {
		return oId;
	}

	/**
	 * @param oId the oId to set
	 */
	public void setoId(int oId) {
		this.oId = oId;
	}

	/**
	 * @return the oPid
	 */
	public int getoPid() {
		return oPid;
	}

	/**
	 * @param oPid the oPid to set
	 */
	public void setoPid(int oPid) {
		this.oPid = oPid;
	}

	/**
	 * @return the oStatus
	 */
	public String getoStatus() {
		return oStatus;
	}

	/**
	 * @param oStatus the oStatus to set
	 */
	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}

	/**
	 * @return the oStartdate
	 */
	public String getoStartdate() {
		return oStartdate;
	}

	/**
	 * @param oStartdate the oStartdate to set
	 */
	public void setoStartdate(String oStartdate) {
		this.oStartdate = oStartdate;
	}

	/**
	 * @return the oEnddate
	 */
	public String getoEnddate() {
		return oEnddate;
	}

	/**
	 * @param oEnddate the oEnddate to set
	 */
	public void setoEnddate(String oEnddate) {
		this.oEnddate = oEnddate;
	}

	/**
	 * @return the oAddress
	 */
	public String getoAddress() {
		return oAddress;
	}

	/**
	 * @param oAddress the oAddress to set
	 */
	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}

	/**
	 * @return the pId
	 */
	public int getpId() {
		return pId;
	}

	/**
	 * @param pId the pId to set
	 */
	public void setpId(int pId) {
		this.pId = pId;
	}

	/**
	 * @return the pSid
	 */
	public int getpSid() {
		return pSid;
	}

	/**
	 * @param pSid the pSid to set
	 */
	public void setpSid(int pSid) {
		this.pSid = pSid;
	}

	/**
	 * @return the pGid
	 */
	public int getpGid() {
		return pGid;
	}

	/**
	 * @param pGid the pGid to set
	 */
	public void setpGid(int pGid) {
		this.pGid = pGid;
	}

	/**
	 * @return the pUid
	 */
	public int getpUid() {
		return pUid;
	}

	/**
	 * @param pUid the pUid to set
	 */
	public void setpUid(int pUid) {
		this.pUid = pUid;
	}

	/**
	 * @return the pNum
	 */
	public int getpNum() {
		return pNum;
	}

	/**
	 * @param pNum the pNum to set
	 */
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	/**
	 * @return the gId
	 */
	public int getgId() {
		return gId;
	}

	/**
	 * @param gId the gId to set
	 */
	public void setgId(int gId) {
		this.gId = gId;
	}

	/**
	 * @return the gName
	 */
	public String getgName() {
		return gName;
	}

	/**
	 * @param gName the gName to set
	 */
	public void setgName(String gName) {
		this.gName = gName;
	}

	/**
	 * @return the gPrice
	 */
	public double getgPrice() {
		return gPrice;
	}

	/**
	 * @param gPrice the gPrice to set
	 */
	public void setgPrice(double gPrice) {
		this.gPrice = gPrice;
	}

	/**
	 * @return the gType
	 */
	public String getgType() {
		return gType;
	}

	/**
	 * @param gType the gType to set
	 */
	public void setgType(String gType) {
		this.gType = gType;
	}

	/**
	 * @return the gAddress
	 */
	public String getgAddress() {
		return gAddress;
	}

	/**
	 * @param gAddress the gAddress to set
	 */
	public void setgAddress(String gAddress) {
		this.gAddress = gAddress;
	}

	/**
	 * @return the gPic
	 */
	public String getgPic() {
		return gPic;
	}

	/**
	 * @param gPic the gPic to set
	 */
	public void setgPic(String gPic) {
		this.gPic = gPic;
	}

	/**
	 * @return the gDescribe
	 */
	public String getgDescribe() {
		return gDescribe;
	}

	/**
	 * @param gDescribe the gDescribe to set
	 */
	public void setgDescribe(String gDescribe) {
		this.gDescribe = gDescribe;
	}

	/**
	 * @return the uId
	 */
	public int getuId() {
		return uId;
	}

	/**
	 * @param uId the uId to set
	 */
	public void setuId(int uId) {
		this.uId = uId;
	}

	/**
	 * @return the uName
	 */
	public String getuName() {
		return uName;
	}

	/**
	 * @param uName the uName to set
	 */
	public void setuName(String uName) {
		this.uName = uName;
	}

	/**
	 * @return the uPwd
	 */
	public String getuPwd() {
		return uPwd;
	}

	/**
	 * @param uPwd the uPwd to set
	 */
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the uBir
	 */
	public String getuBir() {
		return uBir;
	}

	/**
	 * @param uBir the uBir to set
	 */
	public void setuBir(String uBir) {
		this.uBir = uBir;
	}

	/**
	 * @return the uPhone
	 */
	public String getuPhone() {
		return uPhone;
	}

	/**
	 * @param uPhone the uPhone to set
	 */
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	/**
	 * @return the uMail
	 */
	public String getuMail() {
		return uMail;
	}

	/**
	 * @param uMail the uMail to set
	 */
	public void setuMail(String uMail) {
		this.uMail = uMail;
	}

	/**
	 * @return the uAddress
	 */
	public String getuAddress() {
		return uAddress;
	}

	/**
	 * @param uAddress the uAddress to set
	 */
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	/**
	 * @return the uFlag
	 */
	public String getuFlag() {
		return uFlag;
	}

	/**
	 * @param uFlag the uFlag to set
	 */
	public void setuFlag(String uFlag) {
		this.uFlag = uFlag;
	}

	/**
	 * @return the uLevel
	 */
	public String getuLevel() {
		return uLevel;
	}

	/**
	 * @param uLevel the uLevel to set
	 */
	public void setuLevel(String uLevel) {
		this.uLevel = uLevel;
	}

	@Override
	public String toString() {
		return "Ougp [oId=" + oId + ", oPid=" + oPid + ", oStatus=" + oStatus
				+ ", oStartdate=" + oStartdate + ", oEnddate=" + oEnddate
				+ ", oAddress=" + oAddress + ", pId=" + pId + ", pSid=" + pSid
				+ ", pGid=" + pGid + ", pUid=" + pUid + ", pNum=" + pNum
				+ ", gId=" + gId + ", gName=" + gName + ", gPrice=" + gPrice
				+ ", gType=" + gType + ", gAddress=" + gAddress + ", gPic="
				+ gPic + ", gDescribe=" + gDescribe + ", uId=" + uId
				+ ", uName=" + uName + ", uPwd=" + uPwd + ", sex=" + sex
				+ ", uBir=" + uBir + ", uPhone=" + uPhone + ", uMail=" + uMail
				+ ", uAddress=" + uAddress + ", uFlag=" + uFlag + ", uLevel="
				+ uLevel + "]";
	}
	
	
	
}
