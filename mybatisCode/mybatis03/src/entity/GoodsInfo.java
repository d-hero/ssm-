package entity;
/***
 * ��Ѫʵ����
 * һ���Ǵӱ�Ҫ��Ϊ��Ѫʵ����
 * ֱ�ӽ����������������ֶΣ���ɶ�Ӧ������
 * @author Administrator
 *
 */
public class GoodsInfo {
	private int id;//����
	private String gName;//��Ʒ����
	private double price;
	private GoodsTypeInfo goodsTypeInfo;//��typeIdȥ�������Ʒ���͹���������
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
