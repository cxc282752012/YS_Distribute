package com.sales.controller;

import com.sales.entity.SalesOrderMasterEntity;
import com.sales.service.SalesOrderMasterService;
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
public class SalesOrderMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SalesOrderMasterController.class);

    @Autowired
    private SalesOrderMasterService salesOrderMasterService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:18
     * @Param [request]
     **/
    @GetMapping(value = "/salesOrder/findList")
    public ServiceResult<List<SalesOrderMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<SalesOrderMasterEntity>> result = new ServiceResult<List<SalesOrderMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int salesOrderId = ConvertUtil.toInt(request.getParameter("salesOrderId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (salesOrderId > 0) {
                params.put("salesOrderId", salesOrderId);
            }
            result = salesOrderMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[SalesOrderMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find salesOrder list error.");
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
    @GetMapping(value = "/salesOrder/findInfo")
    public ServiceResult<SalesOrderMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<SalesOrderMasterEntity> result = new ServiceResult<SalesOrderMasterEntity>();
        Map<String, Object> params = null;
        int salesOrderId = ConvertUtil.toInt(request.getParameter("salesOrderId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (salesOrderId > 0) {
                params.put("salesOrderId", salesOrderId);
            }
            result = salesOrderMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[SalesOrderMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find salesOrder error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesOrderMasterEntity]
     **/
    @PostMapping(value = "/salesOrder/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody SalesOrderMasterEntity salesOrderMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = salesOrderMasterService.doInsert(salesOrderMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[SalesOrderMasterController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesOrderMasterEntity]
     **/
    @PostMapping(value = "/salesOrder/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody SalesOrderMasterEntity salesOrderMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = salesOrderMasterService.doUpdate(salesOrderMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[SalesOrderMasterController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesOrderId]
     **/
    @PostMapping(value = "/salesOrder/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("salesOrderId") int salesOrderId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = salesOrderMasterService.doDelete(salesOrderId);
        } catch (Exception e) {
            LOGGER.error("[SalesOrderMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}