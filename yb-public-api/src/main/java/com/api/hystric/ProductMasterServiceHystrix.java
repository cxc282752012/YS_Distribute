package com.api.hystric;

import com.api.service.IProductMasterService;
import com.product.entity.ProductMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
public class ProductMasterServiceHystrix implements IProductMasterService {

    @Override
    public ServiceResult<List<ProductMasterEntity>> findList(@RequestParam Map<String, Object> params)
            throws SystemException {
        throw new SystemException("ProductMaster findList connection error");
    }

    @Override
    public ServiceResult<ProductMasterEntity> findInfo(@RequestParam Map<String, Object> params)
            throws SystemException {
        throw new SystemException("ProductMaster findInfo connection error");
    }

    @Override
    public ServiceResult<Integer> doInsert(@RequestBody ProductMasterEntity productMasterEntity)
            throws SystemException {
        throw new SystemException("ProductMaster doInsert connection error");
    }

    @Override
    public ServiceResult<Integer> doUpdate(@RequestBody ProductMasterEntity productMasterEntity)
            throws SystemException {
        throw new SystemException("ProductMaster doUpdate connection error");
    }

    @Override
    public ServiceResult<Boolean> doDelete(@RequestParam("productId") int productId) throws SystemException {
        throw new SystemException("ProductMaster doDelete connection error");
    }

}
