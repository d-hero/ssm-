package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import entity.EmpOraInfo;

public interface IEmpOraDao {
	public List<EmpOraInfo> getByDepts(@Param("depts") String[] depts);
}
