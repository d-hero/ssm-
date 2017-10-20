package DIObject;

public class UserController {
	private UserInfoDao dao;

	public UserInfoDao getDao() {
		return dao;
	}

	public void setDao(UserInfoDao dao) {
		this.dao = dao;
	}
	/**
	 * 这里处理用户的新增
	 */
	public void add(){
		//在控制器里面调用dao的新增
		//这里得到需要的数据以后，调用dao处理用户的新增
		dao.add();
	}
}
