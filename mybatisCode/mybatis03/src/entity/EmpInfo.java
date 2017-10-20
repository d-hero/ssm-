package entity;

public class EmpInfo {
	private int id;
	private String eName;
	//private int deptId;//把这个替换成部门类
	private DeptInfo deptInfo;
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
	public DeptInfo getDeptInfo() {
		return deptInfo;
	}
	public void setDeptInfo(DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}
}
