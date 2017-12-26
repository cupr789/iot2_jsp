package com.test.iot.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.ClassDAO;
import com.test.iot.dao.impl.ClassDAOImpl;
import com.test.iot.service.ClassService;

public class ClassServiceImpl implements ClassService{
	ClassDAO dao = new ClassDAOImpl();
	@Override
	public ArrayList<HashMap<String, Object>> getClassList() {
		ArrayList<HashMap<String, Object>> getClassList = new ArrayList<HashMap<String, Object>>();
		Connection con = DBCon.getCon();
		return dao.selectClass();
	}

}
