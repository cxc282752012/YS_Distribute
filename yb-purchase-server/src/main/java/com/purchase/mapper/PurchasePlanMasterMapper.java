package com.purchase.mapper;

import com.purchase.entity.PurchasePlanMasterEntity;

import java.util.List;
import java.util.Map;

public interface PurchasePlanMasterMapper {

    List<PurchasePlanMasterEntity> findList(Map<String, Object> params);

    PurchasePlanMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(PurchasePlanMasterEntity purchasePlanMasterEntity);

    Integer doUpdate(PurchasePlanMasterEntity purchasePlanMasterEntity);

    Integer doDelete(int purchasePlanId);
}