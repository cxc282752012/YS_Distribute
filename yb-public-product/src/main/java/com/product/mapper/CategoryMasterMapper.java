package com.product.mapper;

import com.product.entity.CategoryMasterEntity;

import java.util.List;
import java.util.Map;

public interface CategoryMasterMapper {
    List<CategoryMasterEntity> findList(Map<String, Object> params);

    CategoryMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(CategoryMasterEntity categoryMasterEntity);

    Integer doUpdate(CategoryMasterEntity categoryMasterEntity);

    Integer doDelete(int categoryId);
}