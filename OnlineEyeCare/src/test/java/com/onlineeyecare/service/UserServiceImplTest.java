package com.onlineeyecare.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineeyecare.dto.User;
import com.onlineeyecare.exceptions.PasswordNotMatchException;
import com.onlineeyecare.exceptions.ResourceNotFoundException;
import com.onlineeyecare.exceptions.UserNotFoundException;

@SpringBootTest
public class UserServiceImplTest  {
	@Autowired
	private IUserService userService;
	User user= new User("Gaurav@123","gau@123","Doctor");
	User user1= new User("Sumit@123","Sumit@123","Doctor");
	User user2=new User("Nihal@96","Nihal@96","Eyespecialist");
	User user3=new User("Aanasaheb@45","Aana@45","Admin");
	User user4=new User("Rushikesh@1","Rushi@1","Doctor");
	User user5=new User("Vishal@135","Vishal@135","Patient");
	
	
	
	void testchangePassword() throws UserNotFoundException, PasswordNotMatchException, ResourceNotFoundException {
		user=new User("Gaurav@123","gau@123","Doctor");
		
		assertEquals("gaurav@987",userService.changePassword("Gaurava@123",user).getPassword());
	}
	
	@Test
	void testSignIn1() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signIn(user));
	}
	                                                                         
	@Test
	void testSignIn2() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signIn(user2));
		
	}
	                                                                          
	@Test
	void testSignIn3() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signIn(user2));
	}
	                                                                 
	@Test
	void testSignIn5() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signIn(user4));
	}
	
	@Test
	void testdoctorLogin7() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signIn(user4));
	}

	@Test
	void testpatientLogin7() throws UserNotFoundException, ResourceNotFoundException {
		assertTrue(userService.signIn(user5));
	}
	
	private void assertTrue(String signOut) {
	
	}
}