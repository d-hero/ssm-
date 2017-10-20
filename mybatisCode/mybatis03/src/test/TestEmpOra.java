package test;

import java.util.List;

import dao.*;
import entity.EmpInfo;
import entity.EmpOra;

public class TestEmpOra {
	public static void main(String[] args) {
		IEmpOraDao dao =new EmpOraDao();
		List<EmpOra> list = dao.getAll();
		for(EmpOra e:list){
			System.out.println(e.geteName()+":"+e.getManager().geteName());
		}
	}
}
