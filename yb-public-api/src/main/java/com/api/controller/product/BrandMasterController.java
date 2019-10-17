package com.api.controller.product;

import com.api.service.product.IBrandMasterService;
import com.product.entity.BrandMasterEntity;
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
public class BrandMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BrandMasterController.class);

    @Autowired
    private IBrandMasterService brandMasterService;

    /**
     * findList
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:52
     * @Param [request]
     **/
    @RequestMapping(value = { "/brand/findList" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findList(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Integer storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        List<BrandMasterEntity> brandMasterList = null;
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
            ServiceResult<List<BrandMasterEntity>> brandMasterResult = brandMasterService.findList(params);
            pagerInfo = brandMasterResult.getPager();
            if (brandMasterResult.getSuccess() && brandMasterResult.getResult() != null
                    && brandMasterResult.getResult().size() > 0) {
                brandMasterList = brandMasterResult.getResult();
                returnTable.put("brandMasterList", brandMasterList);
            }
            returnTable.put("pagerInfo", pagerInfo);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][BrandMasterController][findList] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find brandMasterList error.");
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
    @RequestMapping(value = { "/brand/findInfo" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findInfo(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        BrandMasterEntity brandMasterEntity = null;
        Map<String, Object> params = null;
        int brandId = ConvertUtil.toInt(request.getParameter("brandId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (brandId > 0) {
                params.put("brandId", brandId);
            }
            ServiceResult<BrandMasterEntity> brandMasterResult = brandMasterService.findInfo(params);
            if (brandMasterResult.getSuccess() && brandMasterResult.getResult() != null) {
                brandMasterEntity = brandMasterResult.getResult();
                returnTable.put("brandMasterEntity", brandMasterEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][BrandMasterController][findInfo] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find brandMasterEntity error.");
        }
        return result;
    }

    /**
     * doInsert
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [brandMasterEntity]
     **/
    @PostMapping(value = "/brand/doInsert")
    public HttpJsonResult<Hashtable<String, Object>> doInsert(@RequestBody BrandMasterEntity brandMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> brandMasterResult = brandMasterService.doInsert(brandMasterEntity);
            if (brandMasterResult.getSuccess() && brandMasterResult.getResult() != null) {
                returnTable.put("id", brandMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][BrandMasterController][doInsert] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Insert brandMasterEntity error.");
        }
        return result;
    }

    /**
     * doUpdate
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [brandMasterEntity]
     **/
    @PostMapping(value = "/brand/doUpdate")
    public HttpJsonResult<Hashtable<String, Object>> doUpdate(@RequestBody BrandMasterEntity brandMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> brandMasterResult = brandMasterService.doUpdate(brandMasterEntity);
            if (brandMasterResult.getSuccess() && brandMasterResult.getResult() != null) {
                returnTable.put("id", brandMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][BrandMasterController][doUpdate] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Update brandMasterEntity error.");
        }
        return result;
    }

    /**
     * doDelete
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [brandId]
     **/
    @PostMapping(value = "/brand/doDelete")
    public HttpJsonResult<Hashtable<String, Object>> doDelete(@RequestParam int brandId) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Boolean flag = false;
        try {
            ServiceResult<Boolean> brandMasterResult = brandMasterService.doDelete(brandId);
            if (brandMasterResult.getSuccess() && brandMasterResult.getResult() != null) {
                flag = brandMasterResult.getResult();
            }
            returnTable.put("deleteFlag", flag);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][BrandMasterController][doDelete] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Delete brandMasterEntity error.");
        }
        return result;
    }
}
