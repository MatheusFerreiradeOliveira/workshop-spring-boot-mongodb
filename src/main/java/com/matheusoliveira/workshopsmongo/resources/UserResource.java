package com.matheusoliveira.workshopsmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusoliveira.workshopsmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User Sam = new User("1", "Sam Winchester", "sam@gmail.com");
		User Jean = new User("2", "Jean Winchester", "jean@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(Sam, Jean));
		return ResponseEntity.ok().body(list);
	}
}
