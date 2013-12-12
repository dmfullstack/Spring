package com.helpezee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;


import com.helpezee.model.Circle;

public class SimpleJdbcDaoSuportClass extends SimpleJdbcDaoSupport {
	ResultSet rs;

	public void insertCircle(Circle circle){
	  //String sql="insert into circle values(?,?)";
	  //getSimpleJdbcTemplate().update(sql, new Object[]{circle.getId(),circle.getName()});
	  //JdbcTemplate jdbc= new JdbcTemplate();
	   	Map<String, Map<String, String>> propsMain = new HashMap<String, Map<String, String>>();
		JdbcTemplate jdbctemplate = new JdbcTemplate(getDataSource());
		try{
		/*List<Map<String, Object>>rows = jdbc.queryForList("select * from property");
			jdbctemplate.queryForList("select * from PROPERTY where application_name=?", new Object[] {new String("TROUBLE_TICKET_V2")  }, 
					new RowMapper() {
						public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					System.out.println("Module:--"+resultSet.getString("Module_name"));
					System.out.println("key:--"+resultSet.getString("csi_key"));
					System.out.println("Value:--"+resultSet.getString("csi_value"));
			return null;
						}
					});*/
			String ModuleName = null;
			String Key = null;
			String Value = null;
			ResultSetWrappingSqlRowSet rs = (ResultSetWrappingSqlRowSet) jdbctemplate.queryForRowSet("select * from PROPERTY where application_name='TROUBLE_TICKET_V2'");
			while(rs.next()) {
				ModuleName=(String) rs.getString("module_name");
				Key= (String) rs.getString("csi_key");
				Value= (String) rs.getString("csi_value");
				System.out.println("Module:--"+ModuleName );
				System.out.println("key:--"+Key );
				System.out.println("Value:--"+Value );
		if (!propsMain.containsKey(ModuleName)) {
			  Map<String, String> propsSub = new HashMap<String, String>();
				propsSub.put(Key,Value);
				propsMain.put(ModuleName, propsSub);	  
		  }else {
				propsMain.get(ModuleName).put(Key, Value);
			}
		    };	
		
		    System.out.println(propsMain);
		
		}catch(Exception ee){ee.printStackTrace();}

	}
		/*public Map<String, Map<String, String>> getPropertiesForOneAppAndMultiModules(String applicationName) {
			Map<String, Map<String, String>> propsMain = new HashMap<String, Map<String, String>>();
			String ModuleName = null;
			String Key = null;
			String Value = null;
			try {
				
			final	JdbcTemplate jdbctemplate = new JdbcTemplate(getDataSource());
			 rows = (List) jdbctemplate.queryForRowSet("select * from PROPERTY where application_name='TROUBLE_TICKET_V2'");
				for (List rs : rows) {
				ModuleName=(String) rs.get("Module_name");
				Key= (String) rs.get("KEY");
				Value= (String) rs.get("VALUE");
				System.out.println("Module:--"+ModuleName );
				System.out.println("key:--"+Key );
				System.out.println("Value:--"+Value );
				if (!propsMain.containsKey(ModuleName)) {
					  Map<String, String> propsSub = new HashMap<String, String>();
						propsSub.put(Key,Value);
						propsMain.put(ModuleName, propsSub);	  
				  }else {
						propsMain.get(ModuleName).put(Key, Value);
					}
				    };
				    
				    System.out.println(propsMain);
					} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error while getting properties ::" + e.getMessage());
			} finally {
				//DbUtils.closeResources(conn, stmt, rs);
			}
			return propsMain;
		}*/
	}

