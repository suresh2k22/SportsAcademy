package com.sports.customidgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.HibernateError;
import org.hibernate.SharedSessionContract;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


public class SportsIdGenerator implements IdentifierGenerator {

	@Autowired  
    JdbcTemplate jdbcTemplate;

	String prefix="SPS";
	String suffix="";
	String result = "";

	@Override

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateError {
		//Connection con = session.connection();
		try {
		    String sql="SELECT MAX(sports_id) AS sports_id FROM sports";
		    result = jdbcTemplate.queryForObject(sql, String.class);
		    if (result == null || result == "") {
		    	suffix = "1";
		    } else {
		    	suffix = Integer.toString((Integer.parseInt(result.substring(3)) + 1));
		    }
		    /*PreparedStatement stmt=con.prepareStatement(sql);  
		    ResultSet rs=stmt.executeQuery(); 
		    if(rs.next()) {
		    	result = rs.getString("sports_id");
		    	suffix = Integer.toString((Integer.parseInt(result.substring(3)) + 1));
		    } else {
		    	suffix = "1";
		    }*/
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return prefix+suffix;
	}
}
