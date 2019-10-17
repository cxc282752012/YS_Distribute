package com.purchase.mapper;

import com.purchase.entity.SupplierMasterEntity;

import java.util.List;
import java.util.Map;

public interface SupplierMasterMapper {

    List<SupplierMasterEntity> findList(Map<String, Object> params);

    SupplierMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(SupplierMasterEntity supplierMasterEntity);

    Integer doUpdate(SupplierMasterEntity supplierMasterEntity);

    Integer doDelete(int supplierId);
}