package com.kabil.auth.auth_jwt_service.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.kabil.auth.auth_jwt_service.repositories.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Service
@Data
@RequiredArgsConstructor
public class AccountServiceImplementation  implements AccountService , UserDetailsService {

    private final UserRepository userRepository;
  
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }
       
}
 