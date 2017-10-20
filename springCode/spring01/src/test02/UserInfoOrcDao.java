package test02;

import org.springframework.stereotype.Repository;

@Repository
public class UserInfoOrcDao implements IUserInfoDao {

	public UserInfoOrcDao() {
		super();
		System.out.println(this);
	}
	
}
