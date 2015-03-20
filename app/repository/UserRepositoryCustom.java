package repository;

import models.User;

import org.springframework.data.mongodb.repository.Query;

public interface UserRepositoryCustom {
	
	@Query(value="{'username':?0}", fields="{ 'username' : 1}")
	User findByNameAndReturnUsernameOnly(String name);
	
	@Query(value="{'id':?0}", fields="{ 'id' : 1}")
	User findByIdAndReturnIdOnly(String name);
	
}
