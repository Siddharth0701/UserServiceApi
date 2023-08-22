package com.user.service;

import java.util.List;

import com.user.dto.UserDto;
import com.user.entity.User;

public interface IUserService {

	List<UserDto> findAllUser();

	UserDto findUserById(long id);

	UserDto saveAllUser(UserDto userDto);

	void deleteById(long id);

	UserDto updateUser(UserDto user, long id);

}
