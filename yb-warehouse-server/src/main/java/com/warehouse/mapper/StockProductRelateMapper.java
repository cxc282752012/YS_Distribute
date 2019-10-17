package com.warehouse.mapper;

import com.warehouse.entity.StockProductRelateEntity;

import java.util.List;
import java.util.Map;

public interface StockProductRelateMapper {
    List<StockProductRelateEntity> findList(Map<String, Object> params);

    StockProductRelateEntity findInfo(Map<String, Object> params);

    Integer doInsert(StockProductRelateEntity stockProductRelateEntity);

    Integer doUpdate(StockProductRelateEntity stockProductRelateEntity);

    Integer doDelete(int stockProductId);
}