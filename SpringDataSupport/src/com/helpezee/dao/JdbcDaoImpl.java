package com.helpezee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.helpezee.model.Circle;

public class JdbcDaoImpl {
	
	Circle circle=null;
	ResultSet rsResultSet=null;
	PreparedStatement ps=null;

public Circle getCircle(int circleId){
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/loglocal";
	Connection conn=null;
	try{
	Class.forName(driver).newInstance();
	conn=DriverManager.getConnection(url,"root","techm");
	ps=conn.prepareStatement("select * from circle where id=?");
    ps.setInt(1,circleId );
    rsResultSet=ps.executeQuery();
   while(rsResultSet.next())
   {
	circle= new Circle(circleId,rsResultSet.getString("name"));
   }
  
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
		   conn.close();
		   ps.close();
		   rsResultSet.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return circle;
	
}
}
