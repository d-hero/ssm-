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
	
}
