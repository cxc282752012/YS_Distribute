package com.warehouse.controller;

import com.system.constants.BaseErrorConstants;
import com.system.util.*;
import com.warehouse.entity.InStockMasterEntity;
import com.warehouse.service.InStockMasterService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InStockMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InStockMasterController.class);

    @Autowired
    private InStockMasterService inStockMasterService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 16:19
     * @Param [request]
     **/
    @GetMapping(value = "/inStock/findList")
    public ServiceResult<List<InStockMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<InStockMasterEntity>> result = new ServiceResult<List<InStockMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int inStockId = ConvertUtil.toInt(request.getParameter("inStockId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (inStockId > 0) {
                params.put("inStockId", inStockId);
            }
            result = inStockMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[InStockMasterController][findList]：query findList occur exception", e);
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
    @GetMapping(value = "/inStock/findInfo")
    public ServiceResult<InStockMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<InStockMasterEntity> result = new ServiceResult<InStockMasterEntity>();
        Map<String, Object> params = null;
        int inStockId = ConvertUtil.toInt(request.getParameter("inStockId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (inStockId > 0) {
                params.put("inStockId", inStockId);
            }
            result = inStockMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[InStockMasterController][findInfo]：query findInfo occur exception", e);
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
    @PostMapping(value = "/inStock/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody InStockMasterEntity inStockMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = inStockMasterService.doInsert(inStockMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[InStockMasterController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/inStock/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody InStockMasterEntity inStockMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = inStockMasterService.doUpdate(inStockMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[InStockMasterController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/inStock/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("inStockId") int inStockId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = inStockMasterService.doDelete(inStockId);
        } catch (Exception e) {
            LOGGER.error("[InStockMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}