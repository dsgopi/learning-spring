package com.projects.app.users.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.app.users.dto.UserDetailsDto;
import com.projects.app.users.service.UsersServiceInterface;
import com.projects.app.users.view.mappers.UsersModelMapper;
import com.projects.app.users.view.model.CreateUserRequestModel;
import com.projects.app.users.view.model.CreateUserResponseModel;

import lombok.extern.slf4j.Slf4j;
//@Slf4j
@RestController
@RequestMapping("/users")
public class UsersServiceController {

	@Autowired
	private Environment env;

//	@Autowired
//	UsersModelMapper modelMapper;

	@Autowired
	UsersServiceInterface usersService;
	
	@Autowired
	LoggerFactory loggerFactory;

	@GetMapping("/health/check")
	public String health() {

		return "Users Service is running...on port: " + env.getProperty("local.server.port");
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userRequest) {
//		 log.error("Something else is wrong here");
		Logger logger = loggerFactory.getLogger(UsersServiceController.class);
		logger.debug("Inside createUser controller ");
		UserDetailsDto dto = UsersModelMapper.INSTANCE.userModelToDto(userRequest);
//		modelMapper = UsersModelMapper.INSTANCE;
		UserDetailsDto newUser = usersService.createUser(dto);
		logger.debug("dto in controller is "+dto.getUsername());
		CreateUserResponseModel newUserResponse = UsersModelMapper.INSTANCE.userDtoToUserResponse(newUser);
		logger.debug("dto in controller ->EMAIL AFTER MAPPING "+dto.getUsername());
		return ResponseEntity.status(HttpStatus.CREATED).body(newUserResponse);
	}
}
