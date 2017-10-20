package entity;

public class EmpOra {
	private int empNo;
	private String eName;
	//…œº∂
	private EmpOra manager;
	@Override
	public String toString() {
		return "EmpOra [empNo=" + empNo + ", eName=" + eName + ", manager="
				+ manager + "]";
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public EmpOra getManager() {
		return manager;
	}
	public void setManager(EmpOra manager) {
		this.manager = manager;
	}
}
