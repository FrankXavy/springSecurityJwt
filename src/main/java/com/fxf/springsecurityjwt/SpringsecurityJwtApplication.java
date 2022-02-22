package com.fxf.springsecurityjwt;

import com.fxf.springsecurityjwt.entity.User;
import com.fxf.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringsecurityJwtApplication {
	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "fxf", "fxf", "fxf@fxf.com"),
				new User(102, "user1", "pwd1", "user1@fxf.com"),
				new User(103, "user2", "pwd2", "user2@fxf.com"),
				new User(102, "user3", "pwd3", "user3@fxf.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityJwtApplication.class, args);
	}

}
