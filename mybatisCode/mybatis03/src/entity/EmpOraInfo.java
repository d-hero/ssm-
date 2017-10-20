package entity;

public class EmpOraInfo {
private int id;
private String eName;
private DeptOraInfo deptorainfo;
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
public DeptOraInfo getDeptorainfo() {
	return deptorainfo;
}
public void setDeptorainfo(DeptOraInfo deptorainfo) {
	this.deptorainfo = deptorainfo;
}

}
