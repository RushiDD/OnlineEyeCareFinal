package com.onlineeyecare.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.User;
import com.onlineeyecare.exceptions.PasswordNotMatchException;
import com.onlineeyecare.exceptions.ResourceNotFoundException;
import com.onlineeyecare.exceptions.UserNotFoundException;
import com.onlineeyecare.service.IUserService;

@RestController
@RequestMapping("/")
public class UserController {
	
	Log logger = LogFactory.getLog(TestController.class);
	
	@Autowired
	private IUserService Iuserservice;
	
	@PostMapping("login")
	public ResponseEntity<String> loginUser(@RequestBody User userdto) throws UserNotFoundException, ResourceNotFoundException{
		logger.info("login successfully");
		return new ResponseEntity<String>(Iuserservice.signIn(userdto),HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logoutUser(@RequestBody User userdto) throws UserNotFoundException, ResourceNotFoundException{
		logger.info("logout successfully");
		return new ResponseEntity<String>(Iuserservice.signOut(userdto),HttpStatus.OK);	
	}
	
	@PutMapping("/updatepassword/{newPassword}")
	public ResponseEntity<User> updatePassword(@PathVariable String newPassword,@RequestBody User userdto) throws UserNotFoundException, PasswordNotMatchException, ResourceNotFoundException{
		logger.info("updatepassword successfully");
		return new ResponseEntity<User>(Iuserservice.changePassword(newPassword, userdto),HttpStatus.OK);
	}
	
}
