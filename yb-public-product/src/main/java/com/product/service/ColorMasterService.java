package com.product.service;

import com.github.pagehelper.PageHelper;
import com.product.entity.ColorMasterEntity;
import com.product.mapper.ColorMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("colorMasterService")
public class ColorMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ColorMasterService.class);

    @Autowired
    private ColorMasterMapper colorMasterMapper;

    public ServiceResult<List<ColorMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.colorMasterMapper, "Property 'colorMasterMapper' is required.");
        ServiceResult<List<ColorMasterEntity>> result = new ServiceResult<List<ColorMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.colorMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ColorMasterService][findList]：query findList occur exception", e);
        }

        return result;
    }

    public ServiceResult<ColorMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.colorMasterMapper, "Property 'colorMasterMapper' is required.");
        ServiceResult<ColorMasterEntity> result = new ServiceResult<ColorMasterEntity>();
        try {
            result.setResult(this.colorMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ColorMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doInsert(ColorMasterEntity colorMasterEntity) {
        Assert.notNull(this.colorMasterMapper, "Property 'colorMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.colorMasterMapper.doInsert(colorMasterEntity);
            if (success > 0) {
                id = colorMasterEntity.getColorId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ColorMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doUpdate(ColorMasterEntity colorMasterEntity) {
        Assert.notNull(this.colorMasterMapper, "Property 'colorMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.colorMasterMapper.doUpdate(colorMasterEntity);
            if (success > 0) {
                id = colorMasterEntity.getColorId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[ColorMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Boolean> doDelete(int colorId) {
        Assert.notNull(this.colorMasterMapper, "Property 'colorMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.colorMasterMapper.doDelete(colorId);
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
            LOGGER.error("[ColorMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }

}