package com.kabil.auth.auth_jwt_service.services;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.kabil.auth.auth_jwt_service.dto.AccountReponceDto;
import com.kabil.auth.auth_jwt_service.dto.LoginRequestDto;
import com.kabil.auth.auth_jwt_service.dto.RegisterRequestDto;
import com.kabil.auth.auth_jwt_service.entities.User;
import com.kabil.auth.auth_jwt_service.repositories.UserRepository;
import com.kabil.auth.auth_jwt_service.security.CustomPasswordEncoder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final CustomPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    
    public ResponseEntity <AccountReponceDto>  register(RegisterRequestDto request) {
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

    
    public ResponseEntity<AccountReponceDto> login(LoginRequestDto user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
            new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
            )
            );
            System.out.println("Authentication successful: " + authentication.isAuthenticated());
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            return ResponseEntity
            .badRequest()
            .body(AccountReponceDto.builder()
                .message("Invalid email or password")
                .build());
        }
        return ResponseEntity.ok(
            AccountReponceDto.builder()
                .message("Login successful")
                .build()
        );
    }

}
