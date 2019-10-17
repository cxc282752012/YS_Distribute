package com.product.controller;

import com.product.entity.CategoryMasterEntity;
import com.product.service.CategoryMasterService;
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
public class CategoryMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoryMasterController.class);

    @Autowired
    private CategoryMasterService categoryMasterService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [request]
     **/
    @GetMapping(value = "/category/findList")
    public ServiceResult<List<CategoryMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<CategoryMasterEntity>> result = new ServiceResult<List<CategoryMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int categoryId = ConvertUtil.toInt(request.getParameter("categoryId"), 0);
        int storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        String dtr = StringUtil.nullSafeString(request.getParameter(""));
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (dtr != null && !dtr.equals(""))
            if (categoryId > 0) {
                params.put("categoryId", categoryId);
            }
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            result = categoryMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[CategoryMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find category list error.");
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
    @GetMapping(value = "/category/findInfo")
    public ServiceResult<CategoryMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<CategoryMasterEntity> result = new ServiceResult<CategoryMasterEntity>();
        Map<String, Object> params = null;
        int categoryId = ConvertUtil.toInt(request.getParameter("categoryId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (categoryId > 0) {
                params.put("categoryId", categoryId);
            }
            result = categoryMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[CategoryMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find category error.");
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
    @PostMapping(value = "/category/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody CategoryMasterEntity categoryMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = categoryMasterService.doInsert(categoryMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[CategoryMasterController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/category/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody CategoryMasterEntity categoryMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = categoryMasterService.doUpdate(categoryMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[CategoryMasterController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/category/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("categoryId") int categoryId) {
        ServiceResult<Boolean> result = categoryMasterService.doDelete(categoryId);
        return result;
    }

}