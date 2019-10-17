package com.api.service.product;

import com.api.hystric.product.CategoryMasterServiceHystrix;
import com.product.entity.UnitMasterEntity;
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
public interface IUnitMasterService {

    /**
     * find List
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:31
     * @Param [params]
     **/
    @RequestMapping(value = "/unit/findList", method = RequestMethod.GET)
    ServiceResult<List<UnitMasterEntity>> findList(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * findInfo
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:31
     * @Param [params]
     **/
    @RequestMapping(value = "/unit/findInfo", method = RequestMethod.GET)
    ServiceResult<UnitMasterEntity> findInfo(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * do insert
     *
     * @Author chenxichao
     * @Description
     * @Date 2019-05-07 10:29
     * @Param categoryMasterEntity
     **/
    @RequestMapping(value = { "/unit/doInsert" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doInsert(@RequestBody UnitMasterEntity unitMasterEntity) throws SystemException;

    /**
     * user doUpdate
     *
     * @param unitMasterEntity
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/unit/doUpdate" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doUpdate(@RequestBody UnitMasterEntity unitMasterEntity) throws SystemException;

    /**
     * doDelete
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:40
     * @Param [unitId]
     **/
    @RequestMapping(value = { "/unit/doDelete" }, method = { RequestMethod.POST })
    ServiceResult<Boolean> doDelete(@RequestParam("unitId") int unitId) throws SystemException;
}
