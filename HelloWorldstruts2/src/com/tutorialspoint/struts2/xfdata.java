package com.tutorialspoint.struts2;
import java.awt.print.Book;
import java.sql.*;
import java.sql.Connection;     //�������ݿ����Ӷ���
import java.sql.DriverManager;  //�������ݿ������������
import java.sql.ResultSet;      //�������ݼ�¼������
import java.sql.SQLException;   //��������SQL�����쳣����
import java.sql.Statement;      //����SQL�����ӿڶ���
  
import java.sql.DatabaseMetaData;  
import java.sql.Driver;  
 

import java.util.Enumeration;  
import java.util.Vector;  
public class xfdata { 

	public static  void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
         
       
        String url = "jdbc:mysql://localhost:3306/xfdata?useUnicode=true&characterEncoding=utf-8";  
        Connection conn = DriverManager.getConnection(url, "root", "199463");
        Statement stat = conn.createStatement();
        ResultSet rs;
        
        stat.executeUpdate("drop table if exists book");
        stat.executeUpdate("drop table if exists author");
        
        
        stat.executeUpdate("create table book(isbn char(20), title char(20),authorID char(3),publishdate char(20),price char(15))");
        stat.executeUpdate("create table author(authoriD char(3),name char(10),age char(3),country char(20))") ;
        
      
        stat.executeUpdate("insert into book values('10003', '���μ�','03','2016-1-3','30yuan')");
        
        stat.executeUpdate("insert into author values('01', '�߶���','100','����')");
         
      
       
        stat.close();
        conn.close();
    }
	}
