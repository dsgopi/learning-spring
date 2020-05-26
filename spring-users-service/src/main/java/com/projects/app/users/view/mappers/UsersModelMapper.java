package com.projects.app.users.view.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.projects.app.users.dto.UserDetailsDto;
import com.projects.app.users.view.model.CreateUserRequestModel;
import com.projects.app.users.view.model.CreateUserResponseModel;

@Mapper(componentModel = "spring")
//@Component
public interface UsersModelMapper {

	UsersModelMapper INSTANCE = Mappers.getMapper(UsersModelMapper.class);
	
	@Mapping(source = "email", target = "username")
	UserDetailsDto userModelToDto(CreateUserRequestModel userModel);
	
	@InheritInverseConfiguration
	CreateUserResponseModel userDtoToUserResponse(UserDetailsDto userDetailsDto);
}
