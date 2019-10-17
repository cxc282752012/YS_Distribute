package com.product.service;

import com.github.pagehelper.PageHelper;
import com.product.entity.UnitMasterEntity;
import com.product.mapper.UnitMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("unitMasterService")
public class UnitMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UnitMasterService.class);

    @Autowired
    private UnitMasterMapper unitMasterMapper;

    public ServiceResult<List<UnitMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.unitMasterMapper, "Property 'unitMasterMapper' is required.");
        ServiceResult<List<UnitMasterEntity>> result = new ServiceResult<List<UnitMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.unitMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UnitMasterService][findList]：query findList occur exception", e);
        }

        return result;
    }

    public ServiceResult<UnitMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.unitMasterMapper, "Property 'unitMasterMapper' is required.");
        ServiceResult<UnitMasterEntity> result = new ServiceResult<UnitMasterEntity>();
        try {
            result.setResult(this.unitMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UnitMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doInsert(UnitMasterEntity unitMasterEntity) {
        Assert.notNull(this.unitMasterMapper, "Property 'unitMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.unitMasterMapper.doInsert(unitMasterEntity);
            if (success > 0) {
                id = unitMasterEntity.getUnitId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UnitMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doUpdate(UnitMasterEntity unitMasterEntity) {
        Assert.notNull(this.unitMasterMapper, "Property 'unitMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.unitMasterMapper.doUpdate(unitMasterEntity);
            if (success > 0) {
                id = unitMasterEntity.getUnitId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UnitMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Boolean> doDelete(int unitId) {
        Assert.notNull(this.unitMasterMapper, "Property 'unitMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.unitMasterMapper.doDelete(unitId);
            if (id > 0) {
                flag = true;
            }
            result.setResult(flag);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UnitMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }

}