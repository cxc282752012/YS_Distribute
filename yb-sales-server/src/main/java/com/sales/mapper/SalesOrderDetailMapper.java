package com.sales.mapper;

import com.sales.entity.SalesOrderDetailEntity;

import java.util.List;
import java.util.Map;

public interface SalesOrderDetailMapper {
    List<SalesOrderDetailEntity> findList(Map<String, Object> params);

    SalesOrderDetailEntity findInfo(Map<String, Object> params);

    Integer doInsert(SalesOrderDetailEntity salesOrderDetailEntity);

    Integer doUpdate(SalesOrderDetailEntity salesOrderDetailEntity);

    Integer doDelete(int salesDetailId);
}