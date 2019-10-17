package com.system.controller;

import com.system.constants.BaseErrorConstants;
import com.system.entity.BusinessLogEntity;
import com.system.service.BusinessLogService;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BusinessLogController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BusinessLogController.class);

    @Autowired
    private BusinessLogService businessLogService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:03
     * @Param [request]
     **/
    @GetMapping(value = "/businessLog/findList")
    public ServiceResult<List<BusinessLogEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<BusinessLogEntity>> result = new ServiceResult<List<BusinessLogEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int businessLogId = ConvertUtil.toInt(request.getParameter("businessLogId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (businessLogId > 0) {
                params.put("businessLogId", businessLogId);
            }
            result = businessLogService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[BusinessLogController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find business log list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:03
     * @Param [request]
     **/
    @GetMapping(value = "/businessLog/findInfo")
    public ServiceResult<BusinessLogEntity> findInfo(HttpServletRequest request) {
        ServiceResult<BusinessLogEntity> result = new ServiceResult<BusinessLogEntity>();
        Map<String, Object> params = null;
        int businessLogId = ConvertUtil.toInt(request.getParameter("businessLogId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (businessLogId > 0) {
                params.put("businessLogId", businessLogId);
            }
            result = businessLogService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[BusinessLogController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find business log error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:02
     * @Param [BusinessLogEntity]
     **/
    @PostMapping(value = "/businessLog/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody BusinessLogEntity BusinessLogEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = businessLogService.doInsert(BusinessLogEntity);
        } catch (Exception e) {
            LOGGER.error("[BusinessLogController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:02
     * @Param [BusinessLogEntity]
     **/
    @PostMapping(value = "/businessLog/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody BusinessLogEntity BusinessLogEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = businessLogService.doUpdate(BusinessLogEntity);
        } catch (Exception e) {
            LOGGER.error("[BusinessLogController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:01
     * @Param [businessLogId]
     **/
    @PostMapping(value = "/businessLog/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("businessLogId") int businessLogId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = businessLogService.doDelete(businessLogId);
        } catch (Exception e) {
            LOGGER.error("[BusinessLogController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}