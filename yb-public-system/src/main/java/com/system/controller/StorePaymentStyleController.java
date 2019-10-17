package com.system.controller;

import com.system.constants.BaseErrorConstants;
import com.system.entity.StorePaymentStyleEntity;
import com.system.service.StorePaymentStyleService;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StorePaymentStyleController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StorePaymentStyleController.class);

    @Autowired
    private StorePaymentStyleService storePaymentStyleService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:38
     * @Param [request]
     **/
    @GetMapping(value = "/storePaymentStyle/findList")
    public ServiceResult<List<StorePaymentStyleEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<StorePaymentStyleEntity>> result = new ServiceResult<List<StorePaymentStyleEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int paymentStyleId = ConvertUtil.toInt(request.getParameter("paymentStyleId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (paymentStyleId > 0) {
                params.put("paymentStyleId", paymentStyleId);
            }
            result = storePaymentStyleService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[StorePaymentStyleController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find store payment style list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:38
     * @Param [request]
     **/
    @GetMapping(value = "/storePaymentStyle/findInfo")
    public ServiceResult<StorePaymentStyleEntity> findInfo(HttpServletRequest request) {
        ServiceResult<StorePaymentStyleEntity> result = new ServiceResult<StorePaymentStyleEntity>();
        Map<String, Object> params = null;
        int paymentStyleId = ConvertUtil.toInt(request.getParameter("paymentStyleId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (paymentStyleId > 0) {
                params.put("paymentStyleId", paymentStyleId);
            }
            result = storePaymentStyleService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[StorePaymentStyleController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find store payment style error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:38
     * @Param [storePaymentStyleEntity]
     **/
    @PostMapping(value = "/storePaymentStyle/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody StorePaymentStyleEntity storePaymentStyleEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = storePaymentStyleService.doInsert(storePaymentStyleEntity);
        } catch (Exception e) {
            LOGGER.error("[StorePaymentStyleController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:39
     * @Param [storePaymentStyleEntity]
     **/
    @PostMapping(value = "/storePaymentStyle/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody StorePaymentStyleEntity storePaymentStyleEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = storePaymentStyleService.doUpdate(storePaymentStyleEntity);
        } catch (Exception e) {
            LOGGER.error("[StorePaymentStyleController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:39
     * @Param [paymentStyleId]
     **/
    @PostMapping(value = "/storePaymentStyle/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("storePaymentStyleId") int paymentStyleId) {
        ServiceResult<Boolean> result = new ServiceResult<>();
        try {
           result = storePaymentStyleService.doDelete(paymentStyleId);
        } catch (Exception e) {
            LOGGER.error("[StoreMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}