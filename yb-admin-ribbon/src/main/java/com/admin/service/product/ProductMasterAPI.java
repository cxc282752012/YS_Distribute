package com.admin.service.product;

import com.product.entity.ProductMasterEntity;
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
public interface ProductMasterAPI {

    /**
     * product findList
     *
     * @param params
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = "/public/product/findList", method = RequestMethod.GET)
    HttpJsonResult<ConcurrentHashMap<String, Object>> findList(@RequestParam Map<String, Object> params)
            throws SystemException;

    /**
     * product findInfo
     *
     * @param params
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = "/public/product/findInfo", method = RequestMethod.GET)
    HttpJsonResult<ConcurrentHashMap<String, Object>> findInfo(@RequestParam Map<String, Object> params)
            throws SystemException;

    /**
     * product doInsert
     *
     * @param productMasterEntity
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/public/product/doInsert" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doInsert(@RequestBody ProductMasterEntity productMasterEntity)
            throws SystemException;

    /**
     * product doUpdate
     *
     * @param productMasterEntity
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/public/product/doUpdate" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doUpdate(@RequestBody ProductMasterEntity productMasterEntity)
            throws SystemException;

    /**
     * product doDelete
     *
     * @param productId
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/public/product/doDelete" }, method = { RequestMethod.POST })
    HttpJsonResult<ConcurrentHashMap<String, Object>> doDelete(@RequestParam("productId") int productId)
            throws SystemException;
}
