package com.projects.app.users.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.app.users.view.model.CreateUserRequestModel;

@RestController
@RequestMapping("/users")
public class UsersServiceController {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/health/check")
	public String health() {
		
		return "Users Service is running...on port: "+env.getProperty("local.server.port");
	}

	@PostMapping
	public String createUser(@Valid @RequestBody CreateUserRequestModel userRequest) {
		
		return "user created";
	}
}
