package com.admin.service.product;

import com.product.entity.CategoryMasterEntity;
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
public interface CategoryMasterAPI {

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-23 13:58
     * @Param [params]
     **/
    @RequestMapping(value = "/public/category/findList", method = RequestMethod.GET)
    HttpJsonResult<ConcurrentHashMap<String, Object>> findList(@RequestParam Map<String, Object> params)
            throws SystemException;

    /**
     * find info
     *
     * @Author chenxichao
     * @Date 2019-05-23 13:58
     * @Param [params]
     **/
    @RequestMapping(value = "/public/category/findInfo", method = RequestMethod.GET)
    HttpJsonResult<ConcurrentHashMap<String, Object>> findInfo(@RequestParam Map<String, Object> params)
            throws SystemException;

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-23 13:58
     * @Param [categoryMasterEntity]
     **/
    @RequestMapping(value = { "/public/category/doInsert" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doInsert(@RequestBody CategoryMasterEntity categoryMasterEntity)
            throws SystemException;

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-23 13:58
     * @Param [categoryMasterEntity]
     **/
    @RequestMapping(value = { "/public/category/doUpdate" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doUpdate(@RequestBody CategoryMasterEntity categoryMasterEntity)
            throws SystemException;

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-23 13:58
     * @Param [categoryId]
     **/
    @RequestMapping(value = { "/public/category/doDelete" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doDelete(@RequestParam("categoryId") int categoryId)
            throws SystemException;
}
