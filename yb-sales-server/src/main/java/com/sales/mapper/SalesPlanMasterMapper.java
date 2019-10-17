package com.sales.mapper;

import com.sales.entity.SalesPlanMasterEntity;

import java.util.List;
import java.util.Map;

public interface SalesPlanMasterMapper {
    List<SalesPlanMasterEntity> findList(Map<String, Object> params);

    SalesPlanMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(SalesPlanMasterEntity salesPlanMasterEntity);

    Integer doUpdate(SalesPlanMasterEntity salesPlanMasterEntity);

    Integer doDelete(int salesPlanId);
}