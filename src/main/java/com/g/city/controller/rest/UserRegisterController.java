package com.g.city.controller.rest;

import com.g.city.constant.AppConstants;
import com.g.city.controller.result.ApiResult;
import com.g.city.controller.result.ResultCode;
import com.g.city.domain.dto.UserRegister;
import com.g.city.service.UserRegisterService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({("/" + AppConstants.API_VERSION + "/api/auth/register")})
public class UserRegisterController {

    @Resource
    private UserRegisterService userRegisterService;

    @PostMapping
    @ResponseBody
    public ApiResult<Object> register(@RequestBody UserRegister userRegister) {
        final ResultCode resultCode = userRegisterService.register(userRegister);
        if (resultCode.getCode() == 100) {
            UserRegister register = new UserRegister();
            register.setUsername(userRegister.getUsername());
            return ApiResult.success(resultCode, register);
        }
        return ApiResult.fail(resultCode);
    }
}
