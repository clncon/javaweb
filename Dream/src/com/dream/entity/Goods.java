package com.dream.entity;

/**
 * ��Ʒ��
 * 
 * @author ��� 2016-3-3
 */
public class Goods {
	private int gId;
	private String gName;// ��Ʒ������
	private String gType;// ��Ʒ����
	private Double gPrice;  //��Ʒ�۸�
	private String gAddress;// ��Ʒ����
	private String gPic;// ��ƷͼƬ
	private String gDescribe; // ��Ʒ����

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
