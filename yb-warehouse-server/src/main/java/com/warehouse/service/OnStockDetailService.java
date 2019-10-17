package com.warehouse.service;

import com.github.pagehelper.PageHelper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import com.warehouse.entity.OnStockDetailEntity;
import com.warehouse.mapper.OnStockDetailMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("onStockDetailService")
public class OnStockDetailService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OnStockDetailService.class);

    @Autowired
    private OnStockDetailMapper onStockDetailMapper;

    /**
     * find list
     *
     * @param params
     * @param pagerInfo
     * @return
     */
    public ServiceResult<List<OnStockDetailEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.onStockDetailMapper, "Property 'onStockDetailMapper' is required.");
        ServiceResult<List<OnStockDetailEntity>> result = new ServiceResult<List<OnStockDetailEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.onStockDetailMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[OnStockDetailService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 15:53
     * @Param [params]
     **/
    public ServiceResult<OnStockDetailEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.onStockDetailMapper, "Property 'onStockDetailMapper' is required.");
        ServiceResult<OnStockDetailEntity> result = new ServiceResult<OnStockDetailEntity>();
        try {
            result.setResult(this.onStockDetailMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[OnStockDetailService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 15:54
     * @Param [checkStockDetailEntity]
     **/
    public ServiceResult<Integer> doInsert(OnStockDetailEntity onStockDetailEntity) {
        Assert.notNull(this.onStockDetailMapper, "Property 'onStockDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.onStockDetailMapper.doInsert(onStockDetailEntity);
            if (success > 0) {
                id = onStockDetailEntity.getOnStockDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[OnStockDetailService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 15:54
     * @Param [checkStockDetailEntity]
     **/
    public ServiceResult<Integer> doUpdate(OnStockDetailEntity onStockDetailEntity) {
        Assert.notNull(this.onStockDetailMapper, "Property 'onStockDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.onStockDetailMapper.doUpdate(onStockDetailEntity);
            if (success > 0) {
                id = onStockDetailEntity.getOnStockDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[OnStockDetailService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 15:54
     * @Param [checkStockDetailId]
     **/
    public ServiceResult<Boolean> doDelete(int onStockDetailId) {
        Assert.notNull(this.onStockDetailMapper, "Property 'onStockDetailMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.onStockDetailMapper.doDelete(onStockDetailId);
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
            LOGGER.error("[OnStockDetailService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}