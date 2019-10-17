package com.api.hystric.purchase;

import com.api.service.purchase.ISupplierMasterService;
import com.purchase.entity.SupplierMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
public class SupplierMasterServiceHystrix implements ISupplierMasterService {

    @Override
    public ServiceResult<List<SupplierMasterEntity>> findList(@RequestParam Map<String, Object> params)
            throws SystemException {
        throw new SystemException("SupplierMaster findList connection error");
    }

    @Override
    public ServiceResult<SupplierMasterEntity> findInfo(@RequestParam Map<String, Object> params)
            throws SystemException {
        throw new SystemException("SupplierMaster findInfo connection error");
    }

    @Override
    public ServiceResult<Integer> doInsert(@RequestBody SupplierMasterEntity supplierMasterEntity)
            throws SystemException {
        throw new SystemException("SupplierMaster doInsert connection error");
    }

    @Override
    public ServiceResult<Integer> doUpdate(@RequestBody SupplierMasterEntity supplierMasterEntity)
            throws SystemException {
        throw new SystemException("SupplierMaster doUpdate connection error");
    }

    @Override
    public ServiceResult<Boolean> doDelete(@RequestParam("supplierId") int supplierId) throws SystemException {
        throw new SystemException("SupplierMaster doDelete connection error");
    }

}
