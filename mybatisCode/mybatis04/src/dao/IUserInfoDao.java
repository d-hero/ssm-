package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.UserInfo;

public interface IUserInfoDao {
	//进行更新
	public int doUpdate(UserInfo userInfo);
}
