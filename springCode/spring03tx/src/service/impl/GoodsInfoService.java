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
	@Transactional(propagation=Propagation.REQUIRED)//����ʹ���ʹ��������==��sql�����ǰ�����beginTransaction,������commit
	public int add(GoodsInfo goodsInfo) {
		// TODO Auto-generated method stub
		GoodsInfo g1 =new GoodsInfo();
		g1.setgName("aaaa"+new Date().getTime());
		g1.setPrice(30);
		//gDao.add(g1);//�����Ѿ�������һ������
		GoodsInfo g2 =new GoodsInfo();
		g2.setgName("�������һЩ�������һЩ�������һЩ�������һЩ�������һЩ�������һЩ");
		g2.setPrice(50);
		try{
			
			gDao.add(g1);
			gDao.add(g2);
		}catch(Exception ex){
			System.out.println("������"+new Date());
		}
		 //�����ֻ����һ�����񣬵�����propagation=required,
		//���ʱ���Զ��ͻ����ǰ�������Ҳ����2��sql��䶼����ͬһ��������
		//���ǿ���ͨ����propagation������Ը�ֵ���ı���������ķ�ʽ��
		return 1;
	}
	@Transactional
   public void add2(GoodsInfo goodsInfo){
		GoodsInfo g1 =new GoodsInfo();		
		g1.setgName("�������һЩ�������һЩ�������һЩ�������һЩ�������һЩ�������һЩ");
		g1.setPrice(30);
		try{
			gDao.add(g1);//�����Ѿ�������һ������	
		}catch(Exception ex){
			System.out.println("����ʧ����");
		}		
		g1 =new GoodsInfo();
		g1.setgName("1qweee22222");
		g1.setPrice(50);
		gDao.add(g1); 
   }
}
