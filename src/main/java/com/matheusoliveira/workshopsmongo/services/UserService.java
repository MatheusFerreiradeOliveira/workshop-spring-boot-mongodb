package com.matheusoliveira.workshopsmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusoliveira.workshopsmongo.domain.User;
import com.matheusoliveira.workshopsmongo.dto.UserDTO;
import com.matheusoliveira.workshopsmongo.repository.UserRepository;
import com.matheusoliveira.workshopsmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		 User user = repository.findOne(id);
		 if(user == null) {
			 throw new ObjectNotFoundException("Obj n encontrado");
		 }
		 return user;
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
}
