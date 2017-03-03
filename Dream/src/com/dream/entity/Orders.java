package com.dream.entity;

/**
 * 订单类
 * 
 * @author 葛睿 2016-3-3下午9:04:58
 */
public class Orders {
	private int oId;
	private int oPid; // 购买下单ID
	// private int oSid;//店面ID
	// private int oUid;//用户id
	private String oStatus;// 订单状态
	private String oStartdate;// 下单时间
	private String oEnddate;// 送达时间
	private String oAddress;// 订单地址

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
