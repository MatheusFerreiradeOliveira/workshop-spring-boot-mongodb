package com.matheusoliveira.workshopsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.matheusoliveira.workshopsmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
}
