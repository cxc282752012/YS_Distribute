package com.product.mapper;

import com.product.entity.ProductMasterEntity;

import java.util.List;
import java.util.Map;

public interface ProductMasterMapper {

    List<ProductMasterEntity> findList(Map<String, Object> params);

    ProductMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(ProductMasterEntity productMasterEntity);

    Integer doUpdate(ProductMasterEntity productMasterEntity);

    Integer doDelete(int userId);
}