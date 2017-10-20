package DIObject.MVC;

public class GoodsInfoService {
	private GoodsInfoDao dao;

	public GoodsInfoDao getDao() {
		return dao;
	}

	public void setDao(GoodsInfoDao dao) {
		this.dao = dao;
	}
	public void list(){
		System.out.println("这里是业务逻辑层通过调用dao来得到查询的数据");
		dao.list();
	}
}
