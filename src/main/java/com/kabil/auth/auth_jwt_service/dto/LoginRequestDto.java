package com.kabil.auth.auth_jwt_service.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;

}
