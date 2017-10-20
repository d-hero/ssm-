package entity;

public class MyFile {
	private int id;
	private String ywjm;//这个用来保存原来的文件名，便于后续的下载
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYwjm() {
		return ywjm;
	}
	public void setYwjm(String ywjm) {
		this.ywjm = ywjm;
	}
	public String getBcwjm() {
		return bcwjm;
	}
	public void setBcwjm(String bcwjm) {
		this.bcwjm = bcwjm;
	}
	private String bcwjm;//这个是用来保存服务器上面的文件名
}
