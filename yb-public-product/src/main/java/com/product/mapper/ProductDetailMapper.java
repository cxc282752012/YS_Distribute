package com.product.mapper;

import com.product.entity.ProductDetailEntity;

import java.util.List;
import java.util.Map;

public interface ProductDetailMapper {

    List<ProductDetailEntity> findList(Map<String, Object> params);

    ProductDetailEntity findInfo(Map<String, Object> params);

    Integer doInsert(ProductDetailEntity productDetailEntity);

    Integer doUpdate(ProductDetailEntity productDetailEntity);

    Integer doDelete(int productDetailId);
}