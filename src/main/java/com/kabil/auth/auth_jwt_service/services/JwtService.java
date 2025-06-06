package com.kabil.auth.auth_jwt_service.services;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    @Value("${spring.jwt.security.key}")
    private String secretKey;

    public String generateToken(UserDetails userDetails) {
        // Logic to generate JWT token using the secretKey and userDetails
        // This is a placeholder; actual implementation will depend on your JWT library
        return generateToken(new HashMap<>() , userDetails);
    }

    private String generateToken(Map<String, Objects> extraClaims, UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            roles.add(authority.getAuthority());

        }
        claims.put("roles", roles);
        claims.putAll(extraClaims);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new java.util.Date(System.currentTimeMillis()))
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(getSignInKey())
                .compact();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
