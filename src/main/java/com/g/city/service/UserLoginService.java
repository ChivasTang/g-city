package com.g.city.service;

import com.g.city.controller.result.ResultCode;
import com.g.city.domain.dto.UserLogin;

public interface UserLoginService {
    ResultCode login(UserLogin userLogin);
}
