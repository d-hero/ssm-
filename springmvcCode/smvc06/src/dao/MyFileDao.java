package dao;

import hw0907.dao.DBUtil;

import java.util.List;

import entity.MyFile;

public class MyFileDao {
	//��ȡ�ļ�����������ݣ�Ȼ���ô������
	public List<MyFile> select(){
		DBUtil util =new DBUtil();
		String sql = "select * from myfile";
		 List<MyFile> list = util.getQuery(new MyFile(), sql);
		 return list;
	}
	//��׼��������·����id�Ժ�鵽��Ӧ����������ļ�¼��Ȼ���ڿ����������ȡ�ļ�����ͨ���ļ�������
	public MyFile getById(int id){
		DBUtil util =new DBUtil();
		String sql = "select * from myfile where id=?";
		 List<MyFile> list = util.getQuery(new MyFile(), sql,id);
		 return list.get(0);
	}
}
