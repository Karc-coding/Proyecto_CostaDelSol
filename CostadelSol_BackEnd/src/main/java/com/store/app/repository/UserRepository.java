package com.store.app.repository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserRepository {

	@GetMapping("/")
	public String login() {
		return "authenticated successfully";
	}

}
