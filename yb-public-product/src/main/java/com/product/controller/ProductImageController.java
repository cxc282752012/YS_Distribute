package com.product.controller;

import com.product.entity.ProductImageEntity;
import com.product.service.ProductImageService;
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
public class ProductImageController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductImageController.class);

    @Autowired
    private ProductImageService productImageService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [request]
     **/
    @GetMapping(value = "/productImage/findList")
    public ServiceResult<List<ProductImageEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<ProductImageEntity>> result = new ServiceResult<List<ProductImageEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int productImageId = ConvertUtil.toInt(request.getParameter("productImageId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (productImageId > 0) {
                params.put("productImageId", productImageId);
            }
            result = productImageService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[ProductImageController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find product image  list error.");
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
    @GetMapping(value = "/productImage/findInfo")
    public ServiceResult<ProductImageEntity> findInfo(HttpServletRequest request) {
        ServiceResult<ProductImageEntity> result = new ServiceResult<ProductImageEntity>();
        Map<String, Object> params = null;
        int productImageId = ConvertUtil.toInt(request.getParameter("productImageId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (productImageId > 0) {
                params.put("productImageId", productImageId);
            }
            result = productImageService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[ProductImageController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find product image error.");
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
    @PostMapping(value = "/productImage/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody ProductImageEntity productImageEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = productImageService.doInsert(productImageEntity);
        } catch (Exception e) {
            LOGGER.error("[ProductImageController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/productImage/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody ProductImageEntity productImageEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = productImageService.doUpdate(productImageEntity);
        } catch (Exception e) {
            LOGGER.error("[ProductImageController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/productImage/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("productImageId") int productImageId) {
        ServiceResult<Boolean> result = productImageService.doDelete(productImageId);
        return result;
    }

}