package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import models.User;
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
	public User findUserById(String id) {
		return userRepository.findOne(id);
	}

	@Override
	public User getUserName(String username) {
		return userRepository.findByNameAndReturnUsernameOnly(username);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}


}
