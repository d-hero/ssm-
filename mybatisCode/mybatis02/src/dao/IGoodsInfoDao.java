package dao;

import java.util.List;

import entity.GoodsInfo;

public interface IGoodsInfoDao {
	public List<GoodsInfo> search(String str,int pageSize,int pageNum);
	//��Ʒ������
	public void add(GoodsInfo goodsInfo);
	//�����ɹ��󷵻ص���������idֵ
	public int addGoods(GoodsInfo goodsInfo);
}
