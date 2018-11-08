package com.zkq.jdbcutils;

import lombok.extern.log4j.Log4j;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@Log4j
public class ConnectionDb{
	private static String url=null;
	private static String user=null;
	private static  String password=null;
	private static  String driver=null;
	public static  Connection conn=null;
	private static PreparedStatement ps= null;
	  static{
		  Properties p = new Properties();  
		try {
			p.load(ConnectionDb.class.getResourceAsStream("/mysql.properties"));
		} catch (IOException e) {
		log.error("jdbc.properties file not found ,exception is"+e.getMessage());
		}
		url=p.getProperty("jdbc.url");
		user=p.getProperty("jdbc.username");
		password=p.getProperty("jdbc.password");
		driver="com.mysql.jdbc.Driver";
		 	try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
		log.error("class file not found ,exception is"+e.getMessage());
			}
	  } 
		
	public  static  Connection getconnection(){
		try{
		conn = DriverManager.getConnection(url,user,password);
		log.debug("database connection success!");
		}
		catch(Exception e){
			log.error("database connection false ,exception is"+e.getMessage());
		}
		return conn;
	}

public static <T> T query(String sql,ResultSetHandler<T> rsh,Object...param){
	    T t=null;
		try(Connection con=ConnectionDb.getconnection();){
			 ps=conn.prepareStatement(sql);
			ParameterMetaData psd=ps.getParameterMetaData();
			if(param!=null&&param.length!=0&&psd.getParameterCount()==param.length){
				for(int i=0;i<param.length;i++){
					ps.setObject(i+1, param[i]);
				}
			}
			ResultSet rs=ps.executeQuery();
			     t=rsh.handler(rs);
}catch(SQLException e){
	log.debug("select false,exception is"+e.getMessage());
}
	return t;
	
}
public static int queryForCount(String sql,Object...param){
	int count=0;
	try(Connection con=ConnectionDb.getconnection();){
		 ps=conn.prepareStatement(sql);
		ParameterMetaData psd=ps.getParameterMetaData();
		if(param!=null&&param.length!=0&&psd.getParameterCount()==param.length){
			for(int i=0;i<param.length;i++){
				ps.setObject(i+1, param[i]);
			}
		}
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}
}catch(SQLException e){
log.debug("select false,exception is"+e.getMessage());
}
	return count;
}
public static  int excueupddate(String sql,Object...param){
	int affectRow=0;
	try( Connection conn=ConnectionDb.getconnection();){
		ps =conn.prepareStatement(sql);
		ParameterMetaData psd=ps.getParameterMetaData();
		if(param!=null&&param.length!=0&&psd.getParameterCount()==param.length){
			for(int i=0;i<param.length;i++){
				ps.setObject(i+1, param[i]);
			}
		}
		affectRow=ps.executeUpdate();
		 if(conn!=null){
			 conn.close();
		 }
		 if(ps!=null){
			 ps.close();
		 }
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return affectRow;
}
public static  void closeconnection(Connection con){
	if(con!=null){
		try{
			con.close();
		}catch(SQLException e){
		log.error("close false ,exception is"+e.getMessage());
		}
	}
	
}


	
}
	

