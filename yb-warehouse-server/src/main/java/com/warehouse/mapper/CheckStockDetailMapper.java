package com.warehouse.mapper;

import com.warehouse.entity.CheckStockDetailEntity;

import java.util.List;
import java.util.Map;

public interface CheckStockDetailMapper {
    List<CheckStockDetailEntity> findList(Map<String, Object> params);

    CheckStockDetailEntity findInfo(Map<String, Object> params);

    Integer doInsert(CheckStockDetailEntity checkStockDetailEntity);

    Integer doUpdate(CheckStockDetailEntity checkStockDetailEntity);

    Integer doDelete(int checkStockDetailId);
}