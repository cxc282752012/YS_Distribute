package com.system.mapper;

import com.system.entity.UserMasterEntity;

import java.util.List;
import java.util.Map;

public interface UserMasterMapper {

    List<UserMasterEntity> findList(Map<String, Object> params);

    UserMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(UserMasterEntity userMasterEntity);

    Integer doUpdate(UserMasterEntity userMasterEntity);

    Integer doDelete(int userId);
}