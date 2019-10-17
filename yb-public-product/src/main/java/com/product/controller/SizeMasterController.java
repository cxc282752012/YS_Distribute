package com.product.controller;

import com.product.entity.SizeMasterEntity;
import com.product.service.SizeMasterService;
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
public class SizeMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SizeMasterController.class);

    @Autowired
    private SizeMasterService sizeMasterService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [request]
     **/
    @GetMapping(value = "/size/findList")
    public ServiceResult<List<SizeMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<SizeMasterEntity>> result = new ServiceResult<List<SizeMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int sizeId = ConvertUtil.toInt(request.getParameter("sizeId"), 0);
        int storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (sizeId > 0) {
                params.put("sizeId", sizeId);
            }
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            result = sizeMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[SizeMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find size list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [request]
     **/
    @GetMapping(value = "/size/findInfo")
    public ServiceResult<SizeMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<SizeMasterEntity> result = new ServiceResult<SizeMasterEntity>();
        Map<String, Object> params = null;
        int sizeId = ConvertUtil.toInt(request.getParameter("sizeId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (sizeId > 0) {
                params.put("sizeId", sizeId);
            }
            result = sizeMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[SizeMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find size error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [brandMasterEntity]
     **/
    @PostMapping(value = "/size/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody SizeMasterEntity sizeMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = sizeMasterService.doInsert(sizeMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[SizeMasterController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [brandMasterEntity]
     **/
    @PostMapping(value = "/size/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody SizeMasterEntity sizeMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = sizeMasterService.doUpdate(sizeMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[SizeMasterController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [brandId]
     **/
    @PostMapping(value = "/size/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("sizeId") int sizeId) {
        ServiceResult<Boolean> result = sizeMasterService.doDelete(sizeId);
        return result;
    }

}