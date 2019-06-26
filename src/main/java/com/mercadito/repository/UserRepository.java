package com.mercadito.repository;

import org.springframework.data.repository.CrudRepository;

import com.mercadito.entity.User;

public interface UserRepository extends CrudRepository <User, Long> {

}
