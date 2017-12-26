package com.test.iot.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.ClassDAO;

public class ClassDAOImpl implements ClassDAO{

	@Override
	public ArrayList<HashMap<String, Object>> selectClass() {
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ArrayList<HashMap<String, Object>> classList = new ArrayList<HashMap<String, Object>>();
		String sql = "select * from class_info";
		
		try {
			psmt = DBCon.getCon().prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				HashMap<String, Object> hm = new HashMap<String,Object>();
				hm.put("cino", rs.getString("cino"));
				hm.put("ciname", rs.getString("ciname"));
				hm.put("cidesc", rs.getString("cidesc"));
				classList.add(hm);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return classList;
	}
	
}
