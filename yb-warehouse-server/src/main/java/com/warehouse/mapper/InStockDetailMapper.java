package com.warehouse.mapper;

import com.warehouse.entity.InStockDetailEntity;

import java.util.List;
import java.util.Map;

public interface InStockDetailMapper {
    List<InStockDetailEntity> findList(Map<String, Object> params);

    InStockDetailEntity findInfo(Map<String, Object> params);

    Integer doInsert(InStockDetailEntity inStockDetailEntity);

    Integer doUpdate(InStockDetailEntity inStockDetailEntity);

    Integer doDelete(int inStockDetailId);
}