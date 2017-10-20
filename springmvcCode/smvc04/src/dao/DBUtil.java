package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "";
	private static Connection conn =null;
	private static PreparedStatement ppst = null;
	//首先要有创建连接的方法
	public static void getConn(){
		//加载驱动
		try {
			Class.forName(driverName);
			//进行连接			
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//创建PreparedStatement,需要conn需要sql
	public static PreparedStatement getPPST(String sql,Object...params){
		//先完成连接		
		PreparedStatement ppst = null;
		try {
			getConn();//一定一定要完成连接
			ppst = conn.prepareStatement(sql);
			//为sql语句里面的?赋值
			//利用for循环实现遍历
			for(int i=0;i<params.length;i++){
				ppst.setObject(i+1, params[i]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();			
		}
		return ppst;
	}
	//处理增删改
	public static int executeUpdate(String sql,Object...params){
		
		int i=-1;
		try {
			ppst = getPPST(sql,params);
			i =  ppst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB(null);
		}
		return i;
	}
	//查询
	public static ResultSet getResultSet(String sql,Object...params){
		//在从结果集中取出结果之前，是不可以关闭所有资源的
		ResultSet rs = null;
		ppst = getPPST(sql,params);//得到ppst
		try {
			rs = ppst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/***
	 * 实现资源的关闭
	 * @param rs，其他对象，都不需要直接访问调用，直接可以设置为private属性
	 */
	public static void closeDB(ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(ppst!=null)
				ppst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获得记录数
	/***
	 * 
	 * @param sql 是标准的count(*) 表达
	 * @param params 查询条件
	 * @return 返回的是某个结果集的记录数
	 */
	public static int getRecCount(String sql,Object...params){
		int recNum = 0;
		ResultSet rs = getResultSet(sql,params);//调用上面的得到结果集的方法
		try {
			if(rs.next()){
				recNum = rs.getInt(1);//正常就记录数，就是只有一列，而且类型还是int
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(rs);
		}
		return recNum;
	}
	/**
	 * 将resultset转换成二维数组
	 * @param sql
	 * @param paramsh where 后面的条件
	 * @return
	 */
	public static Object[][] getQueryResult(String sql, Object... params) {
		
		ResultSet rs = null;
		try {
			//
			rs = getResultSet(sql, params);
			ResultSetMetaData meta = rs.getMetaData(); // 获得元数据
			int m_Cols = meta.getColumnCount(); // 获得查询的列数个数
			int m_Rows = 0;
			Object obj;
			ArrayList list = new ArrayList();
			while (rs.next()) {
				m_Rows++;
				for (int i = 1; i <= m_Cols; i++) {
					obj = rs.getObject(i);
					list.add(obj);
				}

			}
			if (m_Rows == 0)
				return null;
			Object[] objAll = list.toArray();
			Object[][] objColRow = new Object[m_Rows][m_Cols];
			for (int iRow = 0; iRow < m_Rows; iRow++) {
				for (int iCol = 0; iCol < m_Cols; iCol++) {
					objColRow[iRow][iCol] = objAll[iRow * m_Cols + iCol];
				}
			}
			return objColRow;
		} catch (Exception ex) {
			return null;
		} finally {
			try {
				closeDB(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//将ResultSet的结果集封装到集合里面
	public  <T> List<T> getQuery(Object objClass, String sql, Object... params) {			 
				Class c = objClass.getClass();
				List<Object> list=new ArrayList();			 
				ResultSet rs =null;			
				try {
					rs=this.getResultSet(sql, params);
					ResultSetMetaData metaData  = rs.getMetaData();  
			        int cols_len = metaData.getColumnCount(); 
			        
					//获得元数据,这里的元数据查询后的sql结果集里面对应的列名
					ResultSetMetaData rsmd = rs.getMetaData(); 
					//获得查询的列数个数
		            int columnCount = rsmd.getColumnCount(); 
					while(rs.next()){
						objClass = c.newInstance();
						for(int i = 0; i<cols_len; i++){  
			                String cols_name = metaData.getColumnName(i+1);  
			                Object cols_value = rs.getObject(cols_name);  
			                if(cols_value == null){  
			                    cols_value = "";  
			                }  
			                Field field = c.getDeclaredField(cols_name);  
			                field.setAccessible(true); //打开javabean的访问权限  
			                field.set(objClass, cols_value);  
			            }  
						
		                list.add(objClass);	                 
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}finally{
					this.closeDB(rs);
				}
				return (List<T>) list;
			}
		/** 
	     * 组装set方法 
	     * @param columnName 字段名 
	     * @return 
	     */  
	    private static String getSetMethodName(String columnName) {  
	        return "set" + columnName.substring(0, 1).toUpperCase()  
	        + columnName.toLowerCase().substring(1);  
	    } 
	    /***
	     * 实现通用版本的新增处理
	     * 该方法使用注意事项：默认的约定：类名与表名一致，最多就是大小写区别，
	     * 属性名与列名一致，自增列默认名称为id
	     * 目前仅适用于类与表结构完全一致的情况
	     * @param obj——就是要保存到数据库的对象
	     * @return >0表示新增成功，<=0表示没有新增成功
	     * 
	     */
	    public static int doAdd(Object obj){
	    	int i=0;
	    	//关键点是sql语句的构造
	    	//构造的关键点1表名2列名3值
	    	Class clazz = obj.getClass();
	    	//得到表名
	    	String tbName = clazz.getSimpleName();
	    	String sql =" insert into "+tbName+"(";
	    	String colStr="";//保存列名
	    	String valStr = "";//保存值
	    	//接下来遍历得到列名，就先要得到属性名
	    	Field[] fields = clazz.getDeclaredFields();
	    	Object[] objArr  =new Object[fields.length-1];
	    	//z增加一个变量用来指示数组下标
	    	int arrNum = 0;
	    	try{
	    		for(Field f:fields){
		    		String colName =f.getName(); //;这个字段保存列名
		    		if("id".equals(colName.toLowerCase())==false){
		    			colStr += colName +",";//构造列名
		    			valStr +="?,";//这里构造值
		    			//得到对应的值
		    			PropertyDescriptor pd = new PropertyDescriptor(f.getName(),clazz);
						//利用pd对象得到get对象
						Method getMd= pd.getReadMethod();
						objArr[arrNum]=getMd.invoke(obj);
						arrNum++;
		    		}		
		    	}
	    		//遍历完毕，构造出sql
	    		colStr = colStr.substring(0,colStr.length()-1);
	    		valStr = valStr.substring(0,valStr.length()-1);
	    		sql += colStr +")";
	    		sql += " values("+valStr+")";
	    		System.out.println(sql);
	    		//直接调用前面的方法
	    		i = DBUtil.executeUpdate(sql, objArr);
	    		System.out.println(i);
	    	}catch(Exception ex){
	    		
	    	}
	    	//通过遍历向sql里面添加列名，而且如果列名==id,不进行添加
	    	
	    	return i;
	    }
	    
}
