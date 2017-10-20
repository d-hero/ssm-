package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.IMyFileDao;
import entity.MyFile;

public class TestMyFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//得到创建sqlsession的工厂类
		//sqlSession相当于connection的作用
		SqlSessionFactory sqlSessionFactory = null;
		Reader reader;//用来加载基础配置文件
		String file="mybatis.config.xml";
		//开始加载文件
		try {
			reader = Resources.getResourceAsReader(file);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建sqlsession
		SqlSession session = sqlSessionFactory.openSession();
		//利用sqlsession生成实体dao
		IMyFileDao dao = session.getMapper(IMyFileDao.class);
		//调用方法
		List<MyFile> list =dao.select();
		for(MyFile f:list){
			System.out.println(f.getBcwjm());
		}
		//关闭
		session.close();
	}

}
