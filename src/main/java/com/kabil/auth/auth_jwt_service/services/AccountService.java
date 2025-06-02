package com.kabil.auth.auth_jwt_service.services;

import java.util.List;

import com.kabil.auth.auth_jwt_service.entities.Role;
import com.kabil.auth.auth_jwt_service.entities.User;

public interface AccountService {
   
    User addNewUser(User user); //just for testing 

    Role addNewRole(Role role);
    void addRoleToUser(User user ,List<Role> roles); 
}
