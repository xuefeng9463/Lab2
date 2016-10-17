package com.tutorialspoint.struts2;

import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection; //导入数据库连接对象
import java.sql.DriverManager; //导入数据库驱动管理对象
import java.sql.ResultSet; //导入数据记录集对象
import java.sql.SQLException; //导入数据SQL操作异常对象
import java.sql.Statement; //导入SQL操作接口对象 

public class List {
	private String c;
	private String a;
	private String d;
	public static String b;

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String search() throws Exception {
		int j = 0;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://xicnsmuobrnh.rds.sae.sina.com.cn:10661/xfdata?useUnicode=true&characterEncoding=utf-8";
		Connection conn1 = DriverManager.getConnection(url, "root", "199463");
		Statement stat1 = conn1.createStatement();
		Connection conn2 = DriverManager.getConnection(url, "root", "199463");
		Statement stat2 = conn2.createStatement();
		ResultSet rs;
		ResultSet as;
		rs = stat1.executeQuery("select * from book");
		as = stat2.executeQuery("select * from author");
		while (as.next()) {
			rs.next();

			if (a.equals(as.getString(2))) {
				b = rs.getString(2);
				this.c = "isbn:" + rs.getString(1)+"  " + "tible:" + rs.getString(2)+"  "+ "authorid:" + rs.getString(3)+"  "
						+ "publishdata:" + rs.getString(4)+"  "  + "price:" + rs.getString(5);
				break;
			} else {
				this.c = "Don't find!";
			}

		}
		stat1.close();
		conn1.close();
		stat2.close();
		conn2.close();
		return "success";
	}

	public String delete() throws Exception {
		int i = 1;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://xicnsmuobrnh.rds.sae.sina.com.cn:10661/xfdata?useUnicode=true&characterEncoding=utf-8";
		Connection conn1 = DriverManager.getConnection(url, "root", "199463");
		Statement stat1 = conn1.createStatement();
		Connection conn2 = DriverManager.getConnection(url, "root", "199463");
		Statement stat2 = conn2.createStatement();
		Connection conn3 = DriverManager.getConnection(url, "root", "199463");
		Statement stat3 = conn3.createStatement();
		ResultSet rs;
		ResultSet as;
		rs = stat1.executeQuery("select * from book");
		as = stat2.executeQuery("select * from author");
	
		while (rs.next()) {
			if (b.equals(rs.getString(2))) {
				stat3.executeUpdate("delete from book where authorID=0"+i);
				this.d = "Delete success!";
				
				break;
			}
			
			i++;
		}
		
		stat1.close();
		conn1.close();
		stat2.close();
		conn2.close();
		stat3.close();
		conn3.close();
		return "success";
	}

	

}
