package com.warehouse.controller;

import com.system.constants.BaseErrorConstants;
import com.system.util.*;
import com.warehouse.entity.InStockDetailEntity;
import com.warehouse.service.InStockDetailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InStockDetailController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InStockDetailController.class);

    @Autowired
    private InStockDetailService inStockDetailService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 16:19
     * @Param [request]
     **/
    @GetMapping(value = "/inStockDetail/findList")
    public ServiceResult<List<InStockDetailEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<InStockDetailEntity>> result = new ServiceResult<List<InStockDetailEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int inStockDetailId = ConvertUtil.toInt(request.getParameter("inStockDetailId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (inStockDetailId > 0) {
                params.put("inStockDetailId", inStockDetailId);
            }
            result = inStockDetailService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[InStockDetailController][findList]：query findList occur exception", e);
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
    @GetMapping(value = "/inStockDetail/findInfo")
    public ServiceResult<InStockDetailEntity> findInfo(HttpServletRequest request) {
        ServiceResult<InStockDetailEntity> result = new ServiceResult<InStockDetailEntity>();
        Map<String, Object> params = null;
        int inStockDetailId = ConvertUtil.toInt(request.getParameter("inStockDetailId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (inStockDetailId > 0) {
                params.put("inStockDetailId", inStockDetailId);
            }
            result = inStockDetailService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[InStockDetailController][findInfo]：query findInfo occur exception", e);
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
    @PostMapping(value = "/inStockDetail/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody InStockDetailEntity inStockDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = inStockDetailService.doInsert(inStockDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[InStockDetailController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/inStockDetail/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody InStockDetailEntity inStockDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = inStockDetailService.doUpdate(inStockDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[InStockDetailController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/inStockDetail/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("inStockDetailId") int inStockDetailId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = inStockDetailService.doDelete(inStockDetailId);
        } catch (Exception e) {
            LOGGER.error("[InStockDetailController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}