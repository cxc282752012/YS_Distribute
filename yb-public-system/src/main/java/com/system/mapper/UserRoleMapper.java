package com.system.mapper;

import com.system.entity.UserRoleEntity;

import java.util.List;
import java.util.Map;

public interface UserRoleMapper {

    List<UserRoleEntity> findList(Map<String, Object> params);

    UserRoleEntity findInfo(Map<String, Object> params);

    Integer doInsert(UserRoleEntity userRoleEntity);

    Integer doUpdate(UserRoleEntity userRoleEntity);

    Integer doDelete(int userRoleId);
}