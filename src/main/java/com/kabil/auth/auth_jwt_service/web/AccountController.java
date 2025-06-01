package com.kabil.auth.auth_jwt_service.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kabil.auth.auth_jwt_service.dto.AccountReponceDto;
import com.kabil.auth.auth_jwt_service.dto.RegisterRequestDto;
import com.kabil.auth.auth_jwt_service.services.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final  AccountService accountService;
    @GetMapping ("/hello")
    public String hello() {
        return "Hello from Account Service";
    }

    @PostMapping("/register")
    public ResponseEntity <AccountReponceDto> register(@RequestBody RegisterRequestDto request){
        return accountService.addNewUser(request);
    }
}
