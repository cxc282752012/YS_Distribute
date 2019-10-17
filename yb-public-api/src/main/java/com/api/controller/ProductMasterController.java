package com.api.controller;

import com.api.service.IProductMasterService;
import com.product.entity.ProductMasterEntity;
import com.system.constants.BaseErrorConstants;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/public")
public class ProductMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductMasterController.class);

    @Autowired
    private IProductMasterService productMasterService;

    @RequestMapping(value = { "/product/findList" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findList(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Integer storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        Integer productId = ConvertUtil.toInt(request.getParameter("productId"), 0);
        String customCode = request.getParameter("customCode");
        List<ProductMasterEntity> productMasterList = null;
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (pagerInfo != null) {
                params.put("pageSize", pagerInfo.getPageSize());
                params.put("pageIndex", pagerInfo.getPageIndex());
            }
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            if (productId > 0) {
                params.put("productId", productId);
            }
            if (!StringUtil.isEmpty(request.getParameter("customCode"))) {
                params.put("customCode", customCode);
            }
            ServiceResult<List<ProductMasterEntity>> productMasterResult = productMasterService.findList(params);
            pagerInfo = productMasterResult.getPager();
            if (productMasterResult.getSuccess() && productMasterResult.getResult() != null
                    && productMasterResult.getResult().size() > 0) {
                productMasterList = productMasterResult.getResult();
                returnTable.put("productMasterList", productMasterList);
            }
            returnTable.put("pagerInfo", pagerInfo);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][ProductMasterController][findList] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find productMasterList error.");
        }
        return result;
    }

    @RequestMapping(value = { "/product/findInfo" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findInfo(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        ProductMasterEntity productMasterEntity = null;
        Map<String, Object> params = null;
        int productId = ConvertUtil.toInt(request.getParameter("productId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (productId > 0) {
                params.put("productId", productId);
            }
            ServiceResult<ProductMasterEntity> productMasterResult = productMasterService.findInfo(params);
            if (productMasterResult.getSuccess() && productMasterResult.getResult() != null) {
                productMasterEntity = productMasterResult.getResult();
                returnTable.put("productMasterEntity", productMasterEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][ProductMasterController][findInfo] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find productMasterEntity error.");
        }
        return result;
    }

    @PostMapping(value = "/product/doInsert")
    public HttpJsonResult<Hashtable<String, Object>> doInsert(@RequestBody ProductMasterEntity productMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> productMasterResult = productMasterService.doInsert(productMasterEntity);
            if (productMasterResult.getSuccess() && productMasterResult.getResult() != null) {
                returnTable.put("id", productMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][ProductMasterController][doInsert] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Insert ProductMasterEntity error.");
        }
        return result;
    }

    @PostMapping(value = "/product/doUpdate")
    public HttpJsonResult<Hashtable<String, Object>> doUpdate(@RequestBody ProductMasterEntity productMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> productMasterResult = productMasterService.doUpdate(productMasterEntity);
            if (productMasterResult.getSuccess() && productMasterResult.getResult() != null) {
                returnTable.put("id", productMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][ProductMasterController][doUpdate] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Update ProductMasterEntity error.");
        }
        return result;
    }

    @PostMapping(value = "/product/doDelete")
    public HttpJsonResult<Hashtable<String, Object>> doDelete(@RequestParam("productId") int productId) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Boolean flag = false;
        try {
            ServiceResult<Boolean> productMasterResult = productMasterService.doDelete(productId);
            if (productMasterResult.getSuccess() && productMasterResult.getResult() != null) {
                flag = productMasterResult.getResult();
            }
            returnTable.put("deleteFlag", flag);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][ProductMasterController][doDelete] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Delete ProductMasterEntity error.");
        }
        return result;
    }
}
