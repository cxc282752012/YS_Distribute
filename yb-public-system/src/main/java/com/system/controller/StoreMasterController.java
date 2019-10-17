package com.system.controller;

import com.system.constants.BaseErrorConstants;
import com.system.entity.StoreMasterEntity;
import com.system.service.StoreMasterService;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StoreMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StoreMasterController.class);

    @Autowired
    private StoreMasterService storeMasterService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:38
     * @Param [request]
     **/
    @GetMapping(value = "/store/findList")
    public ServiceResult<List<StoreMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<StoreMasterEntity>> result = new ServiceResult<List<StoreMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            result = storeMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[StoreMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find store list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:38
     * @Param [request]
     **/
    @GetMapping(value = "/store/findInfo")
    public ServiceResult<StoreMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<StoreMasterEntity> result = new ServiceResult<StoreMasterEntity>();
        Map<String, Object> params = null;
        int storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            result = storeMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[StoreMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find store error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:38
     * @Param [storeMasterEntity]
     **/
    @PostMapping(value = "/store/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody StoreMasterEntity storeMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = storeMasterService.doInsert(storeMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[StoreMasterController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:39
     * @Param [storeMasterEntity]
     **/
    @PostMapping(value = "/store/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody StoreMasterEntity storeMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = storeMasterService.doUpdate(storeMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[StoreMasterController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:39
     * @Param [storeId]
     **/
    @PostMapping(value = "/store/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("storeId") int storeId) {
        ServiceResult<Boolean> result = new ServiceResult<>();
        try {
            result = storeMasterService.doDelete(storeId);
        } catch (Exception e) {
            LOGGER.error("[StoreMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}