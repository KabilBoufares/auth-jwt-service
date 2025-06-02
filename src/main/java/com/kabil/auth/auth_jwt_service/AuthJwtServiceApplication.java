package com.kabil.auth.auth_jwt_service;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kabil.auth.auth_jwt_service.entities.Role;
import com.kabil.auth.auth_jwt_service.entities.User;
import com.kabil.auth.auth_jwt_service.enums.RoleName;
import com.kabil.auth.auth_jwt_service.services.AccountService;

@SpringBootApplication
public class AuthJwtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthJwtServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args -> {
			Role adminRole = new Role(RoleName.ADMIN);
			Role userRole = new Role(RoleName.USER);

			accountService.addNewRole(adminRole);
			accountService.addNewRole(userRole);

			User userToPersist = new User(null, "kabil", "bf","kabil@test.com", "12345678",  null);
			accountService.addNewUser(userToPersist);
			ArrayList<Role> roles = new ArrayList<>();
			roles.add(adminRole);
			roles.add(userRole);
			accountService.addRoleToUser(userToPersist, roles);
		};
		
	}

}
