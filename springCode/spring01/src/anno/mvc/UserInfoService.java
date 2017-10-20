package anno.mvc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //<bean id="dao" class="xxx.UserInfoDao"> 
//<bean id="userInfoService" class="xxx.UserInfoService">
//<property name="xxx' ref="dao'>
public class UserInfoService {
	@Resource(name="mydao")
	//autowired == <property name="xxx' ref="userInfoDao'>
	private IUserInfoDao dao;
	public void show(){
		System.out.println(dao);
	}
}
