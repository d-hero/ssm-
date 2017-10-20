package entity;

import java.util.List;

public class DeptOraInfo {
private int id;
private String dName;
private List<EmpOraInfo> emps;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getdName() {
	return dName;
}
public void setdName(String dName) {
	this.dName = dName;
}
public List<EmpOraInfo> getEmps() {
	return emps;
}
public void setEmps(List<EmpOraInfo> emps) {
	this.emps = emps;
}

}
