package com.test.iot.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserService {

	public ArrayList<HashMap<String,Object>> getUserList();
	public HashMap<String,Object> getUser();
	public String getUpdateResult();
	public String getDeleteResult();
	public String getInsertResult();
}
