package service;

import java.util.List;

import model.User;

public interface UserService {
	
	void addNewUser(User user);
	
	List<User> findAllUsers();
	
	User getUser(String username);
	
}
