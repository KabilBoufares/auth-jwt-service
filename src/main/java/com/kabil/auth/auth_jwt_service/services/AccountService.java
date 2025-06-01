package com.kabil.auth.auth_jwt_service.services;
import com.kabil.auth.auth_jwt_service.dto.RegisterRequestDto;
import com.kabil.auth.auth_jwt_service.entities.User;
public interface AccountService {
    User addNewUser(RegisterRequestDto request);
}
