package com.sales.service;

import com.github.pagehelper.PageHelper;
import com.sales.entity.SalesPlanDetailEntity;
import com.sales.mapper.SalesPlanDetailMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("salesPlanDetailService")
public class SalesPlanDetailService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SalesPlanDetailService.class);

    @Autowired
    private SalesPlanDetailMapper salesPlanDetailMapper;

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:55
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<SalesPlanDetailEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.salesPlanDetailMapper, "Property 'salesPlanDetailMapper' is required.");
        ServiceResult<List<SalesPlanDetailEntity>> result = new ServiceResult<List<SalesPlanDetailEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.salesPlanDetailMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesPlanDetailService][findList]：query findList occur exception", e);
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
    public ServiceResult<SalesPlanDetailEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.salesPlanDetailMapper, "Property 'salesPlanDetailMapper' is required.");
        ServiceResult<SalesPlanDetailEntity> result = new ServiceResult<SalesPlanDetailEntity>();
        try {
            result.setResult(this.salesPlanDetailMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesPlanDetailService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [salesPlanDetailEntity]
     **/
    public ServiceResult<Integer> doInsert(SalesPlanDetailEntity salesPlanDetailEntity) {
        Assert.notNull(this.salesPlanDetailMapper, "Property 'salesPlanDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.salesPlanDetailMapper.doInsert(salesPlanDetailEntity);
            if (success > 0) {
                id = salesPlanDetailEntity.getSalesPlanDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesPlanDetailService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [salesPlanDetailEntity]
     **/
    public ServiceResult<Integer> doUpdate(SalesPlanDetailEntity salesPlanDetailEntity) {
        Assert.notNull(this.salesPlanDetailMapper, "Property 'salesPlanDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.salesPlanDetailMapper.doUpdate(salesPlanDetailEntity);
            if (success > 0) {
                id = salesPlanDetailEntity.getSalesPlanDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesPlanDetailService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [salesPlanDetailId]
     **/
    public ServiceResult<Boolean> doDelete(int salesPlanDetailId) {
        Assert.notNull(this.salesPlanDetailMapper, "Property 'salesPlanDetailMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.salesPlanDetailMapper.doDelete(salesPlanDetailId);
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
            LOGGER.error("[SalesPlanDetailService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}