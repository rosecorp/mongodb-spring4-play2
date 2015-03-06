package controllers;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;

import play.mvc.Controller;
import play.mvc.Result;
import service.UserService;
import views.html.index;

@org.springframework.stereotype.Controller
public class Application extends Controller {

	@Autowired
	private UserService userService;

	public Result index() {
		User u = new User("jakub", "secret5", "java dev2");
		userService.addNewUser(u);
		
		return ok(index.render(userService.getUser("jakub").toString()));
	}

}
