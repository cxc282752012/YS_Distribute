package com.system.mapper;

import com.system.entity.BusinessMasterEntity;

import java.util.List;
import java.util.Map;

public interface BusinessMasterMapper {

    List<BusinessMasterEntity> findList(Map<String, Object> params);

    BusinessMasterEntity findInfo(Map<String, Object> params);

    Integer doInsert(BusinessMasterEntity businessMasterEntity);

    Integer doUpdate(BusinessMasterEntity businessMasterEntity);

    Integer doDelete(int businessId);

}