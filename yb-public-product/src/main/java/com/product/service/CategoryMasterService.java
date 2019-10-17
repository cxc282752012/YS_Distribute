package com.product.service;

import com.github.pagehelper.PageHelper;
import com.product.entity.CategoryMasterEntity;
import com.product.mapper.CategoryMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("categoryMasterService")
public class CategoryMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoryMasterService.class);

    @Autowired
    private CategoryMasterMapper categoryMasterMapper;

    public ServiceResult<List<CategoryMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.categoryMasterMapper, "Property 'categoryMasterMapper' is required.");
        ServiceResult<List<CategoryMasterEntity>> result = new ServiceResult<List<CategoryMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.categoryMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CategoryMasterService][findList]：query findList occur exception", e);
        }

        return result;
    }

    public ServiceResult<CategoryMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.categoryMasterMapper, "Property 'categoryMasterMapper' is required.");
        ServiceResult<CategoryMasterEntity> result = new ServiceResult<CategoryMasterEntity>();
        try {
            result.setResult(this.categoryMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CategoryMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doInsert(CategoryMasterEntity categoryMasterEntity) {
        Assert.notNull(this.categoryMasterMapper, "Property 'categoryMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.categoryMasterMapper.doInsert(categoryMasterEntity);
            if (success > 0) {
                id = categoryMasterEntity.getCategoryId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CategoryMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doUpdate(CategoryMasterEntity categoryMasterEntity) {
        Assert.notNull(this.categoryMasterMapper, "Property 'categoryMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.categoryMasterMapper.doUpdate(categoryMasterEntity);
            if (success > 0) {
                id = categoryMasterEntity.getCategoryId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CategoryMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Boolean> doDelete(int categoryId) {
        Assert.notNull(this.categoryMasterMapper, "Property 'categoryMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.categoryMasterMapper.doDelete(categoryId);
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
            LOGGER.error("[CategoryMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }

}