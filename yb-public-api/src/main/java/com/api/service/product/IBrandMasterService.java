package com.api.service.product;

import com.api.hystric.product.CategoryMasterServiceHystrix;
import com.product.entity.BrandMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "yb-public-product", fallback = CategoryMasterServiceHystrix.class)
public interface IBrandMasterService {

    /**
     * findList
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:17
     * @Param [params]
     **/
    @RequestMapping(value = "/brand/findList", method = RequestMethod.GET)
    ServiceResult<List<BrandMasterEntity>> findList(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * findInfo
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [params]
     **/
    @RequestMapping(value = "/brand/findInfo", method = RequestMethod.GET)
    ServiceResult<BrandMasterEntity> findInfo(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * doInsert
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [brandMasterEntity]
     **/
    @RequestMapping(value = { "/brand/doInsert" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doInsert(@RequestBody BrandMasterEntity brandMasterEntity) throws SystemException;

    /**
     * doUpdate
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [brandMasterEntity]
     **/
    @RequestMapping(value = { "/brand/doUpdate" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doUpdate(@RequestBody BrandMasterEntity brandMasterEntity) throws SystemException;

    /**
     * doDelete
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [brandId]
     **/
    @RequestMapping(value = { "/brand/doDelete" }, method = { RequestMethod.POST })
    ServiceResult<Boolean> doDelete(@RequestParam("brandId") int brandId) throws SystemException;
}
