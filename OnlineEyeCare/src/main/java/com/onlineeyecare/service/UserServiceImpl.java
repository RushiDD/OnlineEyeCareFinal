package com.onlineeyecare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlineeyecare.dao.IUserRepository;
import com.onlineeyecare.dto.User;
import com.onlineeyecare.exceptions.PasswordNotMatchException;
import com.onlineeyecare.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public String signIn(User user) throws UserNotFoundException{
		String massage = "User Not Found";
		Optional<User> resultUser =userRepository.findByuserName(user.getUserName());
		if(resultUser.isPresent()) {
			if((resultUser.get().getPassword().equals(user.getPassword())))
			{
			} 
			else
			
			throw new UserNotFoundException("User Not Found");
	}
	return massage;
}
	
	@Override
	public String signOut(User user) throws UserNotFoundException {
		String massage = "User Not Found";
		Optional<User> resultUser=userRepository.findByuserName(user.getUserName());

		if (!resultUser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		else if(resultUser.get().getPassword().equals(user.getPassword())) {
		}
		return massage;
	}
	
	@Override
	public User changePassword(String newPassword, User user) throws UserNotFoundException, PasswordNotMatchException {
		Optional<User> resultUser=userRepository.findByuserName(user.getUserName());
		if(resultUser.isPresent()) {
			if((resultUser.get().getPassword().equals(user.getPassword())))
			{
				user.setPassword(newPassword);
				return userRepository.save(user);
			}
			else
			{
				throw new PasswordNotMatchException("Password Not matched please enter valid password");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}	
	}

	
}
	


