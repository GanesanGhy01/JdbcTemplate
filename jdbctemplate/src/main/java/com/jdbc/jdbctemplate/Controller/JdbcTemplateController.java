package com.jdbc.jdbctemplate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.jdbctemplate.Request.AlienRequest;
import com.jdbc.jdbctemplate.Response.AlienResponse;
import com.jdbc.jdbctemplate.service.AlienService;

@RestController
public class JdbcTemplateController {
	
	@Autowired
	AlienService service;
	
	@GetMapping("/getAlien")
	public List<AlienResponse> getAlien(){
		return service.getAllAlien();
	}
	
	@PostMapping("/saveAlien")
	public String saveAlien(@RequestBody AlienRequest ar) {
		return service.insertAlien(ar);
	}
	
	@PutMapping("/updateAlien")
	public String updateAlien(@RequestBody AlienRequest ar) {
		return service.updataAlien(ar);
	}
	
	@DeleteMapping("/deleteAlien/{aid}")
	public String deleteAlien(@PathVariable("aid") int aid ) {
		return service.deleteAlien(aid);
	}
}
