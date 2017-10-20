package controller;

import java.util.List;

import mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

import entity.UserInfo;

public class UserController {
	@Autowired
	private IUserInfoDao dao;
	public void getAll(){
		List<UserInfo> list = d.getAll();
	}
}
