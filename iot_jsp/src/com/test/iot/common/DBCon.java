package com.test.iot.common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class DBCon {
    private Connection conn = null;
    private Statement st = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
	private String url = "jdbc:mariadb://localhost:3306/iot2";
	private String user="root";
	private String password="soos789";
	private String driver = "org.mariadb.jdbc.Driver";
	
    public DBCon(){
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    private boolean openConn() throws SQLException {
		if(conn==null || conn.isClosed()) {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		}
		return true;
    }
    
    
    private ArrayList<HashMap<String,Object>> parseResultSet(final ResultSet rs) throws SQLException{
    	ResultSetMetaData rsmd = rs.getMetaData();
		String[] colNames = new String[rsmd.getColumnCount()];

		for(int i=0;i<colNames.length;i++) {
			colNames[i] = rsmd.getColumnLabel(i+1);
		}
		ArrayList<HashMap<String,Object>> objList = new ArrayList<HashMap<String,Object>>();
		
		while(rs.next()) {
			HashMap<String,Object> hm = new HashMap<String,Object>();
			for(String colName : colNames) {
				hm.put(colName, rs.getString(colName));
			}
			objList.add(hm);
		}
		return objList;
    }

    public void closeAll() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if(ps!=null) {
        	ps.close();
        }
        if (conn != null) {
        	conn.close();
        }
    }

    public void commit() throws SQLException {
    	conn.commit();
    }
    
    public void rollback() throws SQLException {
    	conn.rollback();
    }
    
    
    
    public int executeUpdate(String sql,LinkedHashMap<String,Object> hm) throws SQLException {
    	int result = 0;
    	if(openConn()) {
    		ps = conn.prepareStatement(sql);
    		setParameter(hm);
    		result = ps.executeUpdate();
    	}
    	return result;
    }
    
    
    public int executeUpdate(String sql) throws SQLException {
    	return executeUpdate(sql, null);
    }
    
    
    
    private void setParameter(LinkedHashMap<String,Object> hm) throws SQLException {
		if(hm!=null) {
			Iterator<String> it = hm.keySet().iterator();
			int idx = 1;
			while(it.hasNext()) {
				String key = it.next();
				ps.setObject(idx++, hm.get(key));
			}
		}
    }
    
    
    public ArrayList<HashMap<String,Object>> executeQuery(String sql, LinkedHashMap<String,Object> hm)throws SQLException {
    	ArrayList<HashMap<String,Object>> objList = null;
    	if(openConn()) {
    		ps = conn.prepareStatement(sql);
    		setParameter(hm);
    		rs = ps.executeQuery();
    		objList = parseResultSet(rs);
    	}
    	return objList;
    }
}
