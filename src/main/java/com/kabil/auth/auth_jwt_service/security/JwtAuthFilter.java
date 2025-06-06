package com.kabil.auth.auth_jwt_service.security;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kabil.auth.auth_jwt_service.services.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter  extends OncePerRequestFilter {
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
                Enumeration<String> headerNames = request.getHeaderNames();
                while (headerNames.hasMoreElements()) {
                    String headerName = headerNames.nextElement();
                    String headerValue = request.getHeader(headerName);
                    
                }
                final String authHeader = request.getHeader("Authorization");
                if(authHeader == null || !authHeader.startsWith("Bearer ")) {
                    filterChain.doFilter(request, response);
                    return;
                }

                String jwt = authHeader.substring(7);
                final String userEmail = jwtService.extractUsername(jwt);

                if (userEmail != null) {
                    System.out.println("$$$$$$$ user : " + userEmail);
                } else {
                    System.out.println("$$$$$$$ user : null (could not extract username from JWT)");
                }



                filterChain.doFilter(request, response);
    }


}
