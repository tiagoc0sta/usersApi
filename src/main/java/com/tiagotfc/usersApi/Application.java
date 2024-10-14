package com.tiagotfc.usersApi;

import com.tiagotfc.usersApi.users.User;
import com.tiagotfc.usersApi.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

//	@Bean //instance of a class with metadata
//		// CommandLineRunner runs after application starter
//	CommandLineRunner user(UserRepository userRepository) {
//		return args -> {
//			User user = new User(1, "tiagoc0sta", "Tiago", "Costa", "tiago@tiagotfc.com","654985777");
//			userRepository.create(user);
//			System.out.println(user);
//		};
//	}

}
