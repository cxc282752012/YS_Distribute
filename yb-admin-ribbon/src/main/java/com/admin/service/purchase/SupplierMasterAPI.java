package com.admin.service.purchase;

import com.purchase.entity.SupplierMasterEntity;
import com.system.util.HttpJsonResult;
import org.omg.CORBA.SystemException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@FeignClient(value = "yb-gateway-api")
public interface SupplierMasterAPI {

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-23 13:58
     * @Param [params]
     **/
    @RequestMapping(value = "/purchase/supplier/findList", method = RequestMethod.GET)
    HttpJsonResult<ConcurrentHashMap<String, Object>> findList(@RequestParam Map<String, Object> params)
            throws SystemException;

    /**
     * find info
     *
     * @Author chenxichao
     * @Date 2019-05-23 13:58
     * @Param [params]
     **/
    @RequestMapping(value = "/purchase/supplier/findInfo", method = RequestMethod.GET)
    HttpJsonResult<ConcurrentHashMap<String, Object>> findInfo(@RequestParam Map<String, Object> params)
            throws SystemException;

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-23 13:58
     * @Param [categoryMasterEntity]
     **/
    @RequestMapping(value = { "/purchase/supplier/doInsert" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doInsert(@RequestBody SupplierMasterEntity supplierMasterEntity)
            throws SystemException;

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-23 13:58
     * @Param [categoryMasterEntity]
     **/
    @RequestMapping(value = { "/purchase/supplier/doUpdate" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doUpdate(@RequestBody SupplierMasterEntity supplierMasterEntity)
            throws SystemException;

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-23 13:58
     * @Param [categoryId]
     **/
    @RequestMapping(value = { "/purchase/supplier/doDelete" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doDelete(@RequestParam("supplierId") int supplierId)
            throws SystemException;
}
