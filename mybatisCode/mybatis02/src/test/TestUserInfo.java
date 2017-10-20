package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import dao.IUserInfoDao;
import dao.UserInfoDao;
import dao.util.MybatisUtil;
import entity.UserInfo;



public class TestUserInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		//这里类似springmvc的调用
		UserInfo ui =new UserInfo();
		ui.setuName("aa");
		ui.setPwd("bb");
		//实例化出dao
		IUserInfoDao dao = new UserInfoDao();
		ui = dao.doLogin(ui);
		System.out.println(ui.getNickName());
	}
	@Test
	public void getNum(){
		//实例化出dao
		IUserInfoDao dao = new UserInfoDao();
		System.out.println(dao.getUserCount());
	}
	@Test
	public void doLogin02(){
		IUserInfoDao dao = new UserInfoDao();
		UserInfo ui = dao.doLogin02("aa", "bb", 1);
		System.out.println(ui.getNickName());
	}
	@Test
	public void byPage(){
		IUserInfoDao dao = new UserInfoDao();
		int m=(2-1)*5;
		int n=5;
		List<UserInfo> list =dao.getByPage(m,n);
		System.out.println(list.get(list.size()-1).getId());
	}
}
