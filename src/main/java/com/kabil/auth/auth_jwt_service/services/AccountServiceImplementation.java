package com.kabil.auth.auth_jwt_service.services;
import org.springframework.stereotype.Service;

import com.kabil.auth.auth_jwt_service.entities.User;
import com.kabil.auth.auth_jwt_service.repositories.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AccountServiceImplementation  implements AccountService{

    private final UserRepository userRepository;

    @Override
    public User addNewUser(User user) {
        // Here you would typically save the user to the database
        // For now, we will just return the user object as is
        return userRepository.save(user);
    }
}
