package com.warehouse.controller;

import com.system.constants.BaseErrorConstants;
import com.system.util.*;
import com.warehouse.entity.OnStockDetailEntity;
import com.warehouse.service.OnStockDetailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OnStockDetailController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OnStockDetailController.class);

    @Autowired
    private OnStockDetailService onStockDetailService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 16:19
     * @Param [request]
     **/
    @GetMapping(value = "/onStockDetail/findList")
    public ServiceResult<List<OnStockDetailEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<OnStockDetailEntity>> result = new ServiceResult<List<OnStockDetailEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int onStockDetailId = ConvertUtil.toInt(request.getParameter("onStockDetailId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (onStockDetailId > 0) {
                params.put("onStockDetailId", onStockDetailId);
            }
            result = onStockDetailService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[OnStockDetailController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find CheckStockDetail list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 16:19
     * @Param [request]
     **/
    @GetMapping(value = "/onStockDetail/findInfo")
    public ServiceResult<OnStockDetailEntity> findInfo(HttpServletRequest request) {
        ServiceResult<OnStockDetailEntity> result = new ServiceResult<OnStockDetailEntity>();
        Map<String, Object> params = null;
        int onStockDetailId = ConvertUtil.toInt(request.getParameter("onStockDetailId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (onStockDetailId > 0) {
                params.put("onStockDetailId", onStockDetailId);
            }
            result = onStockDetailService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[OnStockDetailController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find CheckStockDetail error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 16:19
     * @Param [checkStockDetailEntity]
     **/
    @PostMapping(value = "/onStockDetail/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody OnStockDetailEntity onStockDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = onStockDetailService.doInsert(onStockDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[OnStockDetailController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 16:19
     * @Param [checkStockDetailEntity]
     **/
    @PostMapping(value = "/onStockDetail/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody OnStockDetailEntity onStockDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = onStockDetailService.doUpdate(onStockDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[OnStockDetailController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 16:20
     * @Param [checkStockDetailId]
     **/
    @PostMapping(value = "/onStockDetail/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("onStockDetailId") int onStockDetailId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = onStockDetailService.doDelete(onStockDetailId);
        } catch (Exception e) {
            LOGGER.error("[OnStockDetailController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}