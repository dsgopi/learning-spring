package com.projects.app.users.data.repo;

import org.springframework.data.repository.CrudRepository;

import com.projects.app.users.data.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long>{

}
