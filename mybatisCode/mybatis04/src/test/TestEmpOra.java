package test;

import java.util.List;

import dao.*;

import entity.EmpOraInfo;

public class TestEmpOra {
	public static void main(String[] args) {
		IEmpOraDao dao =new EmpOraDao();
		List<EmpOraInfo> list = dao.getByDepts(new String[]{"10","30"});
		for(EmpOraInfo e:list){
			System.out.println(e.geteName());
		}
	}
}
