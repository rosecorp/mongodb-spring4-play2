package service;

import java.util.List;

import models.User;

public interface UserService {
	
	void addNewUser(User user);
	
	List<User> findAllUsers();
	
	User getUser(String username);
	
	void deleteAll();
	
}
