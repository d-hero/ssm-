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
	//����Ҫ�д������ӵķ���
	public static void getConn(){
		//��������
		try {
			Class.forName(driverName);
			//��������			
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//����PreparedStatement,��Ҫconn��Ҫsql
	public static PreparedStatement getPPST(String sql,Object...params){
		//���������		
		PreparedStatement ppst = null;
		try {
			getConn();//һ��һ��Ҫ�������
			ppst = conn.prepareStatement(sql);
			//Ϊsql��������?��ֵ
			//����forѭ��ʵ�ֱ���
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
	//������ɾ��
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
	//��ѯ
	public static ResultSet getResultSet(String sql,Object...params){
		//�ڴӽ������ȡ�����֮ǰ���ǲ����Թر�������Դ��
		ResultSet rs = null;
		ppst = getPPST(sql,params);//�õ�ppst
		try {
			rs = ppst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/***
	 * ʵ����Դ�Ĺر�
	 * @param rs���������󣬶�����Ҫֱ�ӷ��ʵ��ã�ֱ�ӿ�������Ϊprivate����
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
	//��ü�¼��
	/***
	 * 
	 * @param sql �Ǳ�׼��count(*) ���
	 * @param params ��ѯ����
	 * @return ���ص���ĳ��������ļ�¼��
	 */
	public static int getRecCount(String sql,Object...params){
		int recNum = 0;
		ResultSet rs = getResultSet(sql,params);//��������ĵõ�������ķ���
		try {
			if(rs.next()){
				recNum = rs.getInt(1);//�����ͼ�¼��������ֻ��һ�У��������ͻ���int
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
	 * ��resultsetת���ɶ�ά����
	 * @param sql
	 * @param paramsh where ���������
	 * @return
	 */
	public static Object[][] getQueryResult(String sql, Object... params) {
		
		ResultSet rs = null;
		try {
			//
			rs = getResultSet(sql, params);
			ResultSetMetaData meta = rs.getMetaData(); // ���Ԫ����
			int m_Cols = meta.getColumnCount(); // ��ò�ѯ����������
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
	//��ResultSet�Ľ������װ����������
	public  <T> List<T> getQuery(Object objClass, String sql, Object... params) {			 
				Class c = objClass.getClass();
				List<Object> list=new ArrayList();			 
				ResultSet rs =null;			
				try {
					rs=this.getResultSet(sql, params);
					ResultSetMetaData metaData  = rs.getMetaData();  
			        int cols_len = metaData.getColumnCount(); 
			        
					//���Ԫ����,�����Ԫ���ݲ�ѯ���sql����������Ӧ������
					ResultSetMetaData rsmd = rs.getMetaData(); 
					//��ò�ѯ����������
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
			                field.setAccessible(true); //��javabean�ķ���Ȩ��  
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
	     * ��װset���� 
	     * @param columnName �ֶ��� 
	     * @return 
	     */  
	    private static String getSetMethodName(String columnName) {  
	        return "set" + columnName.substring(0, 1).toUpperCase()  
	        + columnName.toLowerCase().substring(1);  
	    } 
	    /***
	     * ʵ��ͨ�ð汾����������
	     * �÷���ʹ��ע�����Ĭ�ϵ�Լ�������������һ�£������Ǵ�Сд����
	     * ������������һ�£�������Ĭ������Ϊid
	     * Ŀǰ�������������ṹ��ȫһ�µ����
	     * @param obj��������Ҫ���浽���ݿ�Ķ���
	     * @return >0��ʾ�����ɹ���<=0��ʾû�������ɹ�
	     * 
	     */
	    public static int doAdd(Object obj){
	    	int i=0;
	    	//�ؼ�����sql���Ĺ���
	    	//����Ĺؼ���1����2����3ֵ
	    	Class clazz = obj.getClass();
	    	//�õ�����
	    	String tbName = clazz.getSimpleName();
	    	String sql =" insert into "+tbName+"(";
	    	String colStr="";//��������
	    	String valStr = "";//����ֵ
	    	//�����������õ�����������Ҫ�õ�������
	    	Field[] fields = clazz.getDeclaredFields();
	    	Object[] objArr  =new Object[fields.length-1];
	    	//z����һ����������ָʾ�����±�
	    	int arrNum = 0;
	    	try{
	    		for(Field f:fields){
		    		String colName =f.getName(); //;����ֶα�������
		    		if("id".equals(colName.toLowerCase())==false){
		    			colStr += colName +",";//��������
		    			valStr +="?,";//���ﹹ��ֵ
		    			//�õ���Ӧ��ֵ
		    			PropertyDescriptor pd = new PropertyDescriptor(f.getName(),clazz);
						//����pd����õ�get����
						Method getMd= pd.getReadMethod();
						objArr[arrNum]=getMd.invoke(obj);
						arrNum++;
		    		}		
		    	}
	    		//������ϣ������sql
	    		colStr = colStr.substring(0,colStr.length()-1);
	    		valStr = valStr.substring(0,valStr.length()-1);
	    		sql += colStr +")";
	    		sql += " values("+valStr+")";
	    		System.out.println(sql);
	    		//ֱ�ӵ���ǰ��ķ���
	    		i = DBUtil.executeUpdate(sql, objArr);
	    		System.out.println(i);
	    	}catch(Exception ex){
	    		
	    	}
	    	//ͨ��������sql������������������������==id,���������
	    	
	    	return i;
	    }
	    
}
