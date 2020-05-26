package com.projects.app.users.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.projects.app.users.data.UserEntity;
import com.projects.app.users.dto.UserDetailsDto;

@Mapper(componentModel = "spring")
//@Component
public interface UsersMapper {
	
	UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);
	
	UserEntity userDtoToUserEntity(UserDetailsDto userDetailsDto);
	UserDetailsDto userEntityToDto(UserEntity userEntity);
}
