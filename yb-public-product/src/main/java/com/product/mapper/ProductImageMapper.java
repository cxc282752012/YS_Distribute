package com.product.mapper;

import com.product.entity.ProductImageEntity;

import java.util.List;
import java.util.Map;

public interface ProductImageMapper {
    List<ProductImageEntity> findList(Map<String, Object> params);

    ProductImageEntity findInfo(Map<String, Object> params);

    Integer doInsert(ProductImageEntity productImageEntity);

    Integer doUpdate(ProductImageEntity productImageEntity);

    Integer doDelete(int productImageId);
}