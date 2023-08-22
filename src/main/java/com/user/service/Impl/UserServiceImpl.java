package com.user.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.IUserRepository;
import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.exception.EmailAlreadyExistsException;
import com.user.exception.ResourceNotFoundException;
import com.user.mapper.UserMapper;
import com.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<UserDto> findAllUser() {
		List<User> findAll = userRepository.findAll();

//		return findAll.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		return findAll.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto findUserById(long id) {
		User user  = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		//User user = findById.get();
//		return UserMapper.mapToUserDto(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto saveAllUser(UserDto userDto) {
		// Convert UserDto into User JPA Entity
		// User user = UserMapper.mapToUser(userDto);
		Optional<User>optionalUser=userRepository.findByEmail(userDto.getEmail());
		if (optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email Already Exist");
			
		}
		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);
		// convert User Jpa entity into userDto
		// UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		return savedUserDto;
	}

	@Override
	public void deleteById(long id) {
		User existingUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
	
			userRepository.deleteById(id);

	

	}

	@Override
	public UserDto updateUser(UserDto user, long id) {
		User existingUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", user.getId()));
		existingUser.setFirst_Name(user.getFirst_Name());
		existingUser.setLast_Name(user.getLast_Name());
		existingUser.setAddress(user.getAddress());
		existingUser.setAge(user.getAge());
		existingUser.setEmail(user.getEmail());
		User updateUser = userRepository.save(existingUser);
		//return UserMapper.mapToUserDto(updateUser);
		return modelMapper.map(updateUser, UserDto.class);

	}

}
