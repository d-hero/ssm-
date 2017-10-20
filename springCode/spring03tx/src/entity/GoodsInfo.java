package entity;
/***
 * 充血实体类
 * 一般是从表要作为充血实体类
 * 直接将关联到主表的外键字段，变成对应的类型
 * @author Administrator
 *
 */
public class GoodsInfo {
	private int id;//主键
	private String gName;//商品名称
	private double price;
	private GoodsTypeInfo goodsTypeInfo;//将typeId去掉变成商品类型关联进来。
	public GoodsTypeInfo getGoodsTypeInfo() {
		return goodsTypeInfo;
	}
	public void setGoodsTypeInfo(GoodsTypeInfo goodsTypeInfo) {
		this.goodsTypeInfo = goodsTypeInfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "GoodsInfo [id=" + id + ", gName=" + gName + ", price=" + price
				+ ", goodsTypeInfo=" + goodsTypeInfo + "]";
	}
	
}
