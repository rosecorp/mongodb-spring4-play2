package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import model.User;
import repository.UserRepository;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;
	
	@Override
	public void addNewUser(User user) {
		userRepository.save(user);		
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String username) {
		return userRepository.findByNameAndReturnUsernameOnly(username);
	}

}
