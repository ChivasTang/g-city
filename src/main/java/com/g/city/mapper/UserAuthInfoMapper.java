package com.g.city.mapper;

import com.g.city.domain.entity.UserAuthInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserAuthInfoMapper {

    Optional<UserAuthInfo> selectByUsername(String username);

    void insert(UserAuthInfo userAuthInfo);
}
