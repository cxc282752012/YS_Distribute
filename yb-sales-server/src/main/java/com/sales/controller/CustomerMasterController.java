package com.sales.controller;

import com.sales.entity.CustomerMasterEntity;
import com.sales.service.CustomerMasterService;
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
public class CustomerMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomerMasterController.class);

    @Autowired
    private CustomerMasterService customerMasterService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 10:30
     * @Param [request]
     **/
    @GetMapping(value = "/customer/findList")
    public ServiceResult<List<CustomerMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<CustomerMasterEntity>> result = new ServiceResult<List<CustomerMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int customerId = ConvertUtil.toInt(request.getParameter("customerId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (customerId > 0) {
                params.put("customerId", customerId);
            }
            result = customerMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[CustomerMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find customer list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/customer/findInfo")
    public ServiceResult<CustomerMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<CustomerMasterEntity> result = new ServiceResult<CustomerMasterEntity>();
        Map<String, Object> params = null;
        int customerId = ConvertUtil.toInt(request.getParameter("customerId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (customerId > 0) {
                params.put("customerId", customerId);
            }
            result = customerMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[CustomerMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find customer error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @param customerMasterEntity
     * @return
     */
    @PostMapping(value = "/customer/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody CustomerMasterEntity customerMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = customerMasterService.doInsert(customerMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[CustomerMasterController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @param customerMasterEntity
     * @return
     */
    @PostMapping(value = "/customer/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody CustomerMasterEntity customerMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = customerMasterService.doUpdate(customerMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[CustomerMasterController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @param customerId
     * @return
     */
    @PostMapping(value = "/customer/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("customerId") int customerId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = customerMasterService.doDelete(customerId);
        } catch (Exception e) {
            LOGGER.error("[CustomerMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}