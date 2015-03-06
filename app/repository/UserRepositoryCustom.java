package repository;

import models.User;

import org.springframework.data.mongodb.repository.Query;

public interface UserRepositoryCustom {
	
	@Query(value="{'username':?0}", fields="{ 'username' : 1}")
	User findByNameAndReturnUsernameOnly(String name);
	
}
