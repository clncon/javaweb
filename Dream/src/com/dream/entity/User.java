package com.dream.entity;

/**
 * �û���
 * 
 * @author ��� 2016-3-3
 */
public class User {
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

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int uId, String uName, String uPwd, String sex, String uBir,
			String uPhone, String uMail, String uAddress, String uFlag,
			String uLevel) {
		super();
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

	public User(String uName, String uPwd, String sex, String uBir,
			String uPhone, String uMail, String uAddress, String uFlag,
			String uLevel) {
		super();
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

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uPwd=" + uPwd
				+ ", sex=" + sex + ", uBir=" + uBir + ", uPhone=" + uPhone
				+ ", uMail=" + uMail + ", uAddress=" + uAddress + ", uFlag="
				+ uFlag + ", uLevel=" + uLevel + "]";
	}

}
