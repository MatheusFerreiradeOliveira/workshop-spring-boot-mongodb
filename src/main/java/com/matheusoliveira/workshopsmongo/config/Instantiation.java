package com.matheusoliveira.workshopsmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.matheusoliveira.workshopsmongo.domain.Post;
import com.matheusoliveira.workshopsmongo.domain.User;
import com.matheusoliveira.workshopsmongo.dto.AuthorDTO;
import com.matheusoliveira.workshopsmongo.repository.PostRepository;
import com.matheusoliveira.workshopsmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User Jean = new User(null, "Jean Winchester", "jean@gmail.com");
		User Sam = new User(null, "Sam Winchester", "sam@gmail.com");
		User lul = new User(null, "lul Winchester", "lul@gmail.com");

		userRepository.save(Arrays.asList(Jean, Sam, lul));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "EZ4ENCE", "dudaduperpel", new AuthorDTO(Sam));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "CEEEEEEEEEEEEEEEEEEEEEB", "CEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEB", new AuthorDTO(lul));
		
		postRepository.save(Arrays.asList(post1, post2));
		
		lul.getPosts().addAll(Arrays.asList(post2));
		Sam.getPosts().addAll(Arrays.asList(post1));
		
		userRepository.save(Arrays.asList(lul, Sam));
	}
}