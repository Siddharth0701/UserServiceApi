package com.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	Optional<User>findByEmail(String email);

}
