package com.sales.mapper;

import com.sales.entity.CustomerLevelEntity;

import java.util.List;
import java.util.Map;

public interface CustomerLevelMapper {
    List<CustomerLevelEntity> findList(Map<String, Object> params);

    CustomerLevelEntity findInfo(Map<String, Object> params);

    Integer doInsert(CustomerLevelEntity customerLevelEntity);

    Integer doUpdate(CustomerLevelEntity customerLevelEntity);

    Integer doDelete(int customerLevelId);
}