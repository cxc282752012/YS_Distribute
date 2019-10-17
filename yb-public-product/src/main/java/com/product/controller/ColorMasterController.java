package com.product.controller;

import com.product.entity.ColorMasterEntity;
import com.product.service.ColorMasterService;
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
public class ColorMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ColorMasterController.class);

    @Autowired
    private ColorMasterService colorMasterService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [request]
     **/
    @GetMapping(value = "/color/findList")
    public ServiceResult<List<ColorMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<ColorMasterEntity>> result = new ServiceResult<List<ColorMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int colorId = ConvertUtil.toInt(request.getParameter("colorId"), 0);
        int storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (colorId > 0) {
                params.put("colorId", colorId);
            }
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            result = colorMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[ColorMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find color list error.");
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
    @GetMapping(value = "/color/findInfo")
    public ServiceResult<ColorMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<ColorMasterEntity> result = new ServiceResult<ColorMasterEntity>();
        Map<String, Object> params = null;
        int colorId = ConvertUtil.toInt(request.getParameter("colorId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (colorId > 0) {
                params.put("colorId", colorId);
            }
            result = colorMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[ColorMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find color error.");
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
    @PostMapping(value = "/color/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody ColorMasterEntity colorMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = colorMasterService.doInsert(colorMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[ColorMasterController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/color/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody ColorMasterEntity colorMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = colorMasterService.doUpdate(colorMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[ColorMasterController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/color/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("colorId") int colorId) {
        ServiceResult<Boolean> result = colorMasterService.doDelete(colorId);
        return result;
    }

}