package test;

import java.util.List;

import dao.*;
 
import entity.EmpInfo;
import entity.GoodsInfo;

public class TestEmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IEmInfoDao dao =new EmpInfoDao();
		List<EmpInfo> list = dao.getAll();
		for(EmpInfo e:list){
			System.out.println(e.geteName()+":"+e.getDeptInfo().getDeptName());
		}
	}

}
