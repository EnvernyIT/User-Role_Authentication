package com.enverny.userservices;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.enverny.userservices.entities.AppUser;
import com.enverny.userservices.entities.Role;
import com.enverny.userservices.services.AppUserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CommandLineRunner run(AppUserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new AppUser(null, "John Trovalta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Blake UNderwood", "blake", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Kit Harrington", "jonsnow", "1234", new ArrayList<>()));
			
			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("blake", "ROLE_ADMIN");
			userService.addRoleToUser("jonsnow", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("jonsnow", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("jonsnow", "ROLE_USER");
			userService.addRoleToUser("will", "ROLE_ADMIN");

		};
	}

}
