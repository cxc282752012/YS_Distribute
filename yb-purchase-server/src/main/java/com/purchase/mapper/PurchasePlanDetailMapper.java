package com.purchase.mapper;

import com.purchase.entity.PurchasePlanDetailEntity;

import java.util.List;
import java.util.Map;

public interface PurchasePlanDetailMapper {

    List<PurchasePlanDetailEntity> findList(Map<String, Object> params);

    PurchasePlanDetailEntity findInfo(Map<String, Object> params);

    Integer doInsert(PurchasePlanDetailEntity purchasePlanDetailEntity);

    Integer doUpdate(PurchasePlanDetailEntity purchasePlanDetailEntity);

    Integer doDelete(int purchasePlanDetailId);
}