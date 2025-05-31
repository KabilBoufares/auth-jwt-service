package com.kabil.auth.auth_jwt_service.repositories;

import com.kabil.auth.auth_jwt_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}


