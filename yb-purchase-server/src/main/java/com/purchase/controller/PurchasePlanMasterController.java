package com.purchase.controller;

import com.purchase.entity.PurchasePlanMasterEntity;
import com.purchase.service.PurchasePlanMasterService;
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
public class PurchasePlanMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PurchasePlanMasterController.class);

    @Autowired
    private PurchasePlanMasterService purchasePlanMasterService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:16
     * @Param [request]
     **/
    @GetMapping(value = "/purchasePlan/findList")
    public ServiceResult<List<PurchasePlanMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<PurchasePlanMasterEntity>> result = new ServiceResult<List<PurchasePlanMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int purchasePlanId = ConvertUtil.toInt(request.getParameter("purchasePlanId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (purchasePlanId > 0) {
                params.put("purchasePlanId", purchasePlanId);
            }
            result = purchasePlanMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[PurchasePlanMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER,
                    "Find purchase plan list error.");
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
    @GetMapping(value = "/purchasePlan/findInfo")
    public ServiceResult<PurchasePlanMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<PurchasePlanMasterEntity> result = new ServiceResult<PurchasePlanMasterEntity>();
        Map<String, Object> params = null;
        int purchasePlanId = ConvertUtil.toInt(request.getParameter("purchasePlanId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (purchasePlanId > 0) {
                params.put("purchasePlanId", purchasePlanId);
            }
            result = purchasePlanMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[PurchasePlanMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find purchase plan error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:15
     * @Param [purchasePlanMasterEntity]
     **/
    @PostMapping(value = "/purchasePlan/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody PurchasePlanMasterEntity purchasePlanMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = purchasePlanMasterService.doInsert(purchasePlanMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[PurchasePlanMasterController][doInsert]：Insert occur exception", e);
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
     * @Param [purchasePlanMasterEntity]
     **/
    @PostMapping(value = "/purchasePlan/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody PurchasePlanMasterEntity purchasePlanMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = purchasePlanMasterService.doUpdate(purchasePlanMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[PurchasePlanMasterController][doUpdate]：Update occur exception", e);
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
     * @Param [purchasePlanId]
     **/
    @PostMapping(value = "/purchasePlan/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("purchasePlanId") int purchasePlanId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = purchasePlanMasterService.doDelete(purchasePlanId);
        } catch (Exception e) {
            LOGGER.error("[PurchasePlanMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}