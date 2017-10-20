package DIByConstructor;

public class UserInfo {
	private int id;
	private String uName;
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", uName=" + uName + "]";
	}
	public UserInfo(int id, String uName) {
		super();
		this.id = id;
		this.uName = uName;
	}
	
}
