package com.projects.app.users.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.projects.app.users.data.UserEntity;
import com.projects.app.users.data.repo.UsersRepository;
import com.projects.app.users.dto.UserDetailsDto;
import com.projects.app.users.mapper.UsersMapper;

@Service
public class UsersServiceImpl implements UsersServiceInterface {
	
//	@Autowired
//	UsersMapper usersMapper;
	
	UsersRepository userRepo;
	
	Environment env;
	
	@Autowired
	public UsersServiceImpl(UsersRepository userRepo, Environment env){
		
		this.userRepo = userRepo;
		this.env = env;
//		this.usersMapper = UsersMapper.INSTANCE;
	}

	@Override
	public UserDetailsDto createUser(UserDetailsDto userDetails) {

		userDetails.setUserID(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword("encrypted password");
		UserEntity userEntity = UsersMapper.INSTANCE.userDtoToUserEntity(userDetails);
		userRepo.save(userEntity);
		
		UserDetailsDto savedDto = UsersMapper.INSTANCE.userEntityToDto(userEntity);
		
		return savedDto;
	}

}
