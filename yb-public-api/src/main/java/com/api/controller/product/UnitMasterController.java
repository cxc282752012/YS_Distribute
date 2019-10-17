package com.api.controller.product;

import com.api.service.product.IUnitMasterService;
import com.product.entity.UnitMasterEntity;
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
@RequestMapping("/public")
public class UnitMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UnitMasterController.class);

    @Autowired
    private IUnitMasterService unitMasterService;

    /**
     * findList
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:52
     * @Param [request]
     **/
    @RequestMapping(value = { "/unit/findList" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findList(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Integer storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        List<UnitMasterEntity> unitMasterList = null;
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
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            ServiceResult<List<UnitMasterEntity>> unitMasterResult = unitMasterService.findList(params);
            pagerInfo = unitMasterResult.getPager();
            if (unitMasterResult.getSuccess() && unitMasterResult.getResult() != null
                    && unitMasterResult.getResult().size() > 0) {
                unitMasterList = unitMasterResult.getResult();
                returnTable.put("unitMasterList", unitMasterList);
            }
            returnTable.put("pagerInfo", pagerInfo);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][UnitMasterController][findList] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find unitMasterList error.");
        }
        return result;
    }

    /**
     * findInfo
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [request]
     **/
    @RequestMapping(value = { "/unit/findInfo" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findInfo(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        UnitMasterEntity unitMasterEntity = null;
        Map<String, Object> params = null;
        int unitId = ConvertUtil.toInt(request.getParameter("unitId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (unitId > 0) {
                params.put("unitId", unitId);
            }
            ServiceResult<UnitMasterEntity> unitMasterResult = unitMasterService.findInfo(params);
            if (unitMasterResult.getSuccess() && unitMasterResult.getResult() != null) {
                unitMasterEntity = unitMasterResult.getResult();
                returnTable.put("unitMasterEntity", unitMasterEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][UnitMasterController][findInfo] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find unitMasterEntity error.");
        }
        return result;
    }

    /**
     * doInsert
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [unitMasterEntity]
     **/
    @PostMapping(value = "/unit/doInsert")
    public HttpJsonResult<Hashtable<String, Object>> doInsert(@RequestBody UnitMasterEntity unitMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> unitMasterResult = unitMasterService.doInsert(unitMasterEntity);
            if (unitMasterResult.getSuccess() && unitMasterResult.getResult() != null) {
                returnTable.put("id", unitMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][UnitMasterController][doInsert] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Insert unitMasterEntity error.");
        }
        return result;
    }

    /**
     * doUpdate
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [unitMasterEntity]
     **/
    @PostMapping(value = "/unit/doUpdate")
    public HttpJsonResult<Hashtable<String, Object>> doUpdate(@RequestBody UnitMasterEntity unitMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> unitMasterResult = unitMasterService.doUpdate(unitMasterEntity);
            if (unitMasterResult.getSuccess() && unitMasterResult.getResult() != null) {
                returnTable.put("id", unitMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][UnitMasterController][doUpdate] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Update unitMasterEntity error.");
        }
        return result;
    }

    /**
     * doDelete
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [unitId]
     **/
    @PostMapping(value = "/unit/doDelete")
    public HttpJsonResult<Hashtable<String, Object>> doDelete(@RequestParam int unitId) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Boolean flag = false;
        try {
            ServiceResult<Boolean> unitMasterResult = unitMasterService.doDelete(unitId);
            if (unitMasterResult.getSuccess() && unitMasterResult.getResult() != null) {
                flag = unitMasterResult.getResult();
            }
            returnTable.put("deleteFlag", flag);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][UnitMasterController][doDelete] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Delete unitMasterEntity error.");
        }
        return result;
    }
}
