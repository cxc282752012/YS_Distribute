package com.warehouse.mapper;

import com.warehouse.entity.OnStockDetailEntity;

import java.util.List;
import java.util.Map;

public interface OnStockDetailMapper {
    List<OnStockDetailEntity> findList(Map<String, Object> params);

    OnStockDetailEntity findInfo(Map<String, Object> params);

    Integer doInsert(OnStockDetailEntity onStockDetailEntity);

    Integer doUpdate(OnStockDetailEntity onStockDetailEntity);

    Integer doDelete(int onStockDetailId);
}