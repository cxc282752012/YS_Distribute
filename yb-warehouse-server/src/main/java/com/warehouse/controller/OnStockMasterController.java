package com.warehouse.controller;

import com.system.constants.BaseErrorConstants;
import com.system.util.*;
import com.warehouse.entity.OnStockMasterEntity;
import com.warehouse.service.OnStockMasterService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OnStockMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OnStockMasterController.class);

    @Autowired
    private OnStockMasterService onStockMasterService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 16:19
     * @Param [request]
     **/
    @GetMapping(value = "/onStock/findList")
    public ServiceResult<List<OnStockMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<OnStockMasterEntity>> result = new ServiceResult<List<OnStockMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int onStockId = ConvertUtil.toInt(request.getParameter("onStockId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (onStockId > 0) {
                params.put("onStockId", onStockId);
            }
            result = onStockMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[OnStockMasterController][findList]：query findList occur exception", e);
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
    @GetMapping(value = "/onStock/findInfo")
    public ServiceResult<OnStockMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<OnStockMasterEntity> result = new ServiceResult<OnStockMasterEntity>();
        Map<String, Object> params = null;
        int onStockId = ConvertUtil.toInt(request.getParameter("onStockId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (onStockId > 0) {
                params.put("onStockId", onStockId);
            }
            result = onStockMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[OnStockMasterController][findInfo]：query findInfo occur exception", e);
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
    @PostMapping(value = "/onStock/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody OnStockMasterEntity onStockMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = onStockMasterService.doInsert(onStockMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[OnStockMasterController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/onStock/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody OnStockMasterEntity onStockMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = onStockMasterService.doUpdate(onStockMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[OnStockMasterController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/onStock/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("onStockId") int onStockId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = onStockMasterService.doDelete(onStockId);
        } catch (Exception e) {
            LOGGER.error("[OnStockMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}