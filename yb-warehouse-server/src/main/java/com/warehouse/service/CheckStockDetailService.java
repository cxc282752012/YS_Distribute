package com.warehouse.service;

import com.github.pagehelper.PageHelper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import com.warehouse.entity.CheckStockDetailEntity;
import com.warehouse.mapper.CheckStockDetailMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("checkStockDetailService")
public class CheckStockDetailService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CheckStockDetailService.class);

    @Autowired
    private CheckStockDetailMapper checkStockDetailMapper;

    /**
     * find list
     *
     * @param params
     * @param pagerInfo
     * @return
     */
    public ServiceResult<List<CheckStockDetailEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.checkStockDetailMapper, "Property 'checkStockDetailMapper' is required.");
        ServiceResult<List<CheckStockDetailEntity>> result = new ServiceResult<List<CheckStockDetailEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.checkStockDetailMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CheckStockDetailService][findList]：query findList occur exception", e);
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
    public ServiceResult<CheckStockDetailEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.checkStockDetailMapper, "Property 'checkStockDetailMapper' is required.");
        ServiceResult<CheckStockDetailEntity> result = new ServiceResult<CheckStockDetailEntity>();
        try {
            result.setResult(this.checkStockDetailMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CheckStockDetailService][findInfo]：query findInfo by param occur exception", e);
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
    public ServiceResult<Integer> doInsert(CheckStockDetailEntity checkStockDetailEntity) {
        Assert.notNull(this.checkStockDetailMapper, "Property 'checkStockDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.checkStockDetailMapper.doInsert(checkStockDetailEntity);
            if (success > 0) {
                id = checkStockDetailEntity.getCheckStockDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CheckStockDetailService][doInsert]：query doInsert by id occur exception", e);
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
    public ServiceResult<Integer> doUpdate(CheckStockDetailEntity checkStockDetailEntity) {
        Assert.notNull(this.checkStockDetailMapper, "Property 'checkStockDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.checkStockDetailMapper.doUpdate(checkStockDetailEntity);
            if (success > 0) {
                id = checkStockDetailEntity.getCheckStockDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CheckStockDetailService][doUpdate]：query doInsert by id occur exception", e);
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
    public ServiceResult<Boolean> doDelete(int checkStockDetailId) {
        Assert.notNull(this.checkStockDetailMapper, "Property 'checkStockDetailMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.checkStockDetailMapper.doDelete(checkStockDetailId);
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
            LOGGER.error("[CheckStockDetailService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}