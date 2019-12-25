package com.utils;

import com.mode.NewsInfo;
import com.mode.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DButil {
	public static String user;
	private static String pass;
	private static String dir;
	private static String url;
	static Connection con=null;
	private static void getObject() throws Exception {
		DBlink db=DBlink.instance();
		user=db.getUser();
		pass=db.getPwd();
		dir=db.getDriver();
		url=db.getURL();
	}
	public static Connection getConnection() throws Exception {
		getObject();
		try {
			Class.forName(dir);
			con= DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}	
		return con;
	}
	public static Connection closeConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (Exception e) {
				 e.printStackTrace();
			}
		}
		return con;	
	}
	public static int SQLment(String sql,Object...prame) throws SQLException {//可变长任意类型参数
		int  rest=0;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			pst=con.prepareStatement(sql);//预处理SQL
			if(prame!=null && prame.length>0) {//判读参数是否为空
				for(int i=0;i<prame.length;i++) {//逐个获取参数加入SQL语句执行
					pst.setObject(i+1, prame[i]);
				}
				rest=pst.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection();
	return rest;
	}
	public static <T>List<T>search(String sql,Class<T>clazz,Object...params) throws Exception {
		Connection con=getConnection();
		ResultSet rs=null;
		List<T>list=new ArrayList<T>();;//用来存放泛型的数据；

		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			ParameterMetaData pmd=pstmt.getParameterMetaData();//得到了预编译语句对象的元数据;????等信息
			for(int i=0;i<pmd.getParameterCount();i++){
				pstmt.setObject(i+1,params[i]);
			}
			//到此为止，已经把值给了？下一步？？？继续结果集的操作;
			rs=pstmt.executeQuery();
			//得到结果集的元数据
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next()){
				//new出来一个T类型的对象;8列；4列；
				T obj=clazz.newInstance();
				//赋值的时候，元数据类型的列不固定，没问题；我们是不是已经得到了元数据，类的元数据;
				for(int i=0;i<rsmd.getColumnCount();i++){
					String colName=rsmd.getColumnName(i+1); //得到列名;
					Object value=rs.getObject(colName);		//得到了，该列对应的值；
					BeanUtils.setProperty(obj, colName, value);//封装数据到类对象obj;
				}

				list.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return list;
	}
	public static int getCount() throws Exception {
		con=DButil.getConnection();
		int count=0;
		String sql="select count(*) from newinfo";
		PreparedStatement ps=null;
		ResultSet rs=null;
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		if(rs.next()){
			count=rs.getInt(1);
		}
		closeConnection();
		return count;
	}
//	@Test
//	public void TS() throws Exception {
//		String sql ="select * from  news,newinfo where newinfo.title=news.title limit 0,7";
//		List<NewsInfo> s=DButil.search(sql,NewsInfo.class);
//		s.forEach(a-> System.out.println(a));
//	}
//	@Test
//	public void Pages() throws Exception {//int pageNU 当前页数
//		Page pg=new Page();
//		String sql="select * from  news,newinfo where newinfo.title=news.title limit ?,?";
//		pg.setPagesize(1);
//		Object[] prame={(2)*pg.getPagesize(),pg.getPagesize()};
//		List<NewsInfo> s=DButil.search(sql,NewsInfo.class,prame);
//		s.forEach(a-> System.out.println(a));
//		String nam="newinfo";
//		int a=getCount();
//		System.out.println(a);
//	}
}
