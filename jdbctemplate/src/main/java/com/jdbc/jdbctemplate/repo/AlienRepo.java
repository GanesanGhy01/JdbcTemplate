package com.jdbc.jdbctemplate.repo;


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
	
	public String save(Alien alien) {
		String sql = "insert into alien (id,name,tech) values (?,?,?)";
		int row = template.update(sql, alien.getId(),alien.getName(),alien.getTech());
		return ""+row+" row(s) affected and inserted";
	}
	public String update(Alien alien) {
		String sql = "UPDATE alien SET name = ?, tech = ? WHERE id = ?";
		int row = template.update(sql, alien.getName(),alien.getTech(),alien.getId());
		return ""+row+" row(s) affected and updated";
	}
	public String delete(int aid) {
		String sql = "delete from alien where id = ?";
		int row = template.update(sql,aid);
		return ""+row+" row(s) affected and deleted";
	}
	public List<Alien> findAll(){
		String sql = "select * from alien";
		RowMapper<Alien> mapper = new RowMapper<>() {
			@Override
			public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Alien alien = new Alien();
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setTech(rs.getString(3));
				return alien;
			}
		};
		List<Alien> aliens = template.query(sql, mapper);
		return aliens;	
	}

}
