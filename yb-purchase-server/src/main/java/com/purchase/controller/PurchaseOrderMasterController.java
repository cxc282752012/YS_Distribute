package com.purchase.controller;

import com.purchase.entity.PurchaseOrderMasterEntity;
import com.purchase.service.PurchaseOrderMasterService;
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
public class PurchaseOrderMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PurchaseOrderMasterController.class);

    @Autowired
    private PurchaseOrderMasterService purchaseOrderMasterService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:16
     * @Param [request]
     **/
    @GetMapping(value = "/purchaseOrder/findList")
    public ServiceResult<List<PurchaseOrderMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<PurchaseOrderMasterEntity>> result = new ServiceResult<List<PurchaseOrderMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int purchaseId = ConvertUtil.toInt(request.getParameter("purchaseId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (purchaseId > 0) {
                params.put("purchaseId", purchaseId);
            }
            result = purchaseOrderMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[PurchaseOrderMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER,
                    "Find purchase order list error.");
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:16
     * @Param [request]
     **/
    @GetMapping(value = "/purchaseOrder/findInfo")
    public ServiceResult<PurchaseOrderMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<PurchaseOrderMasterEntity> result = new ServiceResult<PurchaseOrderMasterEntity>();
        Map<String, Object> params = null;
        int purchaseId = ConvertUtil.toInt(request.getParameter("purchaseId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (purchaseId > 0) {
                params.put("purchaseId", purchaseId);
            }
            result = purchaseOrderMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[PurchaseOrderMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find purchase order error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:15
     * @Param [purchaseOrderMasterEntity]
     **/
    @PostMapping(value = "/purchaseOrder/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody PurchaseOrderMasterEntity purchaseOrderMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = purchaseOrderMasterService.doInsert(purchaseOrderMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[PurchaseOrderMasterController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:14
     * @Param [purchaseOrderMasterEntity]
     **/
    @PostMapping(value = "/purchaseOrder/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody PurchaseOrderMasterEntity purchaseOrderMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = purchaseOrderMasterService.doUpdate(purchaseOrderMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[PurchaseOrderMasterController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:14
     * @Param [purchaseId]
     **/
    @PostMapping(value = "/purchaseOrder/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("purchaseId") int purchaseId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = purchaseOrderMasterService.doDelete(purchaseId);
        } catch (Exception e) {
            LOGGER.error("[PurchaseOrderMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}