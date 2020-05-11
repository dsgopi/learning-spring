package com.projects.users.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.users.models.response.UserResponse;

@RestController
@RequestMapping("users") // mapping to /users resource

public class UserController {
	
	HashMap<String, UserResponse> users = new HashMap<String, UserResponse>();

	@GetMapping
	public String getUsers(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {

		return "list of users";
	}

	@GetMapping(path="/{userId}",
			produces = { 
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE }
			)
	public UserResponse getUser(@PathVariable String userId) {

	
		return users.get(userId);
	}

	@PostMapping
	public String addUser() {
		UserResponse user = new UserResponse();

		user.setFirstName("TestFirst");
		user.setLastName("TestLast");
		user.setEmail("testemail@gmail.com");
//		user.setUserID(userId);
		return "User added";
	}

	@PutMapping
	public String updateUser() {

		return "user updated";
	}

	@DeleteMapping
	public String deleteUser() {

		return "user deleted";
	}
}
