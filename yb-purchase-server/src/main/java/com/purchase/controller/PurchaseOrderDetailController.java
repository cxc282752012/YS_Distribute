package com.purchase.controller;

import com.purchase.entity.PurchaseOrderDetailEntity;
import com.purchase.service.PurchaseOrderDetailService;
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
public class PurchaseOrderDetailController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PurchaseOrderDetailController.class);

    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:16
     * @Param [request]
     **/
    @GetMapping(value = "/purchaseOrderDetail/findList")
    public ServiceResult<List<PurchaseOrderDetailEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<PurchaseOrderDetailEntity>> result = new ServiceResult<List<PurchaseOrderDetailEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int purchaseDetailId = ConvertUtil.toInt(request.getParameter("purchaseDetailId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (purchaseDetailId > 0) {
                params.put("purchaseDetailId", purchaseDetailId);
            }
            result = purchaseOrderDetailService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[PurchaseOrderDetailController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER,
                    "Find purchase order detail  list error.");
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
    @GetMapping(value = "/purchaseOrderDetail/findInfo")
    public ServiceResult<PurchaseOrderDetailEntity> findInfo(HttpServletRequest request) {
        ServiceResult<PurchaseOrderDetailEntity> result = new ServiceResult<PurchaseOrderDetailEntity>();
        Map<String, Object> params = null;
        int purchaseDetailId = ConvertUtil.toInt(request.getParameter("purchaseDetailId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (purchaseDetailId > 0) {
                params.put("purchaseDetailId", purchaseDetailId);
            }
            result = purchaseOrderDetailService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[PurchaseOrderDetailController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find purchase order detail  error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:15
     * @Param [purchaseOrderDetailEntity]
     **/
    @PostMapping(value = "/purchaseOrderDetail/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody PurchaseOrderDetailEntity purchaseOrderDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = purchaseOrderDetailService.doInsert(purchaseOrderDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[PurchaseOrderDetailController][doInsert]：Insert occur exception", e);
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
     * @Param [purchaseOrderDetailEntity]
     **/
    @PostMapping(value = "/purchaseOrderDetail/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody PurchaseOrderDetailEntity purchaseOrderDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = purchaseOrderDetailService.doUpdate(purchaseOrderDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[PurchaseOrderDetailController][doUpdate]：Update occur exception", e);
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
     * @Param [purchaseDetailId]
     **/
    @PostMapping(value = "/purchaseOrderDetail/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("purchaseDetailId") int purchaseDetailId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = purchaseOrderDetailService.doDelete(purchaseDetailId);
        } catch (Exception e) {
            LOGGER.error("[PurchaseOrderDetailController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}