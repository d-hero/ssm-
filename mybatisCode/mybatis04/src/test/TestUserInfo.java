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

	 @Test
	public void doUpdate(){
		 try{
			 UserInfo ui = new UserInfo();
			 ui.setId(4);
			 ui.setNickName("aaa");
			 IUserInfoDao dao = new UserInfoDao();
			 System.out.println(dao.doUpdate(ui));
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
		 
		}
}
