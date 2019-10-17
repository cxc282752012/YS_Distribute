package com.sales.controller;

import com.sales.entity.SalesPlanMasterEntity;
import com.sales.service.SalesPlanMasterService;
import com.system.constants.BaseErrorConstants;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SalesPlanMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SalesPlanMasterController.class);

    @Autowired
    private SalesPlanMasterService salesPlanMasterService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:18
     * @Param [request]
     **/
    @GetMapping(value = "/salesPlan/findList")
    public ServiceResult<List<SalesPlanMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<SalesPlanMasterEntity>> result = new ServiceResult<List<SalesPlanMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int salesPlanId = ConvertUtil.toInt(request.getParameter("salesPlanId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (salesPlanId > 0) {
                params.put("salesPlanId", salesPlanId);
            }
            result = salesPlanMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[SalesPlanMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find salesOrderDetail list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [request]
     **/
    @GetMapping(value = "/salesPlan/findInfo")
    public ServiceResult<SalesPlanMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<SalesPlanMasterEntity> result = new ServiceResult<SalesPlanMasterEntity>();
        Map<String, Object> params = null;
        int salesPlanId = ConvertUtil.toInt(request.getParameter("salesPlanId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (salesPlanId > 0) {
                params.put("salesPlanId", salesPlanId);
            }
            result = salesPlanMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[SalesPlanMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find salesOrderDetail error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesPlanMasterEntity]
     **/
    @PostMapping(value = "/salesPlan/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody SalesPlanMasterEntity salesPlanMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = salesPlanMasterService.doInsert(salesPlanMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[SalesPlanMasterController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesPlanMasterEntity]
     **/
    @PostMapping(value = "/salesPlan/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody SalesPlanMasterEntity salesPlanMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = salesPlanMasterService.doUpdate(salesPlanMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[SalesPlanMasterController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesPlanId]
     **/
    @PostMapping(value = "/salesPlan/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("salesPlanId") int salesPlanId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = salesPlanMasterService.doDelete(salesPlanId);
        } catch (Exception e) {
            LOGGER.error("[SalesPlanMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}