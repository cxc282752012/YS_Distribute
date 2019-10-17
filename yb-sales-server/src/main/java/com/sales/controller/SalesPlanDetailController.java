package com.sales.controller;

import com.sales.entity.SalesPlanDetailEntity;
import com.sales.service.SalesPlanDetailService;
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
public class SalesPlanDetailController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SalesPlanDetailController.class);

    @Autowired
    private SalesPlanDetailService salesPlanDetailService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:18
     * @Param [request]
     **/
    @GetMapping(value = "/salesPlanDetail/findList")
    public ServiceResult<List<SalesPlanDetailEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<SalesPlanDetailEntity>> result = new ServiceResult<List<SalesPlanDetailEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int salesPlanDetailId = ConvertUtil.toInt(request.getParameter("salesPlanDetailId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (salesPlanDetailId > 0) {
                params.put("salesPlanDetailId", salesPlanDetailId);
            }
            result = salesPlanDetailService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[SalesPlanDetailController][findList]：query findList occur exception", e);
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
    @GetMapping(value = "/salesPlanDetail/findInfo")
    public ServiceResult<SalesPlanDetailEntity> findInfo(HttpServletRequest request) {
        ServiceResult<SalesPlanDetailEntity> result = new ServiceResult<SalesPlanDetailEntity>();
        Map<String, Object> params = null;
        int salesPlanDetailId = ConvertUtil.toInt(request.getParameter("salesPlanDetailId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (salesPlanDetailId > 0) {
                params.put("salesPlanDetailId", salesPlanDetailId);
            }
            result = salesPlanDetailService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[SalesPlanDetailController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find salesOrderDetail error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesPlanDetailEntity]
     **/
    @PostMapping(value = "/salesPlanDetail/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody SalesPlanDetailEntity salesPlanDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = salesPlanDetailService.doInsert(salesPlanDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[SalesPlanDetailController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesPlanDetailEntity]
     **/
    @PostMapping(value = "/salesPlanDetail/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody SalesPlanDetailEntity salesPlanDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = salesPlanDetailService.doUpdate(salesPlanDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[SalesPlanDetailController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesPlanDetailId]
     **/
    @PostMapping(value = "/salesPlanDetail/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("salesPlanDetailId") int salesPlanDetailId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = salesPlanDetailService.doDelete(salesPlanDetailId);
        } catch (Exception e) {
            LOGGER.error("[SalesPlanDetailController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}