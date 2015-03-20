package service;

import java.util.List;

import models.User;

public interface UserService {
	
	void addNewUser(User user);
	
	List<User> findAllUsers();
	
	User getUserName(String username);
	
	User findUserById(String id);
	
	void deleteAll();
	
	void deleteUser(User user);
	
	
	
}
