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
		//�õ�����sqlsession�Ĺ�����
		//sqlSession�൱��connection������
		SqlSessionFactory sqlSessionFactory = null;
		Reader reader;//�������ػ��������ļ�
		String file="mybatis.config.xml";
		//��ʼ�����ļ�
		try {
			reader = Resources.getResourceAsReader(file);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����sqlsession
		SqlSession session = sqlSessionFactory.openSession();
		//����sqlsession����ʵ��dao
		IMyFileDao dao = session.getMapper(IMyFileDao.class);
		//���÷���
		List<MyFile> list =dao.select();
		for(MyFile f:list){
			System.out.println(f.getBcwjm());
		}
		//�ر�
		session.close();
	}

}
