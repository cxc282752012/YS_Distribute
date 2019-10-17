package com.api.service;

import com.api.hystric.ProductMasterServiceHystrix;
import com.product.entity.ProductMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "yb-public-product", fallback = ProductMasterServiceHystrix.class)
public interface IProductMasterService {

    /**
     * user findList
     *
     * @param params
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = "/product/findList", method = RequestMethod.GET)
    ServiceResult<List<ProductMasterEntity>> findList(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * user findInfo
     *
     * @param params
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = "/product/findInfo", method = RequestMethod.GET)
    ServiceResult<ProductMasterEntity> findInfo(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * user doInsert
     *
     * @param productMasterEntity
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/product/doInsert" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doInsert(@RequestBody ProductMasterEntity productMasterEntity) throws SystemException;

    /**
     * user doUpdate
     *
     * @param productMasterEntity
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/product/doUpdate" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doUpdate(@RequestBody ProductMasterEntity productMasterEntity) throws SystemException;

    /**
     * user doDelete
     *
     * @param productId
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/product/doDelete" }, method = { RequestMethod.POST })
    ServiceResult<Boolean> doDelete(@RequestParam("productId") int productId) throws SystemException;
}
