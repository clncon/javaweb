package com.dream.entity;

/**
 * 活动类
 * 
 * @author 小平 2016-3-11上午10:54:58
 */
public class Activity {
	private int aId; // 活动Id
	private int aGid;// 商品id
	private double aprice;// 活动价格
	private String adate; // 活动的日期
	private String apic;// 活动的图片

	public Activity() {
		// TODO Auto-generated constructor stub
	}

	public Activity(int aId, int aGid, double aprice, String adate, String apic) {
		super();
		this.aId = aId;
		this.aGid = aGid;
		this.aprice = aprice;
		this.adate = adate;
		this.apic = apic;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public int getaGid() {
		return aGid;
	}

	public void setaGid(int aGid) {
		this.aGid = aGid;
	}

	public double getAprice() {
		return aprice;
	}

	public void setAprice(double aprice) {
		this.aprice = aprice;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public String getApic() {
		return apic;
	}

	public void setApic(String apic) {
		this.apic = apic;
	}

	@Override
	public String toString() {
		return "Activity [aId=" + aId + ", aGid=" + aGid + ", aprice=" + aprice
				+ ", adate=" + adate + ", apic=" + apic + "]";
	}

}
