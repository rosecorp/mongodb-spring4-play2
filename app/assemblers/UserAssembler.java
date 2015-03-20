package assemblers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import models.User;
import views.formdata.UserFormData;

@Component
public class UserAssembler {

	public UserFormData toView(User user) {
		return new UserFormData(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
	}
	
	public List<UserFormData> toViews(List<User> users) {
		List<UserFormData> ufd = new ArrayList<UserFormData>(); 
		for (User user : users) {
			ufd.add(new UserFormData(user.getId(), user.getUsername(), user.getPassword(), user.getRole()));
		}
		
		return ufd;		
	}
	
	public User toModel(UserFormData fd) {
		return new User(fd.getUsername(), fd.getPassword(), fd.getRole());
	}
	
}
