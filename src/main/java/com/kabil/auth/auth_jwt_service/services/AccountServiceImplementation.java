package com.kabil.auth.auth_jwt_service.services;
import org.springframework.stereotype.Service;

import com.kabil.auth.auth_jwt_service.dto.RegisterRequestDto;
import com.kabil.auth.auth_jwt_service.entities.User;
import com.kabil.auth.auth_jwt_service.repositories.UserRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Service
@Data
@RequiredArgsConstructor
public class AccountServiceImplementation  implements AccountService{

    private final UserRepository userRepository;

    @Override
    public User addNewUser(RegisterRequestDto request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(request.getPassword()) // In a real application, ensure to hash the password
                .build();
        return userRepository.save(user);
    }
}
