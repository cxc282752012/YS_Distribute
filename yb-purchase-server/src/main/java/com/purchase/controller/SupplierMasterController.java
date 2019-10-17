package com.purchase.controller;

import com.purchase.entity.SupplierMasterEntity;
import com.purchase.service.SupplierMasterService;
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
public class SupplierMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SupplierMasterController.class);

    @Autowired
    private SupplierMasterService supplierMasterService;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 13:18
     * @Param [request]
     **/
    @GetMapping(value = "/supplier/findList")
    public ServiceResult<List<SupplierMasterEntity>> findList(HttpServletRequest request) {
        ServiceResult<List<SupplierMasterEntity>> result = new ServiceResult<List<SupplierMasterEntity>>();
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        int supplierId = ConvertUtil.toInt(request.getParameter("supplierId"), 0);
        int storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (supplierId > 0) {
                params.put("supplierId", supplierId);
            }
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            result = supplierMasterService.findList(params, pagerInfo);
        } catch (Exception e) {
            LOGGER.error("[SupplierMasterController][findList]：query findList occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user order list error.");
        }

        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 13:19
     * @Param [request]
     **/
    @GetMapping(value = "/supplier/findInfo")
    public ServiceResult<SupplierMasterEntity> findInfo(HttpServletRequest request) {
        ServiceResult<SupplierMasterEntity> result = new ServiceResult<SupplierMasterEntity>();
        Map<String, Object> params = null;
        int supplierId = ConvertUtil.toInt(request.getParameter("supplierId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (supplierId > 0) {
                params.put("supplierId", supplierId);
            }
            result = supplierMasterService.findInfo(params);
        } catch (Exception e) {
            LOGGER.error("[SupplierMasterController][findInfo]：query findInfo occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Find user order error.");
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 13:19
     * @Param [supplierMasterEntity]
     **/
    @PostMapping(value = "/supplier/doInsert")
    public ServiceResult<Integer> doInsert(@RequestBody SupplierMasterEntity supplierMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = supplierMasterService.doInsert(supplierMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[SupplierMasterController][doInsert]：Insert occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Insert error.");
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 13:19
     * @Param [supplierMasterEntity]
     **/
    @PostMapping(value = "/supplier/doUpdate")
    public ServiceResult<Integer> doUpdate(@RequestBody SupplierMasterEntity supplierMasterEntity) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result = supplierMasterService.doUpdate(supplierMasterEntity);
        } catch (Exception e) {
            LOGGER.error("[SupplierMasterController][doUpdate]：Update occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Update error.");
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 13:19
     * @Param [supplierId]
     **/
    @PostMapping(value = "/supplier/doDelete")
    public ServiceResult<Boolean> doDelete(@RequestParam("supplierId") int supplierId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result = supplierMasterService.doDelete(supplierId);
        } catch (Exception e) {
            LOGGER.error("[SupplierMasterController][doDelete]：Delete occur exception", e);
            result.setError(BaseErrorConstants.ERROR_CODE_SERVICE_CONTROLLER, "Delete error.");
        }
        return result;
    }

}