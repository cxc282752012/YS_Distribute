package com.sales.service;

import com.github.pagehelper.PageHelper;
import com.sales.entity.SalesOrderMasterEntity;
import com.sales.mapper.SalesOrderMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("salesOrderMasterService")
public class SalesOrderMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SalesOrderMasterService.class);

    @Autowired
    private SalesOrderMasterMapper salesOrderMasterMapper;

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<SalesOrderMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.salesOrderMasterMapper, "Property 'salesOrderMasterMapper' is required.");
        ServiceResult<List<SalesOrderMasterEntity>> result = new ServiceResult<List<SalesOrderMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.salesOrderMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesOrderMasterService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [params]
     **/
    public ServiceResult<SalesOrderMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.salesOrderMasterMapper, "Property 'salesOrderMasterMapper' is required.");
        ServiceResult<SalesOrderMasterEntity> result = new ServiceResult<SalesOrderMasterEntity>();
        try {
            result.setResult(this.salesOrderMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesOrderMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:57
     * @Param [salesOrderMasterEntity]
     **/
    public ServiceResult<Integer> doInsert(SalesOrderMasterEntity salesOrderMasterEntity) {
        Assert.notNull(this.salesOrderMasterMapper, "Property 'salesOrderMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.salesOrderMasterMapper.doInsert(salesOrderMasterEntity);
            if (success > 0) {
                id = salesOrderMasterEntity.getSalesOrderId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesOrderMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:57
     * @Param [salesOrderMasterEntity]
     **/
    public ServiceResult<Integer> doUpdate(SalesOrderMasterEntity salesOrderMasterEntity) {
        Assert.notNull(this.salesOrderMasterMapper, "Property 'salesOrderMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.salesOrderMasterMapper.doUpdate(salesOrderMasterEntity);
            if (success > 0) {
                id = salesOrderMasterEntity.getSalesOrderId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesOrderMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:57
     * @Param [salesOrderId]
     **/
    public ServiceResult<Boolean> doDelete(int salesOrderId) {
        Assert.notNull(this.salesOrderMasterMapper, "Property 'salesOrderMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.salesOrderMasterMapper.doDelete(salesOrderId);
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
            LOGGER.error("[SalesOrderMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}