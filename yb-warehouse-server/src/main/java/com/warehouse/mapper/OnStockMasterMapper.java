package com.warehouse.mapper;

import com.warehouse.entity.OnStockMasterEntity;

import java.util.List;
import java.util.Map;

public interface OnStockMasterMapper {
    List<OnStockMasterEntity> findList(Map<String, Object> params);

    OnStockMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(OnStockMasterEntity onStockMasterEntity);

    Integer doUpdate(OnStockMasterEntity onStockMasterEntity);

    Integer doDelete(int onStockId);
}