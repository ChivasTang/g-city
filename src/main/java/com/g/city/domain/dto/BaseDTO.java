package com.g.city.domain.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2203497589820366564L;

    private String createUserId;

    private Long createTime;

    private String updateUserId;

    private Long updateTime;

    private Short deleted;
}
