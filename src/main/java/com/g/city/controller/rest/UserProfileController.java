package com.g.city.controller.rest;

import com.g.city.constant.AppConstants;
import com.g.city.controller.result.ApiResult;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({("/" + AppConstants.API_VERSION + "/api/user/profile")})
public class UserProfileController {

    @PostMapping
    public ApiResult<String> profile(Authentication authentication){
        return ApiResult.success("This is User Profile Page...");
    }
}
