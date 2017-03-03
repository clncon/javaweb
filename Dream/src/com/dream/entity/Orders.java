package com.dream.entity;

/**
 * ������
 * 
 * @author ��� 2016-3-3����9:04:58
 */
public class Orders {
	private int oId;
	private int oPid; // �����µ�ID
	// private int oSid;//����ID
	// private int oUid;//�û�id
	private String oStatus;// ����״̬
	private String oStartdate;// �µ�ʱ��
	private String oEnddate;// �ʹ�ʱ��
	private String oAddress;// ������ַ

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(int oId, int oPid, String oStatus, String oStartdate,
			String oEnddate, String oAddress) {
		super();
		this.oId = oId;
		this.oPid = oPid;
		this.oStatus = oStatus;
		this.oStartdate = oStartdate;
		this.oEnddate = oEnddate;
		this.oAddress = oAddress;
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
		return "Orders [oId=" + oId + ", oPid=" + oPid + ", oStatus=" + oStatus
				+ ", oStartdate=" + oStartdate + ", oEnddate=" + oEnddate
				+ ", oAddress=" + oAddress + "]";
	}

}
