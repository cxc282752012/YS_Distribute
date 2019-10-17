package com.api.controller.product;

import com.api.service.product.ISizeMasterService;
import com.product.entity.SizeMasterEntity;
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
public class SizeMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SizeMasterController.class);

    @Autowired
    private ISizeMasterService sizeMasterService;

    /**
     * findList
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:52
     * @Param [request]
     **/
    @RequestMapping(value = { "/size/findList" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findList(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Integer storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        List<SizeMasterEntity> sizeMasterList = null;
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
            ServiceResult<List<SizeMasterEntity>> sizeMasterResult = sizeMasterService.findList(params);
            pagerInfo = sizeMasterResult.getPager();
            if (sizeMasterResult.getSuccess() && sizeMasterResult.getResult() != null
                    && sizeMasterResult.getResult().size() > 0) {
                sizeMasterList = sizeMasterResult.getResult();
                returnTable.put("sizeMasterList", sizeMasterList);
            }
            returnTable.put("pagerInfo", pagerInfo);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][sizeMasterController][findList] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find sizeMasterList error.");
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
    @RequestMapping(value = { "/size/findInfo" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findInfo(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        SizeMasterEntity sizeMasterEntity = null;
        Map<String, Object> params = null;
        int sizeId = ConvertUtil.toInt(request.getParameter("sizeId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (sizeId > 0) {
                params.put("sizeId", sizeId);
            }
            ServiceResult<SizeMasterEntity> sizeMasterResult = sizeMasterService.findInfo(params);
            if (sizeMasterResult.getSuccess() && sizeMasterResult.getResult() != null) {
                sizeMasterEntity = sizeMasterResult.getResult();
                returnTable.put("sizeMasterEntity", sizeMasterEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][sizeMasterController][findInfo] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find sizeMasterEntity error.");
        }
        return result;
    }

    /**
     * doInsert
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [sizeMasterEntity]
     **/
    @PostMapping(value = "/size/doInsert")
    public HttpJsonResult<Hashtable<String, Object>> doInsert(@RequestBody SizeMasterEntity sizeMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> sizeMasterResult = sizeMasterService.doInsert(sizeMasterEntity);
            if (sizeMasterResult.getSuccess() && sizeMasterResult.getResult() != null) {
                returnTable.put("id", sizeMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][SizeMasterController][doInsert] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Insert sizeMasterEntity error.");
        }
        return result;
    }

    /**
     * doUpdate
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [sizeMasterEntity]
     **/
    @PostMapping(value = "/size/doUpdate")
    public HttpJsonResult<Hashtable<String, Object>> doUpdate(@RequestBody SizeMasterEntity sizeMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> sizeMasterResult = sizeMasterService.doUpdate(sizeMasterEntity);
            if (sizeMasterResult.getSuccess() && sizeMasterResult.getResult() != null) {
                returnTable.put("id", sizeMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][SizeMasterController][doUpdate] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Update sizeMasterEntity error.");
        }
        return result;
    }

    /**
     * doDelete
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [sizeId]
     **/
    @PostMapping(value = "/size/doDelete")
    public HttpJsonResult<Hashtable<String, Object>> doDelete(@RequestParam int sizeId) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Boolean flag = false;
        try {
            ServiceResult<Boolean> sizeMasterResult = sizeMasterService.doDelete(sizeId);
            if (sizeMasterResult.getSuccess() && sizeMasterResult.getResult() != null) {
                flag = sizeMasterResult.getResult();
            }
            returnTable.put("deleteFlag", flag);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][SizeMasterController][doDelete] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Delete sizeMasterEntity error.");
        }
        return result;
    }
}
