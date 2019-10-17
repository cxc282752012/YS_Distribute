package com.api.hystric.product;

import com.api.service.product.IColorMasterService;
import com.product.entity.ColorMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ColorMasterServiceHystrix implements IColorMasterService {

    @Override
    public ServiceResult<List<ColorMasterEntity>> findList(Map<String, Object> params) throws SystemException {
        throw new SystemException("ColorMaster findList connection error");
    }

    @Override
    public ServiceResult<ColorMasterEntity> findInfo(Map<String, Object> params) throws SystemException {
        throw new SystemException("ColorMaster findInfo connection error");
    }

    @Override
    public ServiceResult<Integer> doInsert(ColorMasterEntity colorMasterEntity) throws SystemException {
        throw new SystemException("ColorMaster doInsert connection error");
    }

    @Override
    public ServiceResult<Integer> doUpdate(ColorMasterEntity colorMasterEntity) throws SystemException {
        throw new SystemException("ColorMaster doUpdate connection error");
    }

    @Override
    public ServiceResult<Boolean> doDelete(int colorId) throws SystemException {
        throw new SystemException("ColorMaster doDelete connection error");
    }
}
