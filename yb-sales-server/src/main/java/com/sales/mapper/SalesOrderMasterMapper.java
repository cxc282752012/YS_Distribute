package com.sales.mapper;

import com.sales.entity.SalesOrderMasterEntity;

import java.util.List;
import java.util.Map;

public interface SalesOrderMasterMapper {
    List<SalesOrderMasterEntity> findList(Map<String, Object> params);

    SalesOrderMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(SalesOrderMasterEntity salesOrderMasterEntity);

    Integer doUpdate(SalesOrderMasterEntity salesOrderMasterEntity);

    Integer doDelete(int salesOrderId);
}