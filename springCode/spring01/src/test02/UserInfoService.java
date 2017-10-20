package test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
	@Autowired
	private IUserInfoDao userInfoDao;

	public void show(){
		System.out.println(userInfoDao);
	}
	public void getUserInfoOrcDao(){
		//System.out.println(userInfoOrcDao);
	}
	
}
