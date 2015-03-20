package views.formdata;

import java.util.ArrayList;
import java.util.List;

import play.data.validation.ValidationError;

public class UserFormData {

	private String id;

	private String username;

	private String password;

	private String role;

	public UserFormData() {
	}

	public UserFormData(String id, String username, String password, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<ValidationError>();
		if (password == null || password.length() == 0) {
			errors.add(new ValidationError("Password", " - no password was given"));
		}
		if (role == null || role.length() == 0) {
			errors.add(new ValidationError("Role", " - no role for user"));
		}

		return errors.size() > 0 ? errors : null;
	}

}
