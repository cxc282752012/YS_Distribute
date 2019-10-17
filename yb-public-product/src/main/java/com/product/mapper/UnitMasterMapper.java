package com.product.mapper;

import com.product.entity.UnitMasterEntity;

import java.util.List;
import java.util.Map;

public interface UnitMasterMapper {
    List<UnitMasterEntity> findList(Map<String, Object> params);

    UnitMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(UnitMasterEntity unitMasterEntity);

    Integer doUpdate(UnitMasterEntity unitMasterEntity);

    Integer doDelete(int unitId);
}