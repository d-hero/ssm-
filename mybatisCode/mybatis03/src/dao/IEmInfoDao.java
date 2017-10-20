package dao;

import java.util.List;

import entity.*;

public interface IEmInfoDao {
	//查询出所有的员工信息，姓名，部门名称
		public List<EmpInfo> getAll();
}
