package com.sales.controller;

import com.sales.entity.CustomerLevelEntity;
import com.sales.service.CustomerLevelService;
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
public class CustomerLevelController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomerLevelController.class);

    @Autowired
    private CustomerLevelService customerLevelService;

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:18
     * @Param [request]
     **/
    @GetMapping(value = "/customerLevel/findList")
    public ServiceResult<List<CustomerLevelEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<CustomerLevelEntity>> result = new ServiceResult<List<CustomerLevelEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int customerLevelId = ConvertUtil.toInt(request.getParameter("customerLevelId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (customerLevelId > 0) {
                params.put("customerLevelId", customerLevelId);
            }
            result = customerLevelService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[CustomerLevelController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find customerLevel list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [request]
     **/
    @GetMapping(value = "/customerLevel/findInfo")
    public ServiceResult<CustomerLevelEntity> findInfo(HttpServletRequest request) {
        ServiceResult<CustomerLevelEntity> result = new ServiceResult<CustomerLevelEntity>();
        Map<String, Object> params = null;
        int customerLevelId = ConvertUtil.toInt(request.getParameter("customerLevelId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (customerLevelId > 0) {
                params.put("customerLevelId", customerLevelId);
            }
            result = customerLevelService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[CustomerLevelController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find customerLevel error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [customerLevelEntity]
     **/
    @PostMapping(value = "/customerLevel/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody CustomerLevelEntity customerLevelEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = customerLevelService.doInsert(customerLevelEntity);
        } catch (Exception e) {
            LOGGER.error("[CustomerLevelController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [customerLevelEntity]
     **/
    @PostMapping(value = "/customerLevel/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody CustomerLevelEntity customerLevelEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = customerLevelService.doUpdate(customerLevelEntity);
        } catch (Exception e) {
            LOGGER.error("[CustomerLevelController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-20 17:19
     * @Param [customerLevelId]
     **/
    @PostMapping(value = "/customerLevel/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("customerLevelId") int customerLevelId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = customerLevelService.doDelete(customerLevelId);
        } catch (Exception e) {
            LOGGER.error("[CustomerLevelController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}