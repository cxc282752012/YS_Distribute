package com.system.mapper;

import com.system.entity.UserRolePermissionEntity;

import java.util.List;
import java.util.Map;

public interface UserRolePermissionMapper {

    List<UserRolePermissionEntity> findList(Map<String, Object> params);

    UserRolePermissionEntity findInfo(Map<String, Object> params);

    Integer doInsert(UserRolePermissionEntity userRolePermissionEntity);

    Integer doUpdate(UserRolePermissionEntity userRolePermissionEntity);

    Integer doDelete(int rolePermissionId);
}