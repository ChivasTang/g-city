package com.g.city.controller.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     * 操作成功
     **/
    RC100(100, "操作成功"),
    /**
     * 操作失败
     **/
    RC999(999, "操作失败"),
    /**
     * 服务限流
     **/
    RC200(200, "服务开启限流保护,请稍后再试!"),
    /**
     * 服务降级
     **/
    RC201(201, "服务开启降级保护,请稍后再试!"),
    /**
     * 热点参数限流
     **/
    RC202(202, "热点参数限流,请稍后再试!"),
    /**
     * 系统规则不满足
     **/
    RC203(203, "系统规则不满足要求,请稍后再试!"),
    /**
     * 授权规则不通过
     **/
    RC204(204, "授权规则不通过,请稍后再试!"),
    /**
     * access_denied
     **/
    RC403(403, "无访问权限,请联系管理员授予权限"),
    /**
     * access_denied
     **/
    RC401(401, "匿名用户访问无权限资源时的异常"),
    /**
     * 服务异常
     **/
    RC500(500, "系统异常，请稍后重试"),

    INVALID_TOKEN(2001, "访问令牌不合法"),
    ACCESS_DENIED(2003, "没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED(1001, "客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002, "用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式"),


    LOGIN_SUCCESS(100, "登陆成功。"),
    LOGIN_FAILED_USERNAME_NOT_INPUT(2101, "请输入用户名。"),
    LOGIN_FAILED_PASSWORD_NOT_INPUT(2102, "请输入密码。"),
    LOGIN_FAILED_USERNAME_NOT_EXIST(2103, "未找到该用户，请检查并重新输入。"),
    LOGIN_FAILED_USERNAME_PASSWORD_NOT_VALIDATED(2104, "用户名和密码不匹配，请检查并重新输入。"),

    REGISTER_SUCCESS(100, "用户注册成功。"),
    REGISTER_FAILED_USERNAME_NOT_INPUT(2111, "请填写用户名。"),
    REGISTER_FAILED_PASSWORD_NOT_INPUT(2112, "请填写密码。"),
    REGISTER_FAILED_PASSWORD_NOT_CONFIRMED(2113, "密码不一致。"),
    REGISTER_FAILED_USERNAME_EXISTED(2114, "该用户已经存在。");


    private final int code;
    private final String message;
}
