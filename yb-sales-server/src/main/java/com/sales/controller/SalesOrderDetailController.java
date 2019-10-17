package com.sales.controller;

import com.sales.entity.SalesOrderDetailEntity;
import com.sales.service.SalesOrderDetailService;
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
public class SalesOrderDetailController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SalesOrderDetailController.class);

    @Autowired
    private SalesOrderDetailService salesOrderDetailService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:18
     * @Param [request]
     **/
    @GetMapping(value = "/salesOrderDetail/findList")
    public ServiceResult<List<SalesOrderDetailEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<SalesOrderDetailEntity>> result = new ServiceResult<List<SalesOrderDetailEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int salesDetailId = ConvertUtil.toInt(request.getParameter("salesDetailId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (salesDetailId > 0) {
                params.put("salesDetailId", salesDetailId);
            }
            result = salesOrderDetailService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[SalesOrderDetailController][findList]：query findList occur exception", e);
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
    @GetMapping(value = "/salesOrderDetail/findInfo")
    public ServiceResult<SalesOrderDetailEntity> findInfo(HttpServletRequest request) {
        ServiceResult<SalesOrderDetailEntity> result = new ServiceResult<SalesOrderDetailEntity>();
        Map<String, Object> params = null;
        int salesDetailId = ConvertUtil.toInt(request.getParameter("salesDetailId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (salesDetailId > 0) {
                params.put("salesDetailId", salesDetailId);
            }
            result = salesOrderDetailService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[SalesOrderDetailController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find salesOrderDetail error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesOrderDetailEntity]
     **/
    @PostMapping(value = "/salesOrderDetail/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody SalesOrderDetailEntity salesOrderDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = salesOrderDetailService.doInsert(salesOrderDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[SalesOrderDetailController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesOrderDetailEntity]
     **/
    @PostMapping(value = "/salesOrderDetail/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody SalesOrderDetailEntity salesOrderDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = salesOrderDetailService.doUpdate(salesOrderDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[SalesOrderDetailController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [salesDetailId]
     **/
    @PostMapping(value = "/salesOrderDetail/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("salesDetailId") int salesDetailId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = salesOrderDetailService.doDelete(salesDetailId);
        } catch (Exception e) {
            LOGGER.error("[SalesOrderDetailController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}