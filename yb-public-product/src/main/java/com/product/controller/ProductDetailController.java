package com.product.controller;

import com.product.entity.ProductDetailEntity;
import com.product.service.ProductDetailService;
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
public class ProductDetailController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductDetailController.class);

    @Autowired
    private ProductDetailService productDetailService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-16 16:12
     * @Param [request]
     **/
    @GetMapping(value = "/productDetail/findList")
    public ServiceResult<List<ProductDetailEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<ProductDetailEntity>> result = new ServiceResult<List<ProductDetailEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int productDetailId = ConvertUtil.toInt(request.getParameter("productDetailId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (productDetailId > 0) {
                params.put("productDetailId", productDetailId);
            }
            result = productDetailService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[ProductDetailController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find product detail list error.");
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
    @GetMapping(value = "/productDetail/findInfo")
    public ServiceResult<ProductDetailEntity> findInfo(HttpServletRequest request) {
        ServiceResult<ProductDetailEntity> result = new ServiceResult<ProductDetailEntity>();
        Map<String, Object> params = null;
        int productDetailId = ConvertUtil.toInt(request.getParameter("productDetailId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (productDetailId > 0) {
                params.put("productDetailId", productDetailId);
            }
            result = productDetailService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[ProductDetailController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find product detail error.");
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
    @PostMapping(value = "/productDetail/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody ProductDetailEntity productDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = productDetailService.doInsert(productDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[ProductDetailController][doInsert]：Insert occur exception", e);
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
    @PostMapping(value = "/productDetail/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody ProductDetailEntity productDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = productDetailService.doUpdate(productDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[ProductDetailController][doUpdate]：Update occur exception", e);
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
    @PostMapping(value = "/productDetail/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("productDetailId") int productDetailId) {
        ServiceResult<Boolean> result = productDetailService.doDelete(productDetailId);
        return result;
    }

}