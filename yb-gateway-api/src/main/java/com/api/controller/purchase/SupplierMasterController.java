package com.api.controller.purchase;

import com.api.service.purchase.ISupplierMasterService;
import com.purchase.entity.SupplierMasterEntity;
import com.system.constants.BaseErrorConstants;
import com.system.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/purchase")
public class SupplierMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SupplierMasterController.class);

    @Autowired
    private ISupplierMasterService supplierMasterService;

    /**
     * @Author chenxichao
     * @Date 2019-05-22 11:19
     * @Param [request]
     **/
    @RequestMapping(value = { "/supplier/findList" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findList(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        List<SupplierMasterEntity> supplierMasterList = null;
        PagerInfo<?> pagerInfo = null;
        Map<String, Object> params = null;
        try {
            if (!StringUtil.isEmpty(request.getParameter("pageSize"))) {
                pagerInfo = BaseWebUtil.getPageInfoForPC(request);
            }
            params = new HashMap<String, Object>();
            if (pagerInfo != null) {
                params.put("pageSize", pagerInfo.getPageSize());
                params.put("pageIndex", pagerInfo.getPageIndex());
            }
            ServiceResult<List<SupplierMasterEntity>> supplierMasterResult = supplierMasterService.findList(params);
            pagerInfo = supplierMasterResult.getPager();
            if (supplierMasterResult.getSuccess() && supplierMasterResult.getResult() != null
                    && supplierMasterResult.getResult().size() > 0) {
                supplierMasterList = supplierMasterResult.getResult();
                returnTable.put("supplierMasterList", supplierMasterList);
            }
            returnTable.put("pagerInfo", pagerInfo);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Gateway API][SupplierMasterController][findList] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find supplierMasterList error.");
        }
        return result;
    }

    @RequestMapping(value = { "/supplier/findInfo" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findInfo(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        SupplierMasterEntity supplierMasterEntity = null;
        Map<String, Object> params = null;
        int supplierId = ConvertUtil.toInt(request.getParameter("supplierId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (supplierId > 0) {
                params.put("supplierId", supplierId);
            }
            ServiceResult<SupplierMasterEntity> supplierMasterResult = supplierMasterService.findInfo(params);
            if (supplierMasterResult.getSuccess() && supplierMasterResult.getResult() != null) {
                supplierMasterEntity = supplierMasterResult.getResult();
                returnTable.put("supplierMasterEntity", supplierMasterEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Gateway API][SupplierMasterController][findInfo] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find supplierMasterEntity error.");
        }
        return result;
    }

    @PostMapping(value = "/supplier/doInsert")
    public HttpJsonResult<Hashtable<String, Object>> doInsert(@RequestBody SupplierMasterEntity supplierMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> supplierMasterResult = supplierMasterService.doInsert(supplierMasterEntity);
            if (supplierMasterResult.getSuccess() && supplierMasterResult.getResult() != null) {
                returnTable.put("id", supplierMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Gateway API][SupplierMasterController][doInsert] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Insert SupplierMasterEntity error.");
        }
        return result;
    }

    @PostMapping(value = "/supplier/doUpdate")
    public HttpJsonResult<Hashtable<String, Object>> doUpdate(@RequestBody SupplierMasterEntity supplierMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> supplierMasterResult = supplierMasterService.doUpdate(supplierMasterEntity);
            if (supplierMasterResult.getSuccess() && supplierMasterResult.getResult() != null) {
                returnTable.put("id", supplierMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Gateway API][SupplierMasterController][doUpdate] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Update SupplierMasterEntity error.");
        }
        return result;
    }

    @PostMapping(value = "/supplier/doDelete")
    public HttpJsonResult<Hashtable<String, Object>> doDelete(@RequestParam int supplierId) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Boolean flag = false;
        try {
            ServiceResult<Boolean> supplierMasterResult = supplierMasterService.doDelete(supplierId);
            if (supplierMasterResult.getSuccess() && supplierMasterResult.getResult() != null) {
                flag = supplierMasterResult.getResult();
            }
            returnTable.put("deleteFlag", flag);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Gateway API][SupplierMasterController][doDelete] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Delete SupplierMasterEntity error.");
        }
        return result;
    }
}
