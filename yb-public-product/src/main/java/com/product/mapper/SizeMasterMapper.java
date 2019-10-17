package com.product.mapper;

import com.product.entity.SizeMasterEntity;

import java.util.List;
import java.util.Map;

public interface SizeMasterMapper {
    List<SizeMasterEntity> findList(Map<String, Object> params);

    SizeMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(SizeMasterEntity sizeMasterEntity);

    Integer doUpdate(SizeMasterEntity sizeMasterEntity);

    Integer doDelete(int sizeId);
}