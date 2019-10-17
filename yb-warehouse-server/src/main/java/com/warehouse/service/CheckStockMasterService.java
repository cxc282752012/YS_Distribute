package com.warehouse.service;

import com.github.pagehelper.PageHelper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import com.warehouse.entity.CheckStockMasterEntity;
import com.warehouse.mapper.CheckStockMasterMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("checkStockMasterService")
public class CheckStockMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CheckStockMasterService.class);

    @Autowired
    private CheckStockMasterMapper checkStockMasterMapper;

    /**
     * find list
     *
     * @param params
     * @param pagerInfo
     * @return
     */
    public ServiceResult<List<CheckStockMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.checkStockMasterMapper, "Property 'checkStockMasterMapper' is required.");
        ServiceResult<List<CheckStockMasterEntity>> result = new ServiceResult<List<CheckStockMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.checkStockMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CheckStockMasterService][findList]：query findList occur exception", e);
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
    public ServiceResult<CheckStockMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.checkStockMasterMapper, "Property 'checkStockMasterMapper' is required.");
        ServiceResult<CheckStockMasterEntity> result = new ServiceResult<CheckStockMasterEntity>();
        try {
            result.setResult(this.checkStockMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CheckStockMasterService][findInfo]：query findInfo by param occur exception", e);
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
    public ServiceResult<Integer> doInsert(CheckStockMasterEntity checkStockMasterEntity) {
        Assert.notNull(this.checkStockMasterMapper, "Property 'checkStockMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.checkStockMasterMapper.doInsert(checkStockMasterEntity);
            if (success > 0) {
                id = checkStockMasterEntity.getCheckStockId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CheckStockMasterService][doInsert]：query doInsert by id occur exception", e);
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
    public ServiceResult<Integer> doUpdate(CheckStockMasterEntity checkStockMasterEntity) {
        Assert.notNull(this.checkStockMasterMapper, "Property 'checkStockMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.checkStockMasterMapper.doUpdate(checkStockMasterEntity);
            if (success > 0) {
                id = checkStockMasterEntity.getCheckStockId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CheckStockMasterService][doUpdate]：query doInsert by id occur exception", e);
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
    public ServiceResult<Boolean> doDelete(int checkStockId) {
        Assert.notNull(this.checkStockMasterMapper, "Property 'checkStockMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.checkStockMasterMapper.doDelete(checkStockId);
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
            LOGGER.error("[CheckStockMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}