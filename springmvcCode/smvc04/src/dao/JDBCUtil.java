package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	private static final String driverName = "com.mysql.jdbc.Driver";//����
	private static final String url = "jdbc:mysql://127.0.0.1:3306/mydb";//url
	private static final String user = "root";//�û���
	private static final String password = "";//����
	private static Connection conn;
	private static PreparedStatement ppst;
	/**
	 * ����Ǹ������Ӷ���Ĵ���
	 */	
	private static void getConnection(){
		//��������
		try {
			Class.forName(driverName);			
			//��������
			conn = DriverManager.getConnection(url, user, password);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//����ppst����,��Ҫ���Ӷ���+sql���
	private static void getPreparedStatement(String sql,Object...params){
		//����֮ǰ�Ȱ����Ӷ��󴴽�
		getConnection();
		ppst = null;
		try {
			ppst = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ppst.setObject(i+1, params[i]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//������ɾ��
	public static int executeUpdate(String sql,Object...params){
		//�õ�ppst,����ִ��ppst��executeUpdate����
		getPreparedStatement(sql, params);
		int i=-1;//�����������ִ�к�Ľ��
		try {
			i= ppst.executeUpdate();//ִ�гɹ���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			i= 0;
		}finally{
			closeDB(null);
		}
		return i;
	}
	//�����ѯ
	public static ResultSet getResultSet(String sql,Object...params){
		getPreparedStatement(sql, params);
		ResultSet rs=null;
		try {
			rs = ppst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//�������ر�
	public static void closeDB(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ppst!=null){
			try {
				ppst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
