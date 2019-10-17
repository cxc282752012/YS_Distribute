package com.api.hystric.product;

import com.api.service.product.ICategoryMasterService;
import com.product.entity.CategoryMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
public class CategoryMasterServiceHystrix implements ICategoryMasterService {

    @Override
    public ServiceResult<List<CategoryMasterEntity>> findList(@RequestParam Map<String, Object> params)
            throws SystemException {
        throw new SystemException("CategoryMaster findList connection error");
    }

    @Override
    public ServiceResult<CategoryMasterEntity> findInfo(@RequestParam Map<String, Object> params)
            throws SystemException {
        throw new SystemException("CategoryMaster findInfo connection error");
    }

    @Override
    public ServiceResult<Integer> doInsert(@RequestBody CategoryMasterEntity categoryMasterEntity)
            throws SystemException {
        throw new SystemException("CategoryMaster doInsert connection error");
    }

    @Override
    public ServiceResult<Integer> doUpdate(@RequestBody CategoryMasterEntity categoryMasterEntity)
            throws SystemException {
        throw new SystemException("CategoryMaster doUpdate connection error");
    }

    @Override
    public ServiceResult<Boolean> doDelete(@RequestParam("categoryId") int categoryId) throws SystemException {
        throw new SystemException("CategoryMaster doDelete connection error");
    }

}
