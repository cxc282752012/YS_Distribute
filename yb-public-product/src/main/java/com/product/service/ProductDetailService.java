package com.product.service;

import com.github.pagehelper.PageHelper;
import com.product.entity.ProductDetailEntity;
import com.product.mapper.ProductDetailMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("productDetailService")
public class ProductDetailService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductDetailService.class);

    @Autowired
    private ProductDetailMapper productDetailMapper;

    public ServiceResult<List<ProductDetailEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.productDetailMapper, "Property 'productDetailMapper' is required.");
        ServiceResult<List<ProductDetailEntity>> result = new ServiceResult<List<ProductDetailEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.productDetailMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductDetailService][findList]：query findList occur exception", e);
        }
        return result;
    }

    public ServiceResult<ProductDetailEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.productDetailMapper, "Property 'productDetailMapper' is required.");
        ServiceResult<ProductDetailEntity> result = new ServiceResult<ProductDetailEntity>();
        try {
            result.setResult(this.productDetailMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductDetailService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doInsert(ProductDetailEntity productDetailEntity) {
        Assert.notNull(this.productDetailMapper, "Property 'productDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.productDetailMapper.doInsert(productDetailEntity);
            if (success > 0) {
                id = productDetailEntity.getProductDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductDetailService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doUpdate(ProductDetailEntity productDetailEntity) {
        Assert.notNull(this.productDetailMapper, "Property 'productDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.productDetailMapper.doUpdate(productDetailEntity);
            if (success > 0) {
                id = productDetailEntity.getProductDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ProductDetailService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Boolean> doDelete(int productDetailId) {
        Assert.notNull(this.productDetailMapper, "Property 'productDetailMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.productDetailMapper.doDelete(productDetailId);
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
            LOGGER.error("[ProductDetailService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}