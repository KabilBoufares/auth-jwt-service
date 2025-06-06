package com.kabil.auth.auth_jwt_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountReponceDto {
    private String message ;
    private String token;
}
