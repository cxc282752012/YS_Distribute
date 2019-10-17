package com.system.mapper;

import com.system.entity.UserPermissionEntity;

import java.util.List;
import java.util.Map;

public interface UserPermissionMapper {

    List<UserPermissionEntity> findList(Map<String, Object> params);

    UserPermissionEntity findInfo(Map<String, Object> params);

    Integer doInsert(UserPermissionEntity userPermissionEntity);

    Integer doUpdate(UserPermissionEntity userPermissionEntity);

    Integer doDelete(int permissionId);
}