package com.system.controller;

import com.system.constants.BaseErrorConstants;
import com.system.entity.UserPermissionEntity;
import com.system.service.UserPermissionService;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserPermissionController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserPermissionController.class);

    @Autowired
    private UserPermissionService userPermissionService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:32
     * @Param [request]
     **/
    @GetMapping(value = "/userPermission/findList")
    public ServiceResult<List<UserPermissionEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<UserPermissionEntity>> result = new ServiceResult<List<UserPermissionEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int permissionId = ConvertUtil.toInt(request.getParameter("permissionId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (permissionId > 0) {
                params.put("permissionId", permissionId);
            }
            result = userPermissionService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[UserPermissionController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user permission list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:33
     * @Param [request]
     **/
    @GetMapping(value = "/userPermission/findInfo")
    public ServiceResult<UserPermissionEntity> findInfo(HttpServletRequest request) {
        ServiceResult<UserPermissionEntity> result = new ServiceResult<UserPermissionEntity>();
        Map<String, Object> params = null;
        int permissionId = ConvertUtil.toInt(request.getParameter("permissionId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (permissionId > 0) {
                params.put("permissionId", permissionId);
            }
            result = userPermissionService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[UserPermissionController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user permission error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:33
     * @Param [userPermissionEntity]
     **/
    @PostMapping(value = "/userPermission/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody UserPermissionEntity userPermissionEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = userPermissionService.doInsert(userPermissionEntity);
        } catch (Exception e) {
            LOGGER.error("[UserPermissionController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:33
     * @Param [userPermissionEntity]
     **/
    @PostMapping(value = "/userPermission/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody UserPermissionEntity userPermissionEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = userPermissionService.doUpdate(userPermissionEntity);
        } catch (Exception e) {
            LOGGER.error("[UserPermissionController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:33
     * @Param [permissionId]
     **/
    @PostMapping(value = "/userPermission/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("permissionId") int permissionId) {
        ServiceResult<Boolean> result = new ServiceResult<>();
        try {
            result = userPermissionService.doDelete(permissionId);
        } catch (Exception e) {
            LOGGER.error("[UserPermissionController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}