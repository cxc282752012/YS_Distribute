package com.product.controller;

import com.product.entity.ProductMasterEntity;
import com.product.service.ProductMasterService;
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
public class ProductMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductMasterController.class);

    @Autowired
    private ProductMasterService productMasterService;

    /**
     * find list
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/product/findList")
    public ServiceResult<List<ProductMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<ProductMasterEntity>> result = new ServiceResult<List<ProductMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int productId = ConvertUtil.toInt(request.getParameter("productId"), 0);
        int storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        String customCode = request.getParameter("customCode");
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (productId > 0) {
                params.put("productId", productId);
            }
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            if (!StringUtil.isEmpty(request.getParameter("customCode"))) {
                params.put("customCode", customCode);
            }
            result = productMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[ProductMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find product order list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/product/findInfo")
    public ServiceResult<ProductMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<ProductMasterEntity> result = new ServiceResult<ProductMasterEntity>();
        Map<String, Object> params = null;
        int productId = ConvertUtil.toInt(request.getParameter("productId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (productId > 0) {
                params.put("productId", productId);
            }
            result = productMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[ProductMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find product order error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @param productMasterEntity
     * @return
     */
    @PostMapping(value = "/product/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody ProductMasterEntity productMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = productMasterService.doInsert(productMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[ProductMasterController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @param productMasterEntity
     * @return
     */
    @PostMapping(value = "/product/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody ProductMasterEntity productMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = productMasterService.doUpdate(productMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[ProductMasterController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @param productId
     * @return
     */
    @PostMapping(value = "/product/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("productId") int productId) {
        ServiceResult<Boolean> result = productMasterService.doDelete(productId);
        return result;
    }

}