package dao;

import hw0907.dao.DBUtil;

import java.util.List;

import entity.MyFile;

public class MyFileDao {
	//读取文件表里面的数据，然后让大家下载
	public List<MyFile> select(){
		DBUtil util =new DBUtil();
		String sql = "select * from myfile";
		 List<MyFile> list = util.getQuery(new MyFile(), sql);
		 return list;
	}
	//标准的下载套路；给id以后查到对应的数据里面的记录，然后在控制器里面读取文件名，通过文件流下载
	public MyFile getById(int id){
		DBUtil util =new DBUtil();
		String sql = "select * from myfile where id=?";
		 List<MyFile> list = util.getQuery(new MyFile(), sql,id);
		 return list.get(0);
	}
}
