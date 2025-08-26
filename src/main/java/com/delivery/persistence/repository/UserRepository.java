package com.delivery.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.delivery.persistence.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, String> {

}
