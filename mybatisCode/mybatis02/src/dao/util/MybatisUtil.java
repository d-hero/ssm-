package dao.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	//sqlsessionfactoryһ����Ŀֻ������һ�������Ķ���
	private static SqlSessionFactory sqlSessionFactory = null;
	private static Reader reader;
	//���þ�̬����飬��Ŀ���е�ʱ�򣬾�������Ӧ�Ķ���
	static{
		String file = "config/mybatis.config.xml";
		// ��ʼ�����ļ�
		try {
			reader = Resources.getResourceAsReader(file);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//sqlsession==connection��ʹ�õ�ʱ��open�� ʹ�ý���close
	public static SqlSession getSession(){
		return sqlSessionFactory.openSession();
	}
	
}
