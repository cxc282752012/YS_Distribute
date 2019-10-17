package com.api.hystric.product;

import com.api.service.product.IBrandMasterService;
import com.product.entity.BrandMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BrandMasterServiceHystrix implements IBrandMasterService {

    @Override
    public ServiceResult<List<BrandMasterEntity>> findList(Map<String, Object> params) throws SystemException {
        throw new SystemException("ColorMaster findList connection error");
    }

    @Override
    public ServiceResult<BrandMasterEntity> findInfo(Map<String, Object> params) throws SystemException {
        throw new SystemException("ColorMaster findInfo connection error");
    }

    @Override
    public ServiceResult<Integer> doInsert(BrandMasterEntity brandMasterEntity) throws SystemException {
        throw new SystemException("ColorMaster doInsert connection error");
    }

    @Override
    public ServiceResult<Integer> doUpdate(BrandMasterEntity brandMasterEntity) throws SystemException {
        throw new SystemException("ColorMaster doUpdate connection error");
    }

    @Override
    public ServiceResult<Boolean> doDelete(int brandId) throws SystemException {
        throw new SystemException("ColorMaster doDelete connection error");
    }
}
