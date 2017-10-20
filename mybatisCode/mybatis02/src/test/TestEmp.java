package test;

import dao.EmpInfoDao;
import dao.IEmpInfoDao;
import entity.EmpInfo;

public class TestEmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IEmpInfoDao dao =new EmpInfoDao();
		EmpInfo e=new EmpInfo();
		e.seteName("ttt");
		dao.add(e);
		System.out.println("新增成功");
	}

}
