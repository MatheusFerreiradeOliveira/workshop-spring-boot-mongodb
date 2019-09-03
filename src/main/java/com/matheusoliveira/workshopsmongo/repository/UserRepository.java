package com.matheusoliveira.workshopsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.matheusoliveira.workshopsmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
