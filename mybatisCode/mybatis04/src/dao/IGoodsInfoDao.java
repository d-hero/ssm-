package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.GoodsInfo;

public interface IGoodsInfoDao {
	//�����û������3������ʵ�ֲ�ѯ
	//��Ʒ����-ģ����ѯ
	//�۸�����-ֻҪ�û���������һ��������ʵ�ֲ�ѯ
	public List<GoodsInfo> search(@Param("gName") String gName,@Param("pMin") int pMin,@Param("pMax") int pMax);
	public int doUpdate(GoodsInfo goodsInfo);
	public List<GoodsInfo> searchByTypeId(@Param("typeArr") String[] typeArr);
}
