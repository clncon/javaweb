package com.dream.entity.view;

/**
 * 活动和商品类
 * @author 小平
 *2016-3-11上午10:55:09
 */
public class AcGoods {
	  private int aId ; //活动Id
	   private  int aGid;//商品id
	   private  double aprice;//活动价格
	   private  String 	adate; //活动的日期
	   private String apic;// 活动的图片
	   
	   private int gId;  
		private String gName;//商品的名字
		private double gPrice; //商品价格
		private String gType;//商品类型
		private String gAddress;//商品产地
		private String gPic;//商品图片
		private String gDescribe; //商品描述
		public AcGoods() {
			// TODO Auto-generated constructor stub
		}
		public AcGoods(int aId, int aGid, double aprice, String adate,
				String apic, int gId, String gName, double gPrice,
				String gType, String gAddress, String gPic, String gDescribe) {
			super();
			this.aId = aId;
			this.aGid = aGid;
			this.aprice = aprice;
			this.adate = adate;
			this.apic = apic;
			this.gId = gId;
			this.gName = gName;
			this.gPrice = gPrice;
			this.gType = gType;
			this.gAddress = gAddress;
			this.gPic = gPic;
			this.gDescribe = gDescribe;
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
			return "AcGoods [aId=" + aId + ", aGid=" + aGid + ", aprice="
					+ aprice + ", adate=" + adate + ", apic=" + apic + ", gId="
					+ gId + ", gName=" + gName + ", gPrice=" + gPrice
					+ ", gType=" + gType + ", gAddress=" + gAddress + ", gPic="
					+ gPic + ", gDescribe=" + gDescribe + "]";
		}
		

}
