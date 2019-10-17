package com.product.service;

import com.github.pagehelper.PageHelper;
import com.product.entity.ProductImageEntity;
import com.product.mapper.ProductImageMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("productImageService")
public class ProductImageService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductImageService.class);

    @Autowired
    private ProductImageMapper productImageMapper;

    public ServiceResult<List<ProductImageEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.productImageMapper, "Property 'productImageMapper' is required.");
        ServiceResult<List<ProductImageEntity>> result = new ServiceResult<List<ProductImageEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.productImageMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductImageService][findList]：query findList occur exception", e);
        }
        return result;
    }

    public ServiceResult<ProductImageEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.productImageMapper, "Property 'productImageMapper' is required.");
        ServiceResult<ProductImageEntity> result = new ServiceResult<ProductImageEntity>();
        try {
            result.setResult(this.productImageMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductImageService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doInsert(ProductImageEntity productImageEntity) {
        Assert.notNull(this.productImageMapper, "Property 'productImageMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.productImageMapper.doInsert(productImageEntity);
            if (success > 0) {
                id = productImageEntity.getProductImageId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductImageService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doUpdate(ProductImageEntity productImageEntity) {
        Assert.notNull(this.productImageMapper, "Property 'productImageMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.productImageMapper.doUpdate(productImageEntity);
            if (success > 0) {
                id = productImageEntity.getProductImageId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductImageService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Boolean> doDelete(int productImageId) {
        Assert.notNull(this.productImageMapper, "Property 'productImageMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.productImageMapper.doDelete(productImageId);
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
            LOGGER.error("[ProductImageService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}