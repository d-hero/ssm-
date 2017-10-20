package entity;

public class GoodsInfo {
	private String gName;
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getKeepTime() {
		return keepTime;
	}
	public void setKeepTime(int keepTime) {
		this.keepTime = keepTime;
	}
	private double price;
	private String remark;
	private int keepTime;
	private GoodsTypeInfo goodsTypeInfo;
	public GoodsTypeInfo getGoodsTypeInfo() {
		return goodsTypeInfo;
	}
	public void setGoodsTypeInfo(GoodsTypeInfo goodsTypeInfo) {
		this.goodsTypeInfo = goodsTypeInfo;
	}
	@Override
	public String toString() {
		return "GoodsInfo [gName=" + gName + ", price=" + price + ", remark="
				+ remark + ", keepTime=" + keepTime + "]"+":"+goodsTypeInfo.getId();
	}
	
}
