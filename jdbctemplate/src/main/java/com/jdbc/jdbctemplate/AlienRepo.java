package com.jdbc.jdbctemplate;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jdbc.jdbctemplate.model.Alien;

@Repository
public class AlienRepo {
	
	@Autowired
	private JdbcTemplate template;
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	void save(Alien alien) {
		String sql = "insert into alien (id,name,tech) values (?,?,?)";
		template.update(sql, alien.getId(),alien.getName(),alien.getTech());
	}
	List<Alien> findAll(){
		
		String sql = "select * from alien";
		RowMapper<Alien> mapper = new RowMapper<>() {

			@Override
			public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Alien alien = new Alien();
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setTech(rs.getInt(3));
				return alien;
			}
			
		};
		List<Alien> aliens = template.query(sql, mapper);
		return aliens;
		
	}

}
