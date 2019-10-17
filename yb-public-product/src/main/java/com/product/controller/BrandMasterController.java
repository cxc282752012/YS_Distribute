package com.product.controller;

import com.product.entity.BrandMasterEntity;
import com.product.service.BrandMasterService;
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
public class BrandMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BrandMasterController.class);

    @Autowired
    private BrandMasterService brandMasterService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [request]
     **/
    @GetMapping(value = "/brand/findList")
    public ServiceResult<List<BrandMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<BrandMasterEntity>> result = new ServiceResult<List<BrandMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int brandId = ConvertUtil.toInt(request.getParameter("brandId"), 0);
        int storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (brandId > 0) {
                params.put("brandId", brandId);
            }
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            result = brandMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[BrandMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find brand list error.");
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
    @GetMapping(value = "/brand/findInfo")
    public ServiceResult<BrandMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<BrandMasterEntity> result = new ServiceResult<BrandMasterEntity>();
        Map<String, Object> params = null;
        int brandId = ConvertUtil.toInt(request.getParameter("brandId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (brandId > 0) {
                params.put("brandId", brandId);
            }
            result = brandMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[BrandMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find brand error.");
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
    @PostMapping(value = "/brand/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody BrandMasterEntity brandMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = brandMasterService.doInsert(brandMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[BrandMasterController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/brand/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody BrandMasterEntity brandMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = brandMasterService.doUpdate(brandMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[BrandMasterController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/brand/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("productId") int brandId) {
        ServiceResult<Boolean> result = brandMasterService.doDelete(brandId);
        return result;
    }

}