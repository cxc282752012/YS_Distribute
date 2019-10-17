package com.system.controller;

import com.system.constants.BaseErrorConstants;
import com.system.entity.UserRolePermissionEntity;
import com.system.service.UserRolePermissionService;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserRolePermissionController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserRolePermissionController.class);

    @Autowired
    private UserRolePermissionService userRolePermissionService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:06
     * @Param [request]
     **/
    @GetMapping(value = "/userRolePermission/findList")
    public ServiceResult<List<UserRolePermissionEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<UserRolePermissionEntity>> result = new ServiceResult<List<UserRolePermissionEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int rolePermissionId = ConvertUtil.toInt(request.getParameter("rolePermissionId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (rolePermissionId > 0) {
                params.put("rolePermissionId", rolePermissionId);
            }
            result = userRolePermissionService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[UserRolePermissionController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user order list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:06
     * @Param [request]
     **/
    @GetMapping(value = "/userRolePermission/findInfo")
    public ServiceResult<UserRolePermissionEntity> findInfo(HttpServletRequest request) {
        ServiceResult<UserRolePermissionEntity> result = new ServiceResult<UserRolePermissionEntity>();
        Map<String, Object> params = null;
        int rolePermissionId = ConvertUtil.toInt(request.getParameter("rolePermissionId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (rolePermissionId > 0) {
                params.put("rolePermissionId", rolePermissionId);
            }
            result = userRolePermissionService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[UserRolePermissionController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user order error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:06
     * @Param [userRolePermissionEntity]
     **/
    @PostMapping(value = "/userRolePermission/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody UserRolePermissionEntity userRolePermissionEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = userRolePermissionService.doInsert(userRolePermissionEntity);
        } catch (Exception e) {
            LOGGER.error("[UserRolePermissionController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:06
     * @Param [userRolePermissionEntity]
     **/
    @PostMapping(value = "/userRolePermission/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody UserRolePermissionEntity userRolePermissionEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = userRolePermissionService.doUpdate(userRolePermissionEntity);
        } catch (Exception e) {
            LOGGER.error("[UserRolePermissionController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:07
     * @Param [rolePermissionId]
     **/
    @PostMapping(value = "/userRolePermission/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("userRolePermissionId") int rolePermissionId) {
        ServiceResult<Boolean> result = new ServiceResult<>();
        try {
            result = userRolePermissionService.doDelete(rolePermissionId);
        } catch (Exception e) {
            LOGGER.error("[UserRoleController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}