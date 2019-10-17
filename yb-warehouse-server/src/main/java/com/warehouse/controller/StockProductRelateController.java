package com.warehouse.controller;

import com.system.constants.BaseErrorConstants;
import com.system.util.*;
import com.warehouse.entity.StockProductRelateEntity;
import com.warehouse.service.StockProductRelateService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StockProductRelateController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StockProductRelateController.class);

    @Autowired
    private StockProductRelateService stockProductRelateService;

    /**
     * find list
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/stockProduct/findList")
    public ServiceResult<List<StockProductRelateEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<StockProductRelateEntity>> result = new ServiceResult<List<StockProductRelateEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int stockProductId = ConvertUtil.toInt(request.getParameter("stockProductId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (stockProductId > 0) {
                params.put("stockProductId", stockProductId);
            }
            result = stockProductRelateService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[StockProductRelateController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user order list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/stockProduct/findInfo")
    public ServiceResult<StockProductRelateEntity> findInfo(HttpServletRequest request) {
        ServiceResult<StockProductRelateEntity> result = new ServiceResult<StockProductRelateEntity>();
        Map<String, Object> params = null;
        int stockProductId = ConvertUtil.toInt(request.getParameter("stockProductId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (stockProductId > 0) {
                params.put("stockProductId", stockProductId);
            }
            result = stockProductRelateService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[StockProductRelateController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user order error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @param stockProductRelateEntity
     * @return
     */
    @PostMapping(value = "/stockProduct/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody StockProductRelateEntity stockProductRelateEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = stockProductRelateService.doInsert(stockProductRelateEntity);
        } catch (Exception e) {
            LOGGER.error("[StockProductRelateController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @param stockProductRelateEntity
     * @return
     */
    @PostMapping(value = "/stockProduct/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody StockProductRelateEntity stockProductRelateEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = stockProductRelateService.doUpdate(stockProductRelateEntity);
        } catch (Exception e) {
            LOGGER.error("[StockProductRelateController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @param stockProductId
     * @return
     */
    @PostMapping(value = "/stockProduct/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("stockProductId") int stockProductId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = stockProductRelateService.doDelete(stockProductId);
        } catch (Exception e) {
            LOGGER.error("[StockProductRelateController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}