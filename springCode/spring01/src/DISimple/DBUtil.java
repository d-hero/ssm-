package DISimple;

public class DBUtil {
	@Override
	public String toString() {
		return "DBUtil [driverName=" + driverName + ", url=" + url + ", user="
				+ user + "]";
	}
	private String driverName;//Çý¶¯
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	private String url;
	private String user;
}
