package com.warehouse.controller;

import com.system.constants.BaseErrorConstants;
import com.system.util.*;
import com.warehouse.entity.CheckStockMasterEntity;
import com.warehouse.service.CheckStockMasterService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CheckStockMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CheckStockMasterController.class);

    @Autowired
    private CheckStockMasterService checkStockMasterService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 16:19
     * @Param [request]
     **/
    @GetMapping(value = "/checkStock/findList")
    public ServiceResult<List<CheckStockMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<CheckStockMasterEntity>> result = new ServiceResult<List<CheckStockMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int checkStockId = ConvertUtil.toInt(request.getParameter("checkStockId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (checkStockId > 0) {
                params.put("checkStockId", checkStockId);
            }
            result = checkStockMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[CheckStockMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find CheckStock list error.");
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
    @GetMapping(value = "/checkStock/findInfo")
    public ServiceResult<CheckStockMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<CheckStockMasterEntity> result = new ServiceResult<CheckStockMasterEntity>();
        Map<String, Object> params = null;
        int checkStockId = ConvertUtil.toInt(request.getParameter("checkStockId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (checkStockId > 0) {
                params.put("checkStockId", checkStockId);
            }
            result = checkStockMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[CheckStockMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find CheckStock error.");
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
    @PostMapping(value = "/checkStock/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody CheckStockMasterEntity checkStockMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = checkStockMasterService.doInsert(checkStockMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[CheckStockMasterController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/checkStock/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody CheckStockMasterEntity checkStockMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = checkStockMasterService.doUpdate(checkStockMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[CheckStockMasterController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/checkStock/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("checkStockId") int checkStockId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = checkStockMasterService.doDelete(checkStockId);
        } catch (Exception e) {
            LOGGER.error("[CheckStockMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}