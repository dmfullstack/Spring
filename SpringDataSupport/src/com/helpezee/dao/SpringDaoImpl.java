	package com.helpezee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import com.helpezee.model.Circle;
	@Component
	public class SpringDaoImpl {
		
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; // supports only ?
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; // supports named parameters
	private SimpleJdbcTemplate simpleJdbcTemplate; // allows both both ? and named  parameters but limited to some functionalities

	
	public void insertCircle(Circle circle){
		String sql="insert into circle values(?,?)";
	jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
	}
	
	//Name Parameters
	public void insertCircle1(Circle circle){
		String sql="insert into circle values(:id,:name)";
	  SqlParameterSource sqlparam= new MapSqlParameterSource("id", circle.getId()).addValue("name",circle.getName());
	  namedParameterJdbcTemplate.update(sql, sqlparam);
	}
	
	//simpleJdbcTemplate
	public void insertCircle2(Circle circle){
		String sql="insert into circle values(:id,:name)";
	  SqlParameterSource sqlparam= new MapSqlParameterSource("id", circle.getId()).addValue("name",circle.getName());
	  simpleJdbcTemplate.update(sql, sqlparam);
	}
	
	
	public void updateCircle(Circle circle){
		String sql="update circle set name=? where id=?";
	simpleJdbcTemplate.update(sql, new Object[]{circle.getName(),circle.getId()});
	}
	
	public void deleteCircle(int circleid){
		String sql="delete from circle where id=?";
	jdbcTemplate.update(sql, new Object[]{circleid});
	}
	
	public void createTriangle(){
		String sql="create table triangle(id int,name varchar(50))";
		jdbcTemplate.execute(sql);
	}
	
	
	public Circle getCircle(int circleId){
	String sql="select * from circle where id=?";
	return jdbcTemplate.queryForObject(sql, new Object[]{circleId},new circleMapper());
	}
	public List<Circle> getAllCircles(){
		String sql="select * from circle";
		return jdbcTemplate.query(sql,new circleMapper());
		}
	public int getCircleRowCount()
	{
	String sql="select count(*) from circle";
	return jdbcTemplate.queryForInt(sql);
	}
	public String getCircleName(int circleId)
	{
	String sql="select name from circle where id=?";
	return jdbcTemplate.queryForObject(sql, new Object[]{"1"},String.class);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	@Qualifier("dataSource")
	public void setDataSource(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.jdbcTemplate= new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcTemplate= new SimpleJdbcTemplate(dataSource);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public static final class circleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNo) throws SQLException {
			Circle circle=new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}
		
	}
	
	}


