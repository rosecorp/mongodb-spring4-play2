package controllers;
																																																																																																																																			
import java.util.List;
import java.util.Map;

import models.User;

import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import service.UserService;
import views.formdata.UserFormData;
import views.html.index;
import assemblers.UserAssembler;

@org.springframework.stereotype.Controller
public class Application extends Controller {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAssembler userAssembler;

	public Result getIndex() {
		List<UserFormData> users = userAssembler.toViews(userService.findAllUsers());
		Form<UserFormData> formData = Form.form(UserFormData.class).fill(new UserFormData());

		return ok(index.render("Records in DB: " + users.size(), users, formData));
	}
	
	public Result postIndex() {
		Form<UserFormData> formData = Form.form(UserFormData.class).bindFromRequest();
		
		if (formData.hasErrors()) {
			validateForm(formData);
		} 
		
		else {
			UserFormData ufd = formData.get();
			flash("success", "User created: " + ufd.getUsername());
			userService.addNewUser(userAssembler.toModel(ufd));
		}
		return redirect(routes.Application.getIndex());
	}

	public Result resetAll() {
		userService.deleteAll();
		return redirect(routes.Application.getIndex());
	}
	
	public Result deleteUser(String userId) {
		User retrievedUser = userService.findUserById(userId);
		if (retrievedUser != null) {
			userService.deleteUser(retrievedUser);
		}
		return redirect(routes.Application.getIndex());
	}
	
	private void validateForm(Form<UserFormData> formData) {
		String errorMsg = "";
		Map<String, List<ValidationError>> allErrors = formData.errors();
		for (String field : allErrors.keySet()) {
			errorMsg += " '" + field + "' " + " ";
			for (ValidationError error : allErrors.get(field)) {
				errorMsg += error.message() + ", ";
			}
		}
		
		flash("error", "Please correct the following errors: " + errorMsg);
	}
}
