package com.system.controller;

import com.system.constants.BaseErrorConstants;
import com.system.entity.UserRoleEntity;
import com.system.service.UserRoleService;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserRoleController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    private UserRoleService userRoleService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 17:29
     * @Param [request]
     **/
    @GetMapping(value = "/userRole/findList")
    public ServiceResult<List<UserRoleEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<UserRoleEntity>> result = new ServiceResult<>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        Integer userRoleId = ConvertUtil.toInt(request.getParameter("userRoleId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<>();
            if (userRoleId > 0) {
                params.put("userRoleId", userRoleId);
            }
            result = userRoleService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[UserRoleController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user role list error.");
        }
        return result;

    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 17:52
     * @Param [request]
     **/
    @GetMapping(value = "/userRole/findInfo")
    public ServiceResult<UserRoleEntity> findInfo(HttpServletRequest request) {
        ServiceResult<UserRoleEntity> result = new ServiceResult<>();
        Map<String, Object> params = null;
        Integer userRoleId = ConvertUtil.toInt(request.getParameter("userRoleId"), 0);
        try {
            params = new HashMap<>();
            if (userRoleId > 0) {
                params.put("userRoleId", userRoleId);
            }
            result = userRoleService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[UserRoleController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user role error.");
        }
        return result;
    }

    /**
     * do Insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 17:52
     * @Param [request]
     **/
    @PostMapping(value = "/userRole/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody UserRoleEntity userRoleEntity) {
        ServiceResult<Integer> result = new ServiceResult<>();
        try {
            result = userRoleService.doInsert(userRoleEntity);
        } catch (Exception e) {
            LOGGER.error("[UserRoleController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 17:52
     * @Param [request]
     **/
    @PostMapping(value = "/userRole/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody UserRoleEntity userRoleEntity) {
        ServiceResult<Integer> result = new ServiceResult<>();
        try {
            result = userRoleService.doUpdate(userRoleEntity);
        } catch (Exception e) {
            LOGGER.error("[UserRoleController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 17:52
     * @Param [request]
     **/
    @PostMapping(value = "/userRole/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("userRoleId") int userRoleId) {
        ServiceResult<Boolean> result = new ServiceResult<>();
        try {
            result = userRoleService.doDelete(userRoleId);
        } catch (Exception e) {
            LOGGER.error("[UserRoleController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}
