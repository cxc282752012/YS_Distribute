package com.sales.service;

import com.github.pagehelper.PageHelper;
import com.sales.entity.SalesPlanMasterEntity;
import com.sales.mapper.SalesPlanMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("salesPlanMasterService")
public class SalesPlanMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SalesPlanMasterService.class);

    @Autowired
    private SalesPlanMasterMapper salesPlanMasterMapper;

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:55
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<SalesPlanMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.salesPlanMasterMapper, "Property 'salesPlanMasterMapper' is required.");
        ServiceResult<List<SalesPlanMasterEntity>> result = new ServiceResult<List<SalesPlanMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.salesPlanMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesPlanMasterService][findList]：query findList occur exception", e);
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
    public ServiceResult<SalesPlanMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.salesPlanMasterMapper, "Property 'salesPlanMasterMapper' is required.");
        ServiceResult<SalesPlanMasterEntity> result = new ServiceResult<SalesPlanMasterEntity>();
        try {
            result.setResult(this.salesPlanMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesPlanMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [salesPlanMasterEntity]
     **/
    public ServiceResult<Integer> doInsert(SalesPlanMasterEntity salesPlanMasterEntity) {
        Assert.notNull(this.salesPlanMasterMapper, "Property 'salesPlanMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.salesPlanMasterMapper.doInsert(salesPlanMasterEntity);
            if (success > 0) {
                id = salesPlanMasterEntity.getSalesPlanId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesPlanMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [salesPlanMasterEntity]
     **/
    public ServiceResult<Integer> doUpdate(SalesPlanMasterEntity salesPlanMasterEntity) {
        Assert.notNull(this.salesPlanMasterMapper, "Property 'salesPlanMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.salesPlanMasterMapper.doUpdate(salesPlanMasterEntity);
            if (success > 0) {
                id = salesPlanMasterEntity.getSalesPlanId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SalesPlanMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:56
     * @Param [salesPlanId]
     **/
    public ServiceResult<Boolean> doDelete(int salesPlanId) {
        Assert.notNull(this.salesPlanMasterMapper, "Property 'salesPlanMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.salesPlanMasterMapper.doDelete(salesPlanId);
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
            LOGGER.error("[SalesPlanMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}