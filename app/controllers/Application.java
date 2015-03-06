package controllers;

import java.util.List;

import models.User;

import org.springframework.beans.factory.annotation.Autowired;

import play.mvc.Controller;
import play.mvc.Result;
import service.UserService;
import views.html.*;

@org.springframework.stereotype.Controller
public class Application extends Controller {

	@Autowired
	private UserService userService;

	public Result index() {
		List<User> users = userService.findAllUsers();
					
		return ok(index.render("Welcome anyone!", users));
	}
	
	public Result name(String n) {
		User u = new User(n, "secret5", "java dev2");
		userService.addNewUser(u);
		User user = userService.getUser(n);
		
		return ok(name.render(user));
	}

}
