package com.admin.service.product;

import com.product.entity.BrandMasterEntity;
import com.system.util.HttpJsonResult;
import org.omg.CORBA.SystemException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@FeignClient(value = "yb-public-api")
public interface BrandMasterAPI {

    /**
     * findList
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:38
     * @Param [params]
     **/
    @RequestMapping(value = "/public/brand/findList", method = RequestMethod.GET)
    HttpJsonResult<ConcurrentHashMap<String, Object>> findList(@RequestParam Map<String, Object> params)
            throws SystemException;

    /**
     * findInfo
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:39
     * @Param [params]
     **/
    @RequestMapping(value = "/public/brand/findInfo", method = RequestMethod.GET)
    HttpJsonResult<ConcurrentHashMap<String, Object>> findInfo(@RequestParam Map<String, Object> params)
            throws SystemException;

    /**
     * doInsert
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:39
     * @Param [brandMasterEntity]
     **/
    @RequestMapping(value = { "/public/brand/doInsert" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doInsert(@RequestBody BrandMasterEntity brandMasterEntity)
            throws SystemException;

    /**
     * doUpdate
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:39
     * @Param [brandMasterEntity]
     **/
    @RequestMapping(value = { "/public/brand/doUpdate" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doUpdate(@RequestBody BrandMasterEntity brandMasterEntity)
            throws SystemException;

    /**
     * doDelete
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:39
     * @Param [brandId]
     **/
    @RequestMapping(value = { "/public/brand/doDelete" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doDelete(@RequestParam("brandId") int brandId)
            throws SystemException;
}
