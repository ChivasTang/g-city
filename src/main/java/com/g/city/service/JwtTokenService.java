package com.g.city.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenService{
    void setAuthentication(UserDetails userDetails);

    String getUsernameFromToken(String token);

    String generateToken(UserDetails userDetails);

    Boolean validateToken(String token, UserDetails userDetails);
}
