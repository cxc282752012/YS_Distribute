package com.system.controller;

import com.system.constants.BaseErrorConstants;
import com.system.entity.UserMasterEntity;
import com.system.service.UserMasterService;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserMasterController.class);

    @Autowired
    private UserMasterService userMasterService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:15
     * @Param [request]
     **/
    @GetMapping(value = "/user/findList")
    public ServiceResult<List<UserMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<UserMasterEntity>> result = new ServiceResult<List<UserMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int userId = ConvertUtil.toInt(request.getParameter("userId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (userId > 0) {
                params.put("userId", userId);
            }
            result = userMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[UserMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user order list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:15
     * @Param [request]
     **/
    @GetMapping(value = "/user/findInfo")
    public ServiceResult<UserMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<UserMasterEntity> result = new ServiceResult<UserMasterEntity>();
        Map<String, Object> params = null;
        int userId = ConvertUtil.toInt(request.getParameter("userId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (userId > 0) {
                params.put("userId", userId);
            }
            result = userMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[UserMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user order error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:14
     * @Param [userMasterEntity]
     **/
    @PostMapping(value = "/user/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody UserMasterEntity userMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = userMasterService.doInsert(userMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[UserMasterController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:14
     * @Param [userMasterEntity]
     **/
    @PostMapping(value = "/user/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody UserMasterEntity userMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = userMasterService.doUpdate(userMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[UserMasterController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:14
     * @Param [userId]
     **/
    @PostMapping(value = "/user/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("userId") int userId) {
        ServiceResult<Boolean> result = new ServiceResult<>();
        try {
            result = userMasterService.doDelete(userId);
        } catch (Exception e) {
            LOGGER.error("[UserMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}