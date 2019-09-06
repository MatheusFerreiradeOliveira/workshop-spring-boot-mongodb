package com.matheusoliveira.workshopsmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusoliveira.workshopsmongo.domain.Post;
import com.matheusoliveira.workshopsmongo.repository.PostRepository;
import com.matheusoliveira.workshopsmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		 Post user = repository.findOne(id);
		 if(user == null) {
			 throw new ObjectNotFoundException("Obj n encontrado");
		 }
		 return user;
	}
}
