package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.UserInfo;

public interface IUserInfoDao {
	//���и���
	public int doUpdate(UserInfo userInfo);
}
