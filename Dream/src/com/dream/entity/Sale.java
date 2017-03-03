package com.dream.entity;

/**
 * ������
 * 
 * @author ��� 2016-3-3����9:09:06
 */
public class Sale {
	private int saId;
	private String saSname;// ���������
	private int saNum;// ��������
	private double saPrice;// ���۽��
	private int saVisitor;// �ÿ�����

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
