package com.g.city.service.impl;

import com.g.city.controller.result.ResultCode;
import com.g.city.domain.dto.UserLogin;
import com.g.city.service.JwtTokenService;
import com.g.city.service.UserLoginService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    private UserDetailsService userAuthService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private JwtTokenService jwtTokenService;

    @Override
    public ResultCode login(final UserLogin userLogin) {
        if (userLogin == null || userLogin.getUsername() == null || userLogin.getUsername().isBlank()) {
            return ResultCode.LOGIN_FAILED_USERNAME_NOT_INPUT;
        }
        if (userLogin.getPassword() == null) {
            return ResultCode.LOGIN_FAILED_PASSWORD_NOT_INPUT;
        }
        final String username = userLogin.getUsername();
        final String rawPassword = userLogin.getPassword();
        final UserDetails userDetails = userAuthService.loadUserByUsername(username);
        if (userDetails == null) {
            return ResultCode.LOGIN_FAILED_USERNAME_NOT_EXIST;
        }
        if (!passwordEncoder.matches(rawPassword, userDetails.getPassword())) {
            return ResultCode.LOGIN_FAILED_USERNAME_PASSWORD_NOT_VALIDATED;
        }
        jwtTokenService.setAuthentication(userDetails);
        return ResultCode.LOGIN_SUCCESS;
    }
}
