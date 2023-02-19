package com.g.city.filter;

import com.g.city.service.JwtTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;
    private final UserDetailsService userAuthService;

    public JwtTokenFilter(JwtTokenService jwtTokenService, UserDetailsService userAuthService) {
        this.jwtTokenService = jwtTokenService;
        this.userAuthService = userAuthService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader(HttpHeaders.WWW_AUTHENTICATE);
        if (requestTokenHeader != null && requestTokenHeader.length() > 6 && requestTokenHeader.startsWith("Bearer")) {
            final String authToken = requestTokenHeader.substring(6).trim();
            final String username = jwtTokenService.getUsernameFromToken(authToken);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                final UserDetails userDetails = userAuthService.loadUserByUsername(username);
                if (jwtTokenService.validateToken(authToken, userDetails)) {
                    jwtTokenService.setAuthentication(userDetails);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
