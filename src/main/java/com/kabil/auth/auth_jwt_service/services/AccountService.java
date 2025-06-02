package com.kabil.auth.auth_jwt_service.services;

import java.util.List;

import com.kabil.auth.auth_jwt_service.entities.Role;
import com.kabil.auth.auth_jwt_service.entities.User;

public interface AccountService {
    Role addNewRole(Role role);
    void addRoleToUser(User user ,List<Role> roles); 
}
