package entity;
/**
 * 类名是首字母大写
 * 属性名是首字母小写
 * @author Administrator
 *
 */
public class EmpInfo {
	private int id;
	private String eName;
	//private int deptId;//把这个替换成部门类
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	
}
