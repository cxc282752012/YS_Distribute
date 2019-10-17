package com.api.service.product;

import com.api.hystric.product.CategoryMasterServiceHystrix;
import com.product.entity.CategoryMasterEntity;
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
public interface ICategoryMasterService {

    /**
     * find list
     *
     * @Author chenxichao
     * @Description
     * @Date 09:16 2019-05-07
     * @Param [params]
     **/
    @RequestMapping(value = "/category/findList", method = RequestMethod.GET)
    ServiceResult<List<CategoryMasterEntity>> findList(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * find info
     *
     * @Author chenxichao
     * @Description
     * @Date 09:17 2019-05-07
     * @Param [params]
     **/
    @RequestMapping(value = "/category/findInfo", method = RequestMethod.GET)
    ServiceResult<CategoryMasterEntity> findInfo(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * do insert
     *
     * @Author chenxichao
     * @Description
     * @Date 2019-05-07 10:29
     * @Param [categoryMasterEntity]
     **/
    @RequestMapping(value = { "/category/doInsert" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doInsert(@RequestBody CategoryMasterEntity categoryMasterEntity) throws SystemException;

    /**
     * user doUpdate
     *
     * @param categoryMasterEntity
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/category/doUpdate" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doUpdate(@RequestBody CategoryMasterEntity categoryMasterEntity) throws SystemException;

    /**
     * user doDelete
     *
     * @param categoryId
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/category/doDelete" }, method = { RequestMethod.POST })
    ServiceResult<Boolean> doDelete(@RequestParam("categoryId") int categoryId) throws SystemException;
}
