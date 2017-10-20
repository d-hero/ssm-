package dao;

import java.util.List;

import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.UserInfo;
@Repository
public class UserInfoDao {
	@Autowired
	private UserMapper uMapper;
	public  List<UserInfo> getAll(){
		return uMapper.getAll();
	}
}
