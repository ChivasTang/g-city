package com.g.city.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {

    private Date createTime;

    private String updateUserId;

    private Date updateTime;

    private Short deleted;
}
