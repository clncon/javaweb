package com.dream.entity.view;
/**
 * ���򶩵��û�������
 * @author  ���� 
 *2016-3-4����2:03:07
 */
public class Orpuusst {
	//store��
	private int  sId;//����ID
	private String sName; // ��������
	private String sPhone;// ����ĵ绰
	private String sAddress;// �����λ��
	//user��
	private int uId; // �û�ID
	private String uName; // �û���
	private String uPwd; // �û�����
	private String sex; // �Ա�
	private String uBir; // ����
	private String uPhone; // �绰
	private String uMail; // ����
	private String uAddress; // ���õ�ַ
	private String uFlag; // Ȩ�� ��ͨ�û� ���� ��̨����
	private String uLevel;// ��Ա�ȼ�
	//purchase��
	private int pId;  //�����µ�ID
	private int pSid;  //�����ID	
	private int pGid; //��Ʒ��ID
	private int  pNum; //��������
	//Order��
	private int oId;
	private int oPid; // �����µ�ID
	private int oSid;// ����ID
	private int oUid;// �û�id
	private String oStatus;// ����״̬
	private String oStartdate;// �µ�ʱ��
	private String oEnddate;// �ʹ�ʱ��
    private String oAddress;//������ַ
    
    public Orpuusst() {
		// TODO Auto-generated constructor stub
	}

	public Orpuusst(int sId, String sName, String sPhone, String sAddress,
			int uId, String uName, String uPwd, String sex, String uBir,
			String uPhone, String uMail, String uAddress, String uFlag,
			String uLevel, int pId, int pSid, int pGid, int pNum, int oId,
			int oPid, int oSid, int oUid, String oStatus, String oStartdate,
			String oEnddate, String oAddress) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sAddress = sAddress;
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
		this.pNum = pNum;
		this.oId = oId;
		this.oPid = oPid;
		this.oSid = oSid;
		this.oUid = oUid;
		this.oStatus = oStatus;
		this.oStartdate = oStartdate;
		this.oEnddate = oEnddate;
		this.oAddress = oAddress;
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

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public int getoPid() {
		return oPid;
	}

	public void setoPid(int oPid) {
		this.oPid = oPid;
	}

	public int getoSid() {
		return oSid;
	}

	public void setoSid(int oSid) {
		this.oSid = oSid;
	}

	public int getoUid() {
		return oUid;
	}

	public void setoUid(int oUid) {
		this.oUid = oUid;
	}

	public String getoStatus() {
		return oStatus;
	}

	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}

	public String getoStartdate() {
		return oStartdate;
	}

	public void setoStartdate(String oStartdate) {
		this.oStartdate = oStartdate;
	}

	public String getoEnddate() {
		return oEnddate;
	}

	public void setoEnddate(String oEnddate) {
		this.oEnddate = oEnddate;
	}

	public String getoAddress() {
		return oAddress;
	}

	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}

	@Override
	public String toString() {
		return "Orpuusst [sId=" + sId + ", sName=" + sName + ", sPhone="
				+ sPhone + ", sAddress=" + sAddress + ", uId=" + uId
				+ ", uName=" + uName + ", uPwd=" + uPwd + ", sex=" + sex
				+ ", uBir=" + uBir + ", uPhone=" + uPhone + ", uMail=" + uMail
				+ ", uAddress=" + uAddress + ", uFlag=" + uFlag + ", uLevel="
				+ uLevel + ", pId=" + pId + ", pSid=" + pSid + ", pGid=" + pGid
				+ ", pNum=" + pNum + ", oId=" + oId + ", oPid=" + oPid
				+ ", oSid=" + oSid + ", oUid=" + oUid + ", oStatus=" + oStatus
				+ ", oStartdate=" + oStartdate + ", oEnddate=" + oEnddate
				+ ", oAddress=" + oAddress + "]";
	}
    

	
}
