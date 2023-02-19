package com.g.city.domain.dto;

import lombok.*;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserLogin extends BaseDTO {
    @Serial
    private static final long serialVersionUID = 7951159580098257900L;
    private String userId;
    private String username;
    private String password;
    private String token;
}
