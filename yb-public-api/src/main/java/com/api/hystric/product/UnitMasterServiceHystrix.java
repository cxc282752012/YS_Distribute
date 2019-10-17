package com.api.hystric.product;

import com.api.service.product.IUnitMasterService;
import com.product.entity.UnitMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UnitMasterServiceHystrix implements IUnitMasterService {

    @Override
    public ServiceResult<List<UnitMasterEntity>> findList(Map<String, Object> params) throws SystemException {
        throw new SystemException("UnitMaster findList connection error");
    }

    @Override
    public ServiceResult<UnitMasterEntity> findInfo(Map<String, Object> params) throws SystemException {
        throw new SystemException("UnitMaster findInfo connection error");
    }

    @Override
    public ServiceResult<Integer> doInsert(UnitMasterEntity unitMasterEntity) throws SystemException {
        throw new SystemException("UnitMaster doInsert connection error");
    }

    @Override
    public ServiceResult<Integer> doUpdate(UnitMasterEntity unitMasterEntity) throws SystemException {
        throw new SystemException("UnitMaster doUpdate connection error");
    }

    @Override
    public ServiceResult<Boolean> doDelete(int unitId) throws SystemException {
        throw new SystemException("UnitMaster doDelete connection error");
    }
}
