package com.kabil.auth.auth_jwt_service.services;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kabil.auth.auth_jwt_service.dto.RegisterRequestDto;
import com.kabil.auth.auth_jwt_service.dto.AccountReponceDto;
import com.kabil.auth.auth_jwt_service.entities.User;
import com.kabil.auth.auth_jwt_service.repositories.UserRepository;
import com.kabil.auth.auth_jwt_service.security.CustomPasswordEncoder;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Service
@Data
@RequiredArgsConstructor
public class AccountServiceImplementation  implements AccountService{

    private final UserRepository userRepository;
    private final CustomPasswordEncoder passwordEncoder;
    

    @Override
    public ResponseEntity <AccountReponceDto>  addNewUser(RegisterRequestDto request) {
        // Check if a user with the same email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(AccountReponceDto.builder()
                    .message("User with this email already exists")
                    .build());
        }
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // Encrypting the password
                .build();
        userRepository.save(user);
        return ResponseEntity.ok(
            AccountReponceDto.builder()
                .message("User registered successfully")
                .build()
        );  // Save the user to the database successfully
    }
}
