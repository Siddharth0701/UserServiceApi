package com.user.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.exception.ErrorDetails;
import com.user.exception.ResourceNotFoundException;
import com.user.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		List<UserDto> findAllUser = userService.findAllUser();
		return new ResponseEntity<>(findAllUser, HttpStatus.OK);

	}

	@GetMapping("{id}")
	public ResponseEntity<UserDto> findById(@PathVariable long id) {
		UserDto findUserById = userService.findUserById(id);
		return new ResponseEntity<>(findUserById, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserDto> saveUser( @Valid @RequestBody UserDto userDto) {
		UserDto saveAllUser = userService.saveAllUser(userDto);
		return new ResponseEntity<>(saveAllUser, HttpStatus.CREATED);

	}

	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser( @Valid @RequestBody UserDto user, @PathVariable long id) {
		//user.setId(id);
		UserDto updateUser = userService.updateUser(user, id);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) {
		userService.deleteById(id);
		return new ResponseEntity<>("user Deleted", HttpStatus.OK);
	}

}
