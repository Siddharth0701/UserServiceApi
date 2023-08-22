package com.user.mapper;

import com.user.dto.UserDto;
import com.user.entity.User;

public class UserMapper {

// convert User Jpa entity into UserDto	
	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(user.getId(), user.getFirst_Name(), user.getLast_Name(), user.getAddress(),
				user.getAge(),user.getEmail());
		return userDto;

	}

	// Convert UserDto into User Jpa Entity
	public static User mapToUser(UserDto userDto) {
		User user = new User(userDto.getId(), userDto.getFirst_Name(), userDto.getLast_Name(), userDto.getAddress(),
				userDto.getAge(),userDto.getEmail());
		return user;

	}

}
