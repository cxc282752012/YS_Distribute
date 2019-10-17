package com.product.mapper;

import com.product.entity.ColorMasterEntity;

import java.util.List;
import java.util.Map;

public interface ColorMasterMapper {
    List<ColorMasterEntity> findList(Map<String, Object> params);

    ColorMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(ColorMasterEntity colorMasterEntity);

    Integer doUpdate(ColorMasterEntity colorMasterEntity);

    Integer doDelete(int colorId);
}