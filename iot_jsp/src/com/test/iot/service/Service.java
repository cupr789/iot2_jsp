package com.test.iot.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.test.iot.common.DBCon;



public class Service {
	DBCon dbcon;

	Service() {
		dbcon = new DBCon();
	}

	public int updateClassInfo(LinkedHashMap<String, Object> hm) {
		int result = 0;
		String sql = "update class_info set cidesc=? where cino=?";
		try {
			result = dbcon.executeUpdate(sql, hm);
			dbcon.commit();
		} catch (SQLException e) {
			try {
				dbcon.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} finally {

			try {
				dbcon.closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	
	public int updateUserInfo(LinkedHashMap<String, Object> hm) {
		int result = 0;
		String sql = "update user_info set uiname=? where uino=?";
		try {
			result = dbcon.executeUpdate(sql, hm);
			dbcon.commit();
		} catch (SQLException e) {
			try {
				dbcon.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} finally {

			try {
				dbcon.closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	
	
	public int insertUserInfo(LinkedHashMap<String, Object> hm) {
		ArrayList<HashMap<String, Object>> resultList = null;
		int result = 0;
		String sql = "insert into user_info(uiname,uiage,uiid,uipwd,cino,address) values(?,?,?,?,?,?)";
		try {
			// resultList = dbcon.executeQuery(sql, hm);
			result = dbcon.executeUpdate(sql, hm);
			dbcon.commit();
		} catch (SQLException e) {
			try {
				dbcon.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} finally {

			try {
				dbcon.closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	

	
	public int insertClassInfo(LinkedHashMap<String, Object> hm) {
		ArrayList<HashMap<String, Object>> resultList = null;
		int result = 0;
		String sql = "insert into class_info(ciname,cidesc) values(?,?)";
		try {
			// resultList = dbcon.executeQuery(sql, hm);
			result = dbcon.executeUpdate(sql, hm);
			dbcon.commit();
		} catch (SQLException e) {
			try {
				dbcon.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} finally {

			try {
				dbcon.closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int deleteClassInfo(LinkedHashMap<String, Object> hm) {
		int result = 0;
		String sql = "delete from class_info where cino = ?";
		try {
			result = dbcon.executeUpdate(sql, hm);
			dbcon.commit();
		} catch (SQLException e) {
			try {
				dbcon.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} finally {

			try {
				dbcon.closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	
	public int deleteUserInfo(LinkedHashMap<String, Object> hm) {
		int result = 0;
		String sql = "delete from user_info where uino = ?";
		try {
			result = dbcon.executeUpdate(sql, hm);
			dbcon.commit();
		} catch (SQLException e) {
			try {
				dbcon.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} finally {

			try {
				dbcon.closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public ArrayList<HashMap<String, Object>> selectUserInfo(LinkedHashMap<String, Object> hm) {
		String sql=null;
		ArrayList<HashMap<String, Object>> resultList = null;
			sql = "select * from user_info";
		

		try {
			resultList = dbcon.executeQuery(sql, hm);
			dbcon.commit();
		} catch (SQLException e) {
			try {
				dbcon.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} finally {

			try {
				dbcon.closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultList;
	}

	
	
	
	
	
	public ArrayList<HashMap<String, Object>> selectClassInfo(LinkedHashMap<String, Object> hm ) {
		String sql=null;
		ArrayList<HashMap<String, Object>> resultList = null;
		
			sql = "select * from class_info";
		
		try {
			resultList = dbcon.executeQuery(sql, hm);
			dbcon.commit();
		} catch (SQLException e) {
			try {
				dbcon.rollback();
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} finally {

			try {
				dbcon.closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultList;
	}

}
