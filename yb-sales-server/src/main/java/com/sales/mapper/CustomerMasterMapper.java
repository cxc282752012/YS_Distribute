package com.sales.mapper;

import com.sales.entity.CustomerMasterEntity;

import java.util.List;
import java.util.Map;

public interface CustomerMasterMapper {
    List<CustomerMasterEntity> findList(Map<String, Object> params);

    CustomerMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(CustomerMasterEntity customerMasterEntity);

    Integer doUpdate(CustomerMasterEntity customerMasterEntity);

    Integer doDelete(int customerId);
}