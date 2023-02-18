package com.g.city.constant;

import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class AppConstants {
    public static final String API_VERSION = "v1";
    public static final AntPathRequestMatcher LOGIN_MATCHER =
            AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/" + API_VERSION + "/api/auth/login");
    public static final AntPathRequestMatcher REGISTER_MATCHER =
            AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/" + API_VERSION + "/api/auth/register");

    public static final AntPathRequestMatcher INDEX_MATCHER =
            AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/");
}
