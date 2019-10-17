package com.api.service.product;

import com.api.hystric.product.CategoryMasterServiceHystrix;
import com.product.entity.ColorMasterEntity;
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
public interface IColorMasterService {

    /**
     * findList
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:17
     * @Param [params]
     **/
    @RequestMapping(value = "/color/findList", method = RequestMethod.GET)
    ServiceResult<List<ColorMasterEntity>> findList(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * findInfo
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [params]
     **/
    @RequestMapping(value = "/color/findInfo", method = RequestMethod.GET)
    ServiceResult<ColorMasterEntity> findInfo(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * doInsert
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [colorMasterEntity]
     **/
    @RequestMapping(value = { "/color/doInsert" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doInsert(@RequestBody ColorMasterEntity colorMasterEntity) throws SystemException;

    /**
     * doUpdate
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [colorMasterEntity]
     **/
    @RequestMapping(value = { "/color/doUpdate" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doUpdate(@RequestBody ColorMasterEntity colorMasterEntity) throws SystemException;

    /**
     * doDelete
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 15:16
     * @Param [colorId]
     **/
    @RequestMapping(value = { "/color/doDelete" }, method = { RequestMethod.POST })
    ServiceResult<Boolean> doDelete(@RequestParam("colorId") int colorId) throws SystemException;
}
