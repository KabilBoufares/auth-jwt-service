package com.kabil.auth.auth_jwt_service.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.kabil.auth.auth_jwt_service.entities.Role;
import com.kabil.auth.auth_jwt_service.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleName roleName);
  
    // Additional methods can be defined here if needed
}
