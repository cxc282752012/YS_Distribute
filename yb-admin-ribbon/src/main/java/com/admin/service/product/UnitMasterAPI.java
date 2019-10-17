package com.admin.service.product;

import com.product.entity.UnitMasterEntity;
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
public interface UnitMasterAPI {

    /**
     * findList
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 11:06
     * @Param [params]
     **/
    @RequestMapping(value = "/public/unit/findList", method = RequestMethod.GET)
    HttpJsonResult<ConcurrentHashMap<String, Object>> findList(@RequestParam Map<String, Object> params)
            throws SystemException;

    /**
     * findInfo
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 11:07
     * @Param [params]
     **/
    @RequestMapping(value = "/public/unit/findInfo", method = RequestMethod.GET)
    HttpJsonResult<ConcurrentHashMap<String, Object>> findInfo(@RequestParam Map<String, Object> params)
            throws SystemException;

    /**
     * doInsert
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 11:08
     * @Param [unitMasterEntity]
     **/
    @RequestMapping(value = { "/public/unit/doInsert" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doInsert(@RequestBody UnitMasterEntity unitMasterEntity)
            throws SystemException;

    /**
     * doUpdate
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 11:08
     * @Param [unitMasterEntity]
     **/
    @RequestMapping(value = { "/public/unit/doUpdate" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doUpdate(@RequestBody UnitMasterEntity unitMasterEntity)
            throws SystemException;

    /**
     * doDelete
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 11:08
     * @Param [unitId]
     **/
    @RequestMapping(value = { "/public/unit/doDelete" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doDelete(@RequestParam("unitId") int unitId)
            throws SystemException;
}
