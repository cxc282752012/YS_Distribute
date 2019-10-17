package com.warehouse.controller;

import com.system.constants.BaseErrorConstants;
import com.system.util.*;
import com.warehouse.entity.CheckStockDetailEntity;
import com.warehouse.service.CheckStockDetailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CheckStockDetailController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CheckStockDetailController.class);

    @Autowired
    private CheckStockDetailService checkStockDetailService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 16:19
     * @Param [request]
     **/
    @GetMapping(value = "/checkStockDetail/findList")
    public ServiceResult<List<CheckStockDetailEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<CheckStockDetailEntity>> result = new ServiceResult<List<CheckStockDetailEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int checkStockDetailId = ConvertUtil.toInt(request.getParameter("checkStockDetailId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (checkStockDetailId > 0) {
                params.put("checkStockDetailId", checkStockDetailId);
            }
            result = checkStockDetailService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[CheckStockDetailController][findList]：query findList occur exception", e);
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
    @GetMapping(value = "/checkStockDetail/findInfo")
    public ServiceResult<CheckStockDetailEntity> findInfo(HttpServletRequest request) {
        ServiceResult<CheckStockDetailEntity> result = new ServiceResult<CheckStockDetailEntity>();
        Map<String, Object> params = null;
        int checkStockDetailId = ConvertUtil.toInt(request.getParameter("checkStockDetailId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (checkStockDetailId > 0) {
                params.put("checkStockDetailId", checkStockDetailId);
            }
            result = checkStockDetailService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[CheckStockDetailController][findInfo]：query findInfo occur exception", e);
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
    @PostMapping(value = "/checkStockDetail/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody CheckStockDetailEntity checkStockDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = checkStockDetailService.doInsert(checkStockDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[CheckStockDetailController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/checkStockDetail/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody CheckStockDetailEntity checkStockDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = checkStockDetailService.doUpdate(checkStockDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[CheckStockDetailController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/checkStockDetail/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("checkStockDetailId") int checkStockDetailId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = checkStockDetailService.doDelete(checkStockDetailId);
        } catch (Exception e) {
            LOGGER.error("[CheckStockDetailController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}