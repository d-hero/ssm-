package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	private static final String driverName = "com.mysql.jdbc.Driver";//驱动
	private static final String url = "jdbc:mysql://127.0.0.1:3306/mydb";//url
	private static final String user = "root";//用户名
	private static final String password = "";//密码
	private static Connection conn;
	private static PreparedStatement ppst;
	/**
	 * 这个是负责连接对象的创建
	 */	
	private static void getConnection(){
		//加载驱动
		try {
			Class.forName(driverName);			
			//创建连接
			conn = DriverManager.getConnection(url, user, password);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//创建ppst对象,需要连接对象+sql语句
	private static void getPreparedStatement(String sql,Object...params){
		//创建之前先把连接对象创建
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
	
	//处理增删改
	public static int executeUpdate(String sql,Object...params){
		//得到ppst,并且执行ppst的executeUpdate方法
		getPreparedStatement(sql, params);
		int i=-1;//这个用来接收执行后的结果
		try {
			i= ppst.executeUpdate();//执行成功的
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			i= 0;
		}finally{
			closeDB(null);
		}
		return i;
	}
	//处理查询
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
	//这个处理关闭
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
