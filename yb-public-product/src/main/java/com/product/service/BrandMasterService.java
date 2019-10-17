package com.product.service;

import com.github.pagehelper.PageHelper;
import com.product.entity.BrandMasterEntity;
import com.product.mapper.BrandMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("brandMasterService")
public class BrandMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BrandMasterService.class);

    @Autowired
    private BrandMasterMapper brandMasterMapper;

    public ServiceResult<List<BrandMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.brandMasterMapper, "Property 'brandMasterMapper' is required.");
        ServiceResult<List<BrandMasterEntity>> result = new ServiceResult<List<BrandMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.brandMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BrandMasterService][findList]：query findList occur exception", e);
        }

        return result;
    }

    public ServiceResult<BrandMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.brandMasterMapper, "Property 'brandMasterMapper' is required.");
        ServiceResult<BrandMasterEntity> result = new ServiceResult<BrandMasterEntity>();
        try {
            result.setResult(this.brandMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BrandMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doInsert(BrandMasterEntity brandMasterEntity) {
        Assert.notNull(this.brandMasterMapper, "Property 'brandMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.brandMasterMapper.doInsert(brandMasterEntity);
            if (success > 0) {
                id = brandMasterEntity.getBrandId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BrandMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doUpdate(BrandMasterEntity brandMasterEntity) {
        Assert.notNull(this.brandMasterMapper, "Property 'brandMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.brandMasterMapper.doUpdate(brandMasterEntity);
            if (success > 0) {
                id = brandMasterEntity.getBrandId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BrandMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Boolean> doDelete(int brandId) {
        Assert.notNull(this.brandMasterMapper, "Property 'brandMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.brandMasterMapper.doDelete(brandId);
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
            LOGGER.error("[BrandMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }

}