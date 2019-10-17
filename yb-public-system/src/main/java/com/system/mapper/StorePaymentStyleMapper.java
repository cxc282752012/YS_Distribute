package com.system.mapper;

import com.system.entity.StorePaymentStyleEntity;

import java.util.List;
import java.util.Map;

public interface StorePaymentStyleMapper {

    List<StorePaymentStyleEntity> findList(Map<String, Object> params);

    StorePaymentStyleEntity findInfo(Map<String, Object> params);

    Integer doInsert(StorePaymentStyleEntity storePaymentStyleEntity);

    Integer doUpdate(StorePaymentStyleEntity storePaymentStyleEntity);

    Integer doDelete(int paymentStyleId);
}