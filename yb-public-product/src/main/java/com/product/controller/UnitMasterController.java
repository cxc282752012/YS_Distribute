package com.product.controller;

import com.product.entity.UnitMasterEntity;
import com.product.service.UnitMasterService;
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
public class UnitMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UnitMasterController.class);

    @Autowired
    private UnitMasterService unitMasterService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [request]
     **/
    @GetMapping(value = "/unit/findList")
    public ServiceResult<List<UnitMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<UnitMasterEntity>> result = new ServiceResult<List<UnitMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int unitId = ConvertUtil.toInt(request.getParameter("unitId"), 0);
        int storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (unitId > 0) {
                params.put("unitId", unitId);
            }
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            result = unitMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[UnitMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find unit list error.");
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
    @GetMapping(value = "/unit/findInfo")
    public ServiceResult<UnitMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<UnitMasterEntity> result = new ServiceResult<UnitMasterEntity>();
        Map<String, Object> params = null;
        int unitId = ConvertUtil.toInt(request.getParameter("unitId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (unitId > 0) {
                params.put("unitId", unitId);
            }
            result = unitMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[UnitMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find unit error.");
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
    @PostMapping(value = "/unit/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody UnitMasterEntity unitMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = unitMasterService.doInsert(unitMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[UnitMasterController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/unit/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody UnitMasterEntity unitMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = unitMasterService.doUpdate(unitMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[UnitMasterController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/unit/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("unitId") int unitId) {
        ServiceResult<Boolean> result = unitMasterService.doDelete(unitId);
        return result;
    }

}