package com.g.city.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserAuthInfo extends BaseEntity{
    private String userId;

    private String username;

    private String password;

    public UserAuthInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}