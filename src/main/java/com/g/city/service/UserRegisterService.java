package com.g.city.service;

import com.g.city.controller.result.ResultCode;
import com.g.city.domain.dto.UserRegister;

public interface UserRegisterService {
    ResultCode register(UserRegister userRegister);
}
