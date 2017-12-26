package com.test.iot.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	@Override
	public ArrayList<HashMap<String, Object>> selectUserList() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
		String sql = "select * from user_info";
		try {
			pst = DBCon.getCon().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("uino", rs.getString("uino"));
				hm.put("uiname", rs.getString("uiname"));
				hm.put("uiage", rs.getString("uiage"));
				hm.put("uiid", rs.getString("uiid"));
				hm.put("uipwd", rs.getString("uipwd"));
				hm.put("cino", rs.getString("cino"));
				userList.add(hm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public HashMap<String, Object> selectUser() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		HashMap<String, Object> hm = new HashMap<String, Object>();
		String sql = "select * from user_info where uiname='백길동'";
		try {
			pst = DBCon.getCon().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				hm.put("uino", rs.getString("uino"));
				hm.put("uiname", rs.getString("uiname"));
				hm.put("uiage", rs.getString("uiage"));
				hm.put("uiid", rs.getString("uiid"));
				hm.put("uipwd", rs.getString("uipwd"));
				hm.put("cino", rs.getString("cino"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hm;
	}

	@Override
	public String updateUser() {
		PreparedStatement pst = null;
		String resultStr =null;
		int resultNum=0;
		String sql = "update user_info set uiage = 100 where uiname='케빈'";
		
		try {
			pst = DBCon.getCon().prepareStatement(sql);
			resultNum = pst.executeUpdate();
			if(resultNum>=1) {
				resultStr = "수정 성공했다!";
			}
			else {
				resultStr = "수정 실패했다!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

	@Override
	public String deleteUser() {
		PreparedStatement pst = null;
		String resultStr =null;
		int resultNum=0;
		String sql = "delete from user_info where uiage=8";
		
		try {
			pst = DBCon.getCon().prepareStatement(sql);
			resultNum = pst.executeUpdate();
			if(resultNum>=1) {
				resultStr = "삭제 성공했다!";
			}
			else {
				resultStr = "삭제 실패했다!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

	@Override
	public String insertUser() {
		PreparedStatement pst = null;
		String resultStr =null;
		int resultNum=0;
		String sql = "insert into user_info(uiname,uiage,uiid,uipwd,cino) values('케빈',8,'alone','alone',3)";
		
		try {
			pst = DBCon.getCon().prepareStatement(sql);
			resultNum = pst.executeUpdate();
			if(resultNum>=1) {
				resultStr = "입력 성공했다!";
			}
			else {
				resultStr = "입력 실패했다!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

}
