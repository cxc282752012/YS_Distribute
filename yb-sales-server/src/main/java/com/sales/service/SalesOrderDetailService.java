package com.sales.service;

import com.github.pagehelper.PageHelper;
import com.sales.entity.SalesOrderDetailEntity;
import com.sales.mapper.SalesOrderDetailMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("salesOrderDetailService")
public class SalesOrderDetailService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SalesOrderDetailService.class);

    @Autowired
    private SalesOrderDetailMapper salesOrderDetailMapper;

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:55
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<SalesOrderDetailEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.salesOrderDetailMapper, "Property 'salesOrderDetailMapper' is required.");
        ServiceResult<List<SalesOrderDetailEntity>> result = new ServiceResult<List<SalesOrderDetailEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.salesOrderDetailMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesOrderDetailService][findList]：query findList occur exception", e);
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
    public ServiceResult<SalesOrderDetailEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.salesOrderDetailMapper, "Property 'salesOrderDetailMapper' is required.");
        ServiceResult<SalesOrderDetailEntity> result = new ServiceResult<SalesOrderDetailEntity>();
        try {
            result.setResult(this.salesOrderDetailMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesOrderDetailService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [salesOrderDetailEntity]
     **/
    public ServiceResult<Integer> doInsert(SalesOrderDetailEntity salesOrderDetailEntity) {
        Assert.notNull(this.salesOrderDetailMapper, "Property 'salesOrderDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.salesOrderDetailMapper.doInsert(salesOrderDetailEntity);
            if (success > 0) {
                id = salesOrderDetailEntity.getSalesDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesOrderDetailService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [salesOrderDetailEntity]
     **/
    public ServiceResult<Integer> doUpdate(SalesOrderDetailEntity salesOrderDetailEntity) {
        Assert.notNull(this.salesOrderDetailMapper, "Property 'salesOrderDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.salesOrderDetailMapper.doUpdate(salesOrderDetailEntity);
            if (success > 0) {
                id = salesOrderDetailEntity.getSalesDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesOrderDetailService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [salesDetailId]
     **/
    public ServiceResult<Boolean> doDelete(int salesDetailId) {
        Assert.notNull(this.salesOrderDetailMapper, "Property 'salesOrderDetailMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.salesOrderDetailMapper.doDelete(salesDetailId);
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
            LOGGER.error("[SalesOrderDetailService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}