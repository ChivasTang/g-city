package com.g.city.controller.rest;

import com.g.city.controller.result.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping({"/",""})
    public ApiResult<Object> index(){
        return ApiResult.success("This is index page...");
    }
}
