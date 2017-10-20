package DIObject;

public class UserInfo {
	private int id;
	private String uName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", uName=" + uName + "]";
	}
	
}
