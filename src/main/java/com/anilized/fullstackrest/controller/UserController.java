package com.anilized.fullstackrest.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anilized.fullstackrest.entity.UserEntity;
import com.anilized.fullstackrest.service.UserService;

@RestController
public class UserController {

	public static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;

	@GetMapping(path = "/users")
	public List<UserEntity> getAllUsers() {
		return service.listAll();
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Void> saveUser(@RequestBody UserEntity user) {

		UserEntity u = service.saveUser(user);
		
		
		
		if (u == null) {
			return ResponseEntity.badRequest().build();
		}
		log.info(u.toString());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@GetMapping(path = "/hello")
	public String helloRest() {
		return "Hello World!";
	}
	
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable(value = "id") Long id){
		service.deleteUser(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<Void> registerUser(@RequestBody UserEntity user){
		try {
			service.registerUser(user.getUsername(), user.getEmail(), user.getPassword(), user.getPasswordConfirmation());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().build();
	}
	
	

}
