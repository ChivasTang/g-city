package com.g.city.controller.rest;

import com.g.city.constant.AppConstants;
import com.g.city.controller.result.ApiResult;
import com.g.city.controller.result.ResultCode;
import com.g.city.domain.dto.UserLogin;
import com.g.city.service.JwtTokenService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({("/" + AppConstants.API_VERSION + "/api/auth/login")})
public class UserLoginController {

    @Resource
    private UserDetailsService userAuthService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private JwtTokenService jwtTokenService;

    @PostMapping
    @ResponseBody
    public ApiResult<Object> login(@RequestBody UserLogin userLogin) {
        if (userLogin == null || userLogin.getUsername() == null || userLogin.getUsername().isBlank()) {
            return ApiResult.fail(ResultCode.LOGIN_FAILED_USERNAME_NOT_INPUT);
        }
        if (userLogin.getPassword() == null) {
            return ApiResult.fail(ResultCode.LOGIN_FAILED_PASSWORD_NOT_INPUT);
        }
        final String username = userLogin.getUsername();
        final String rawPassword = userLogin.getPassword();
        final UserDetails userDetails = userAuthService.loadUserByUsername(username);
        if (userDetails == null) {
            return ApiResult.fail(ResultCode.LOGIN_FAILED_USERNAME_NOT_EXIST);
        }
        if (!passwordEncoder.matches(rawPassword, userDetails.getPassword())) {
            return ApiResult.fail(ResultCode.LOGIN_FAILED_USERNAME_PASSWORD_NOT_VALIDATED);
        }
        jwtTokenService.setAuthentication(userDetails);
        final String token = jwtTokenService.generateToken(userDetails);
        final UserLogin loginSuccess = new UserLogin();
        loginSuccess.setUsername(userDetails.getUsername());
        loginSuccess.setToken(token);
        return ApiResult.success(ResultCode.LOGIN_SUCCESS, loginSuccess);
    }
}
