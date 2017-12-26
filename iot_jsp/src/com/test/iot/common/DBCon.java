package com.test.iot.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class DBCon {
    private static Connection conn;
    public static Connection getCon() {
    	if(DBCon.conn==null) {
    		Context initContext;
    		try {
    		initContext = new InitialContext();
    		Context envContext = (Context)initContext.lookup("java:/comp/env");
    		DataSource ds = (DataSource)envContext.lookup("jdbc/IOT");
    		DBCon.conn =  ds.getConnection();
    		System.out.println("컨넥션연결성공");
    		}catch(NamingException | SQLException e) {
    			System.out.println("컨넥션연결실패");
    			e.printStackTrace();
    		}
    	}
    	System.out.println(conn);
    	return DBCon.conn;
    }
    public static void closeCon() {
    	if(DBCon.conn!=null) {
    		try {
				conn.close();
				System.out.println("컨넥션 연결해제 성공");
			} catch (SQLException e) {
				System.out.println("컨넥션 연결해제 실패");
				e.printStackTrace();
			}
    	}
    	
    }
}
