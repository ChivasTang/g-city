package com.g.city.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegister extends BaseDTO {
    @Serial
    private static final long serialVersionUID = -3692526472652073449L;

    String username;
    String password;
    String confirm;
}
