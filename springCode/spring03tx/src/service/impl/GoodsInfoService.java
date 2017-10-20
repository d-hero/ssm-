package service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.IGoodsInfoDao;

import entity.GoodsInfo;
import service.inter.IGoodsInfoService;
@Service
public class GoodsInfoService implements IGoodsInfoService {
	@Autowired
	private IGoodsInfoDao gDao;
	@Override
	public List<GoodsInfo> select() {
		// TODO Auto-generated method stub
		return gDao.select();
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)//这个就代表使用了事务，==在sql语句最前面加上beginTransaction,最后加上commit
	public int add(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		GoodsInfo g1 =new GoodsInfo();
		g1.setgName("aaaa"+new Date().getTime());
		g1.setPrice(30);
		//gDao.add(g1);//这里已经产生了一个事务
		GoodsInfo g2 =new GoodsInfo();
		g2.setgName("随便输入一些随便输入一些随便输入一些随便输入一些随便输入一些随便输入一些");
		g2.setPrice(50);
		try{
			
			gDao.add(g1);
			gDao.add(g2);
		}catch(Exception ex){
			System.out.println("出错了"+new Date());
		}
		 //正常又会产生一个事务，但是在propagation=required,
		//这个时候自动就会加入前面的事务，也就是2个sql语句都处于同一个事务中
		//我们可以通过给propagation这个属性赋值，改变事务产生的方式。
		return 1;
	}
	@Transactional
   public void add2(GoodsInfo goodsInfo){
		GoodsInfo g1 =new GoodsInfo();		
		g1.setgName("随便输入一些随便输入一些随便输入一些随便输入一些随便输入一些随便输入一些");
		g1.setPrice(30);
		try{
			gDao.add(g1);//这里已经产生了一个事务	
		}catch(Exception ex){
			System.out.println("这里失败了");
		}		
		g1 =new GoodsInfo();
		g1.setgName("1qweee22222");
		g1.setPrice(50);
		gDao.add(g1); 
   }
}
