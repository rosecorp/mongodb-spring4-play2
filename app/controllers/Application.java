package controllers;

import java.util.List;

import models.User;

import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import service.UserService;
import views.html.*;

@org.springframework.stereotype.Controller
public class Application extends Controller {
	
	@Autowired
	private UserService userService;

	public Result getIndex() {
		List<User> users = userService.findAllUsers();
		Form<User> formData = Form.form(User.class).fill(new User());

		return ok(index.render("Welcome anyone!", users, formData));
	}
	
	public Result postIndex() {
		List<User> users = userService.findAllUsers();
		Form<User> formData = Form.form(User.class).bindFromRequest();
		
		User user = formData.get();
		userService.addNewUser(user);
		
		return ok(index.render("Welcome anyone!", users, formData));
	}
	
	public Result resetAll() {
		userService.deleteAll();
		return redirect(routes.Application.getIndex());
	}
}
