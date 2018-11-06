package com.neuedu.XiaoRyi.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
	/**
	 * ����Oracle���ݿ�
	 * */
	public static Connection getOracleConnection() {
		try {
			//1.��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.��������URL
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//3.��ȡ���ݿ�����
			return DriverManager.getConnection(url,"hr","123456");
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * ����Mysql���ݿ�
	 * */
	public static Connection getMysqlConnection() {
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������URL
			String url="jdbc:mysql://localhost/demo?useUnicode=true&characterEncoding=GBK";
			//3.��ȡ���ݿ�����
			return DriverManager.getConnection(url,"root","123456");
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}
	}
	/**
	 * �ر���Դ
	 * */
	public  static  void closAll(Connection conn,Statement st,ResultSet rs) {
		try {
			if(null!=rs) {
				rs.close();
			}
			if(null!=st) {
				st.close();
			}
			if(null!=conn) {
				conn.close();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

