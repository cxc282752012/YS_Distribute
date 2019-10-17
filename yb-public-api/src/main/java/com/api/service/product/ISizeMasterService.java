package com.api.service.product;

import com.api.hystric.product.CategoryMasterServiceHystrix;
import com.product.entity.SizeMasterEntity;
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
public interface ISizeMasterService {

    /**
     * findList
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:17
     * @Param [params]
     **/
    @RequestMapping(value = "/size/findList", method = RequestMethod.GET)
    ServiceResult<List<SizeMasterEntity>> findList(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * findInfo
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [params]
     **/
    @RequestMapping(value = "/size/findInfo", method = RequestMethod.GET)
    ServiceResult<SizeMasterEntity> findInfo(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * doInsert
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [sizeMasterEntity]
     **/
    @RequestMapping(value = { "/size/doInsert" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doInsert(@RequestBody SizeMasterEntity sizeMasterEntity) throws SystemException;

    /**
     * doUpdate
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [sizeMasterEntity]
     **/
    @RequestMapping(value = { "/size/doUpdate" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doUpdate(@RequestBody SizeMasterEntity sizeMasterEntity) throws SystemException;

    /**
     * doDelete
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [sizeId]
     **/
    @RequestMapping(value = { "/size/doDelete" }, method = { RequestMethod.POST })
    ServiceResult<Boolean> doDelete(@RequestParam("sizeId") int sizeId) throws SystemException;
}
