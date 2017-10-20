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
		//����ɶ���������
		oDao.add();
		//��ϸ��Ĵ���
		odDao.add();
	}
}
