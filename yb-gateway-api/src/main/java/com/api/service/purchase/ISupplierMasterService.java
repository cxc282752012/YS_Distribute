package com.api.service.purchase;

import com.api.hystric.purchase.SupplierMasterServiceHystrix;
import com.purchase.entity.SupplierMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "yb-purchase-server", fallback = SupplierMasterServiceHystrix.class)
public interface ISupplierMasterService {

    /**
     * find list
     *
     * @Author chenxichao
     * @Description
     * @Date 09:16 2019-05-07
     * @Param [params]
     **/
    @RequestMapping(value = "/supplier/findList", method = RequestMethod.GET)
    ServiceResult<List<SupplierMasterEntity>> findList(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * find info
     *
     * @Author chenxichao
     * @Description
     * @Date 09:17 2019-05-07
     * @Param [params]
     **/
    @RequestMapping(value = "/supplier/findInfo", method = RequestMethod.GET)
    ServiceResult<SupplierMasterEntity> findInfo(@RequestParam Map<String, Object> params) throws SystemException;

    /**
     * do insert
     *
     * @Author chenxichao
     * @Description
     * @Date 2019-05-07 10:29
     * @Param [supplierMasterEntity]
     **/
    @RequestMapping(value = { "/supplier/doInsert" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doInsert(@RequestBody SupplierMasterEntity supplierMasterEntity) throws SystemException;

    /**
     * user doUpdate
     *
     * @param supplierMasterEntity
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/supplier/doUpdate" }, method = { RequestMethod.POST })
    ServiceResult<Integer> doUpdate(@RequestBody SupplierMasterEntity supplierMasterEntity) throws SystemException;

    /**
     * user doDelete
     *
     * @param supplierId
     * @return
     * @throws SystemException
     * @Description
     * @author chen
     */
    @RequestMapping(value = { "/supplier/doDelete" }, method = { RequestMethod.POST })
    ServiceResult<Boolean> doDelete(@RequestParam("supplierId") int supplierId) throws SystemException;
}
