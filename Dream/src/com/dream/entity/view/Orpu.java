package com.dream.entity.view;
/**
 * ���򶩵���
 * @author ��ϼ
 *2016-3-10����6:40:31
 *
 */

public class Orpu {
	//Order��
		private int oId;
		private int oPid; // �����µ�ID
		private int oSid;// ����ID
		private int oUid;// �û�id
		private String oStatus;// ����״̬
		private String oStartdate;// �µ�ʱ��
		private String oEnddate;// �ʹ�ʱ��
	    private String oAddress;//������ַ
	 //purchase��
		private int pId;  //�����µ�ID
		private int pSid;  //�����ID	
		private int pGid; //��Ʒ��ID
		private int  pNum; //��������
		
		public Orpu() {
			// TODO Auto-generated constructor stub
		}

		public Orpu(int oId, int oPid, int oSid, int oUid, String oStatus,
				String oStartdate, String oEnddate, String oAddress, int pId,
				int pSid, int pGid, int pNum) {
			super();
			this.oId = oId;
			this.oPid = oPid;
			this.oSid = oSid;
			this.oUid = oUid;
			this.oStatus = oStatus;
			this.oStartdate = oStartdate;
			this.oEnddate = oEnddate;
			this.oAddress = oAddress;
			this.pId = pId;
			this.pSid = pSid;
			this.pGid = pGid;
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

		@Override
		public String toString() {
			return "Orpu  oId=" + oId + ", oPid=" + oPid + ", oSid=" + oSid
					+ ", oUid=" + oUid + ", oStatus=" + oStatus
					+ ", oStartdate=" + oStartdate + ", oEnddate=" + oEnddate
					+ ", oAddress=" + oAddress + ", pId=" + pId + ", pSid="
					+ pSid + ", pGid=" + pGid + ", pNum=" + pNum + " ";
		}
		
		
		
}
