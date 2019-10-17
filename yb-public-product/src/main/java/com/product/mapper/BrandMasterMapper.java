package com.product.mapper;

import com.product.entity.BrandMasterEntity;

import java.util.List;
import java.util.Map;

public interface BrandMasterMapper {
    List<BrandMasterEntity> findList(Map<String, Object> params);

    BrandMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(BrandMasterEntity brandMasterEntity);

    Integer doUpdate(BrandMasterEntity brandMasterEntity);

    Integer doDelete(int brandId);
}