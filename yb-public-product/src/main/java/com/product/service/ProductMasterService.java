package com.product.service;

import com.github.pagehelper.PageHelper;
import com.product.entity.ProductMasterEntity;
import com.product.mapper.ProductMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("productMasterService")
public class ProductMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductMasterService.class);

    @Autowired
    private ProductMasterMapper productMasterMapper;

    public ServiceResult<List<ProductMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.productMasterMapper, "Property 'productMasterMapper' is required.");
        ServiceResult<List<ProductMasterEntity>> result = new ServiceResult<List<ProductMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.productMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductMasterService][findList]：query findList occur exception", e);
        }
        return result;
    }

    public ServiceResult<ProductMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.productMasterMapper, "Property 'productMasterMapper' is required.");
        ServiceResult<ProductMasterEntity> result = new ServiceResult<ProductMasterEntity>();
        try {
            result.setResult(this.productMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doInsert(ProductMasterEntity productMasterEntity) {
        Assert.notNull(this.productMasterMapper, "Property 'productMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.productMasterMapper.doInsert(productMasterEntity);
            if (success > 0) {
                id = productMasterEntity.getProductId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doUpdate(ProductMasterEntity productMasterEntity) {
        Assert.notNull(this.productMasterMapper, "Property 'productMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.productMasterMapper.doUpdate(productMasterEntity);
            if (success > 0) {
                id = productMasterEntity.getProductId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Boolean> doDelete(int productId) {
        Assert.notNull(this.productMasterMapper, "Property 'productMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.productMasterMapper.doDelete(productId);
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
            LOGGER.error("[ProductMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}