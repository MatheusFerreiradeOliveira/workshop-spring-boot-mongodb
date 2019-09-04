package com.matheusoliveira.workshopsmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheusoliveira.workshopsmongo.domain.User;
import com.matheusoliveira.workshopsmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User Jean = new User(null, "Jean Winchester", "jean@gmail.com");
		User Sam = new User(null, "Sam Winchester", "sam@gmail.com");
		User lul = new User(null, "lul Winchester", "lul@gmail.com");

		userRepository.save(Arrays.asList(Jean, Sam, lul));
	}
	
}
