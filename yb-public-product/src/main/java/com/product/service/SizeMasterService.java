package com.product.service;

import com.github.pagehelper.PageHelper;
import com.product.entity.SizeMasterEntity;
import com.product.mapper.SizeMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("sizeMasterService")
public class SizeMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SizeMasterService.class);

    @Autowired
    private SizeMasterMapper sizeMasterMapper;

    public ServiceResult<List<SizeMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.sizeMasterMapper, "Property 'sizeMasterMapper' is required.");
        ServiceResult<List<SizeMasterEntity>> result = new ServiceResult<List<SizeMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.sizeMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SizeMasterService][findList]：query findList occur exception", e);
        }

        return result;
    }

    public ServiceResult<SizeMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.sizeMasterMapper, "Property 'sizeMasterMapper' is required.");
        ServiceResult<SizeMasterEntity> result = new ServiceResult<SizeMasterEntity>();
        try {
            result.setResult(this.sizeMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SizeMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doInsert(SizeMasterEntity sizeMasterEntity) {
        Assert.notNull(this.sizeMasterMapper, "Property 'sizeMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.sizeMasterMapper.doInsert(sizeMasterEntity);
            if (success > 0) {
                id = sizeMasterEntity.getSizeId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SizeMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doUpdate(SizeMasterEntity sizeMasterEntity) {
        Assert.notNull(this.sizeMasterMapper, "Property 'sizeMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.sizeMasterMapper.doUpdate(sizeMasterEntity);
            if (success > 0) {
                id = sizeMasterEntity.getSizeId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SizeMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Boolean> doDelete(int sizeId) {
        Assert.notNull(this.sizeMasterMapper, "Property 'sizeMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.sizeMasterMapper.doDelete(sizeId);
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
            LOGGER.error("[SizeMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }

}