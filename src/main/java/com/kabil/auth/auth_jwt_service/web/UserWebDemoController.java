package com.kabil.auth.auth_jwt_service.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/user")
public class UserWebDemoController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from UserWebDemoController!";
    }
}
