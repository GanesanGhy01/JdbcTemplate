package com.jdbc.jdbctemplate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.jdbctemplate.Request.AlienRequest;
import com.jdbc.jdbctemplate.Response.AlienResponse;
import com.jdbc.jdbctemplate.model.Alien;
import com.jdbc.jdbctemplate.repo.AlienRepo;

@Service
public class AlienService {
	
	@Autowired
	AlienRepo repo;
	
	public List<AlienResponse> getAllAlien(){
		List<Alien> aliens = repo.findAll();
		List<AlienResponse> res = new ArrayList<>();
		for(Alien alien : aliens) {
			AlienResponse ar = new AlienResponse();
			ar.setId(alien.getId());
			ar.setName(alien.getName());
			ar.setTech(alien.getTech());
			res.add(ar);
		}
		return res;
	}
	public String insertAlien(AlienRequest ar) {
		Alien alien = new Alien();
		alien.setId(ar.getId());
		alien.setName(ar.getName());
		alien.setTech(ar.getTech());
		return repo.save(alien);
	}
	public String updataAlien(AlienRequest ar) {
		Alien alien = new Alien();
		alien.setId(ar.getId());
		alien.setName(ar.getName());
		alien.setTech(ar.getTech());
		
		return repo.update(alien);
	}
	public String deleteAlien(int aid) {
		return repo.delete(aid);
	}
}
