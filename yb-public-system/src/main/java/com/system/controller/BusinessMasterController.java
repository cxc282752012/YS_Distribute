package com.system.controller;

import com.system.constants.BaseErrorConstants;
import com.system.entity.BusinessMasterEntity;
import com.system.service.BusinessMasterService;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BusinessMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BusinessMasterController.class);

    @Autowired
    private BusinessMasterService businessMasterService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:47
     * @Param [request]
     **/
    @GetMapping(value = "/business/findList")
    public ServiceResult<List<BusinessMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<BusinessMasterEntity>> result = new ServiceResult<List<BusinessMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int businessId = ConvertUtil.toInt(request.getParameter("businessId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (businessId > 0) {
                params.put("businessId", businessId);
            }
            result = businessMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[BusinessMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find business list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:48
     * @Param [request]
     **/
    @GetMapping(value = "/business/findInfo")
    public ServiceResult<BusinessMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<BusinessMasterEntity> result = new ServiceResult<BusinessMasterEntity>();
        Map<String, Object> params = null;
        int businessId = ConvertUtil.toInt(request.getParameter("businessId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (businessId > 0) {
                params.put("businessId", businessId);
            }
            result = businessMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[BusinessMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find business error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:48
     * @Param [businessMasterEntity]
     **/
    @PostMapping(value = "/business/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody BusinessMasterEntity businessMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = businessMasterService.doInsert(businessMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[BusinessMasterController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:48
     * @Param [BusinessMasterEntity]
     **/
    @PostMapping(value = "/business/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody BusinessMasterEntity BusinessMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = businessMasterService.doUpdate(BusinessMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[BusinessMasterController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:04
     * @Param [businessId]
     **/
    @PostMapping(value = "/business/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("businessId") int businessId) {
        ServiceResult<Boolean> result = new ServiceResult<>();
        try {
            result = businessMasterService.doDelete(businessId);
        } catch (Exception e) {
            LOGGER.error("[BusinessMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }

        return result;
    }

}