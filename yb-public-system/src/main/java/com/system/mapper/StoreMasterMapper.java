package com.system.mapper;

import com.system.entity.StoreMasterEntity;

import java.util.List;
import java.util.Map;

public interface StoreMasterMapper {

    List<StoreMasterEntity> findList(Map<String, Object> params);

    StoreMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(StoreMasterEntity storeMasterEntity);

    Integer doUpdate(StoreMasterEntity storeMasterEntity);

    Integer doDelete(int storeId);
}