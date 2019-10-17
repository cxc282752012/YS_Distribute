package com.purchase.mapper;

import com.purchase.entity.PurchaseOrderMasterEntity;

import java.util.List;
import java.util.Map;

public interface PurchaseOrderMasterMapper {

    List<PurchaseOrderMasterEntity> findList(Map<String, Object> params);

    PurchaseOrderMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(PurchaseOrderMasterEntity purchaseOrderMasterEntity);

    Integer doUpdate(PurchaseOrderMasterEntity purchaseOrderMasterEntity);

    Integer doDelete(int purchaseId);
}