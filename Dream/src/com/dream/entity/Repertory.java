package com.dream.entity;

/**
 * �����
 * 
 * @author ��� 2016-3-3
 */
public class Repertory {
	private int rId;
	private int rGid;// ��ƷID
	private int rSid;// ����ID
	private int rNum;// ��������

	public Repertory() {
		// TODO Auto-generated constructor stub
	}

	public Repertory(int rId, int rGid, int rSid, int rNum) {
		super();
		this.rId = rId;
		this.rGid = rGid;
		this.rSid = rSid;
		this.rNum = rNum;
	}

	public Repertory(int rGid, int rSid, int rNum) {
		super();
		this.rGid = rGid;
		this.rSid = rSid;
		this.rNum = rNum;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int getrGid() {
		return rGid;
	}

	public void setrGid(int rGid) {
		this.rGid = rGid;
	}

	public int getrSid() {
		return rSid;
	}

	public void setrSid(int rSid) {
		this.rSid = rSid;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	@Override
	public String toString() {
		return "Repertory   rId=" + rId + ", rGid=" + rGid + ", rSid=" + rSid
				+ ", rNum=" + rNum + "  ";
	}

}
