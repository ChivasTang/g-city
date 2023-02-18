package com.g.city.service.impl;

import com.g.city.domain.entity.UserAuthInfo;
import com.g.city.mapper.UserAuthInfoMapper;
import com.g.city.service.UserAuthService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthServiceImpl implements UserAuthService {
    @Resource
    private UserAuthInfoMapper userAuthInfoMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<UserAuthInfo> userAuthInfo = userAuthInfoMapper.selectByUsername(username);
        if (userAuthInfo.isEmpty()) {
            throw new UsernameNotFoundException("Username: " + username + "was not found!");
        }
        return User.builder()
                .username(userAuthInfo.get().getUsername())
                .password(userAuthInfo.get().getPassword())
                .roles("USER")
                .build();
    }
}
