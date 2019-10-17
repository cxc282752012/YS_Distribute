package com.api.hystric.product;

import com.api.service.product.ISizeMasterService;
import com.product.entity.SizeMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SizeMasterServiceHystrix implements ISizeMasterService {

    @Override
    public ServiceResult<List<SizeMasterEntity>> findList(Map<String, Object> params) throws SystemException {
        throw new SystemException("ColorMaster findList connection error");
    }

    @Override
    public ServiceResult<SizeMasterEntity> findInfo(Map<String, Object> params) throws SystemException {
        throw new SystemException("ColorMaster findInfo connection error");
    }

    @Override
    public ServiceResult<Integer> doInsert(SizeMasterEntity sizeMasterEntity) throws SystemException {
        throw new SystemException("ColorMaster doInsert connection error");
    }

    @Override
    public ServiceResult<Integer> doUpdate(SizeMasterEntity sizeMasterEntity) throws SystemException {
        throw new SystemException("ColorMaster doUpdate connection error");
    }

    @Override
    public ServiceResult<Boolean> doDelete(int sizeId) throws SystemException {
        throw new SystemException("ColorMaster doDelete connection error");
    }

}
