package com.kabil.auth.auth_jwt_service.services;
import org.springframework.http.ResponseEntity;

import com.kabil.auth.auth_jwt_service.dto.AccountReponceDto;
import com.kabil.auth.auth_jwt_service.dto.RegisterRequestDto;

public interface AccountService {
    ResponseEntity<AccountReponceDto> addNewUser(RegisterRequestDto user);
       
}
