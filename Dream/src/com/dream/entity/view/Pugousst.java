package com.dream.entity.view;

/**
 * ��ҹ��������Ʒ��
 * @author ���� 2016-3-4����11:04:50
 */
public class Pugousst {
	//store��
    private int sid;
	private String sName; // ��������
	private String sPhone;// ����ĵ绰
	private String sAddress;// �����λ��
	private String sUid; //����ID
	
	//goods��
	private int gId;
	private String gName;// ��Ʒ������
	private double gPrice; // ��Ʒ�۸�
	private String gType;// ��Ʒ����
	private String gAddress;// ��Ʒ����
	private String gPic;// ��ƷͼƬ
	private String gDescribe; // ��Ʒ����
	
	//user��
	private int uId;    //�û�ID
	private String uName; //�û���
	private String uPwd;  //�û�����
	private String sex; //	�Ա�
	private String uBir; //����
	private String uPhone;  //�绰
	private String uMail; //����
	private String uAddress; //���õ�ַ
	private String uFlag; //Ȩ��	��ͨ�û� ���� ��̨����
	private String uLevel;//��Ա�ȼ�
	
	//purchase��
	private int pId; //�����µ�ID
    private int pSid; //�����ID	
    private int pGid; //��Ʒ��ID
    private int pUid; //���ID
    private int  pNum; //��������

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
