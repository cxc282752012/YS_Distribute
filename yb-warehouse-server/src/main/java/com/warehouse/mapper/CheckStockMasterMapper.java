package com.warehouse.mapper;

import com.warehouse.entity.CheckStockMasterEntity;

import java.util.List;
import java.util.Map;

public interface CheckStockMasterMapper {
    List<CheckStockMasterEntity> findList(Map<String, Object> params);

    CheckStockMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(CheckStockMasterEntity checkStockMasterEntity);

    Integer doUpdate(CheckStockMasterEntity checkStockMasterEntity);

    Integer doDelete(int checkStockId);
}