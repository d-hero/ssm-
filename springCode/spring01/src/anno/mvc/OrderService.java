package anno.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private OrderDao oDao;
	@Autowired
	private OrderDetailDao odDao;
	public void addOrder(){
		//先完成订单表的添加
		oDao.add();
		//明细表的处理
		odDao.add();
	}
}
