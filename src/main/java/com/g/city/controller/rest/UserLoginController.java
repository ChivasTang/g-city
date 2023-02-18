package com.g.city.controller.rest;

import com.g.city.constant.AppConstants;
import com.g.city.controller.result.ApiResult;
import com.g.city.controller.result.ResultCode;
import com.g.city.domain.dto.UserLogin;
import com.g.city.service.UserLoginService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({("/" + AppConstants.API_VERSION + "/api/auth/login")})
public class UserLoginController {

    @Resource
    private UserLoginService userLoginService;

    @PostMapping
    @ResponseBody
    public ApiResult<Object> login(@RequestBody UserLogin userLogin) {
        final ResultCode resultCode = userLoginService.login(userLogin);
        return resultCode.getCode() == 100 ? ApiResult.success(resultCode, new UserLogin(userLogin.getUsername())) :
                ApiResult.fail(resultCode);
    }
}
