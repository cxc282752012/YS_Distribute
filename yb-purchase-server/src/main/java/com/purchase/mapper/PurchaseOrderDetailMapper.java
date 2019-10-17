package com.purchase.mapper;

import com.purchase.entity.PurchaseOrderDetailEntity;

import java.util.List;
import java.util.Map;

public interface PurchaseOrderDetailMapper {

    List<PurchaseOrderDetailEntity> findList(Map<String, Object> params);

    PurchaseOrderDetailEntity findInfo(Map<String, Object> params);

    Integer doInsert(PurchaseOrderDetailEntity purchaseOrderDetailEntity);

    Integer doUpdate(PurchaseOrderDetailEntity purchaseOrderDetailEntity);

    Integer doDelete(int purchaseDetailId);
}