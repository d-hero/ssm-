package dao.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	//sqlsessionfactory一个项目只允许有一个这样的对象
	private static SqlSessionFactory sqlSessionFactory = null;
	private static Reader reader;
	//利用静态代码块，项目运行的时候，就生成相应的对象
	static{
		String file = "config/mybatis.config.xml";
		// 开始加载文件
		try {
			reader = Resources.getResourceAsReader(file);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//sqlsession==connection，使用的时候open， 使用结束close
	public static SqlSession getSession(){
		return sqlSessionFactory.openSession();
	}
	
}
