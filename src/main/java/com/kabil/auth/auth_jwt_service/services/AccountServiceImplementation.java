package com.kabil.auth.auth_jwt_service.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.kabil.auth.auth_jwt_service.entities.Role;
import com.kabil.auth.auth_jwt_service.entities.User;
import com.kabil.auth.auth_jwt_service.repositories.RoleRepository;
import com.kabil.auth.auth_jwt_service.repositories.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Service
@Data
@RequiredArgsConstructor
public class AccountServiceImplementation  implements AccountService , UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
  
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    @Override
    public Role addNewRole(Role role) {
        
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(User user, List<Role> roles) {
        User userFromDb = userRepository.findByEmail(user.getEmail()).orElse(null);

        roles.stream()
            .map(Role::getRoleName)
            .map(roleRepository::findByRoleName)
            .forEach(role -> userFromDb.getRoles().add(role));
    }
    
       
}
 