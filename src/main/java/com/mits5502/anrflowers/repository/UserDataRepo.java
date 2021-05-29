package com.mits5502.anrflowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits5502.anrflowers.model.User;

public interface UserDataRepo extends JpaRepository<User, Long> {

	User findByUserName(String username);

}
