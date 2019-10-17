package com.warehouse.mapper;

import com.warehouse.entity.InStockMasterEntity;

import java.util.List;
import java.util.Map;

public interface InStockMasterMapper {
    List<InStockMasterEntity> findList(Map<String, Object> params);

    InStockMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(InStockMasterEntity inStockMasterEntity);

    Integer doUpdate(InStockMasterEntity inStockMasterEntity);

    Integer doDelete(int inStockId);
}