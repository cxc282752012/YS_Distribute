package com.system.mapper;

import com.system.entity.BusinessLogEntity;

import java.util.List;
import java.util.Map;

public interface BusinessLogMapper {

    List<BusinessLogEntity> findList(Map<String, Object> params);

    BusinessLogEntity findInfo(Map<String, Object> params);

    Integer doInsert(BusinessLogEntity businessLogEntity);

    Integer doUpdate(BusinessLogEntity businessLogEntity);

    Integer doDelete(int businessLogId);
}