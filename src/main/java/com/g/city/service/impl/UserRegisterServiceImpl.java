package com.g.city.service.impl;

import com.g.city.controller.result.ResultCode;
import com.g.city.domain.dto.UserRegister;
import com.g.city.domain.entity.UserAuthInfo;
import com.g.city.mapper.UserAuthInfoMapper;
import com.g.city.service.UserRegisterService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserRegisterServiceImpl implements UserRegisterService {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserAuthInfoMapper userAuthInfoMapper;

    @Override
    public ResultCode register(UserRegister userRegister) {
        //Check username password
        if (userRegister == null || userRegister.getUsername() == null) {
            return ResultCode.REGISTER_FAILED_USERNAME_NOT_INPUT;
        }
        final String username = userRegister.getUsername();
        final String rawPassword = userRegister.getPassword();
        if (rawPassword == null) {
            return ResultCode.REGISTER_FAILED_PASSWORD_NOT_INPUT;
        }
        if (!rawPassword.equals(userRegister.getConfirm())) {
            return ResultCode.REGISTER_FAILED_PASSWORD_NOT_CONFIRMED;
        }
        //查询是否已有相同用户名的用户
        final Optional<UserAuthInfo> userAuthInfo = userAuthInfoMapper.selectByUsername(username);
        if (userAuthInfo.isPresent()) {
            return ResultCode.REGISTER_FAILED_USERNAME_EXISTED;
        }
        final String encodedPassword = passwordEncoder.encode(rawPassword);
        final UserAuthInfo user = new UserAuthInfo(username, encodedPassword);
        userAuthInfoMapper.insert(user);
        return ResultCode.REGISTER_SUCCESS;
    }
}
