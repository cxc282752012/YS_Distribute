package com.sales.mapper;

import com.sales.entity.SalesPlanDetailEntity;

import java.util.List;
import java.util.Map;

public interface SalesPlanDetailMapper {
    List<SalesPlanDetailEntity> findList(Map<String, Object> params);

    SalesPlanDetailEntity findInfo(Map<String, Object> params);

    Integer doInsert(SalesPlanDetailEntity salesPlanDetailEntity);

    Integer doUpdate(SalesPlanDetailEntity salesPlanDetailEntity);

    Integer doDelete(int salesPlanDetailId);
}