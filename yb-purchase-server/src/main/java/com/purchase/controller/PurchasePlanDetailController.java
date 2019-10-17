package com.purchase.controller;

import com.purchase.entity.PurchasePlanDetailEntity;
import com.purchase.service.PurchasePlanDetailService;
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
public class PurchasePlanDetailController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PurchasePlanDetailController.class);

    @Autowired
    private PurchasePlanDetailService purchasePlanDetailService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:16
     * @Param [request]
     **/
    @GetMapping(value = "/purchasePlanDetail/findList")
    public ServiceResult<List<PurchasePlanDetailEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<PurchasePlanDetailEntity>> result = new ServiceResult<List<PurchasePlanDetailEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int purchasePlanDetailId = ConvertUtil.toInt(request.getParameter("purchasePlanDetailId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (purchasePlanDetailId > 0) {
                params.put("purchasePlanDetailId", purchasePlanDetailId);
            }
            result = purchasePlanDetailService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[PurchasePlanDetailController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER,
                    "Find purchase plan detail  list error.");
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
    @GetMapping(value = "/purchasePlanDetail/findInfo")
    public ServiceResult<PurchasePlanDetailEntity> findInfo(HttpServletRequest request) {
        ServiceResult<PurchasePlanDetailEntity> result = new ServiceResult<PurchasePlanDetailEntity>();
        Map<String, Object> params = null;
        int purchasePlanDetailId = ConvertUtil.toInt(request.getParameter("purchasePlanDetailId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (purchasePlanDetailId > 0) {
                params.put("purchasePlanDetailId", purchasePlanDetailId);
            }
            result = purchasePlanDetailService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[PurchasePlanDetailController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find purchase plan detail  error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 15:15
     * @Param [purchasePlanDetailEntity]
     **/
    @PostMapping(value = "/purchasePlanDetail/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody PurchasePlanDetailEntity purchasePlanDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = purchasePlanDetailService.doInsert(purchasePlanDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[PurchasePlanDetailController][doInsert]：Insert occur exception", e);
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
     * @Param [purchasePlanDetailEntity]
     **/
    @PostMapping(value = "/purchasePlanDetail/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody PurchasePlanDetailEntity purchasePlanDetailEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = purchasePlanDetailService.doUpdate(purchasePlanDetailEntity);
        } catch (Exception e) {
            LOGGER.error("[PurchasePlanDetailController][doUpdate]：Update occur exception", e);
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
     * @Param [purchasePlanDetailId]
     **/
    @PostMapping(value = "/purchasePlanDetail/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("purchasePlanDetailId") int purchasePlanDetailId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = purchasePlanDetailService.doDelete(purchasePlanDetailId);
        } catch (Exception e) {
            LOGGER.error("[PurchasePlanDetailController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}