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
import com.matheusoliveira.workshopsmongo.dto.CommentDTO;
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
		
		Post post1 = new Post(null, sdf.parse("06/09/2019"), "EZ4ENCE", "dudaduperpel", new AuthorDTO(Sam));
		Post post2 = new Post(null, sdf.parse("06/09/2019"), "CEEEEEEEEEEEEEEEEEEEEEB", "CEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEB", new AuthorDTO(lul));
		
		CommentDTO c1 = new CommentDTO("ceeeeeeeeeeeeeeeeeeeeeeb", sdf.parse("06/09/2019"), new AuthorDTO(Jean));
		CommentDTO c2 = new CommentDTO("HE GETS THE CALL OF HIS LIFE TIME", sdf.parse("06/09/2019"), new AuthorDTO(Jean));
		
		
		post2.getComments().addAll(Arrays.asList(c1, c2));
		
		postRepository.save(Arrays.asList(post1, post2));
		
		lul.getPosts().addAll(Arrays.asList(post2));
		Sam.getPosts().addAll(Arrays.asList(post1));
		
		userRepository.save(Arrays.asList(lul, Sam));
	}
}