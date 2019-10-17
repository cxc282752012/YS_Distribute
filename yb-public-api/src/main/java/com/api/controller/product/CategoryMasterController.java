package com.api.controller.product;

import com.api.service.product.ICategoryMasterService;
import com.product.entity.CategoryMasterEntity;
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
public class CategoryMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoryMasterController.class);

    @Autowired
    private ICategoryMasterService categoryMasterService;

    /**
     * @Author chenxichao
     * @Date 2019-05-22 11:19
     * @Param [request]
     **/
    @RequestMapping(value = { "/category/findList" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findList(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Integer storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        List<CategoryMasterEntity> categoryMasterList = null;
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
            ServiceResult<List<CategoryMasterEntity>> categoryMasterResult = categoryMasterService.findList(params);
            pagerInfo = categoryMasterResult.getPager();
            if (categoryMasterResult.getSuccess() && categoryMasterResult.getResult() != null
                    && categoryMasterResult.getResult().size() > 0) {
                categoryMasterList = categoryMasterResult.getResult();
                returnTable.put("categoryMasterList", categoryMasterList);
            }
            returnTable.put("pagerInfo", pagerInfo);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][CategoryMasterController][findList] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find categoryMasterList error.");
        }
        return result;
    }

    @RequestMapping(value = { "/category/findInfo" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findInfo(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        CategoryMasterEntity categoryMasterEntity = null;
        Map<String, Object> params = null;
        int categoryId = ConvertUtil.toInt(request.getParameter("categoryId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (categoryId > 0) {
                params.put("categoryId", categoryId);
            }
            ServiceResult<CategoryMasterEntity> categoryMasterResult = categoryMasterService.findInfo(params);
            if (categoryMasterResult.getSuccess() && categoryMasterResult.getResult() != null) {
                categoryMasterEntity = categoryMasterResult.getResult();
                returnTable.put("categoryMasterEntity", categoryMasterEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][CategoryMasterController][findInfo] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find categoryMasterEntity error.");
        }
        return result;
    }

    @PostMapping(value = "/category/doInsert")
    public HttpJsonResult<Hashtable<String, Object>> doInsert(@RequestBody CategoryMasterEntity categoryMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> categoryMasterResult = categoryMasterService.doInsert(categoryMasterEntity);
            if (categoryMasterResult.getSuccess() && categoryMasterResult.getResult() != null) {
                returnTable.put("id", categoryMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][CategoryMasterController][doInsert] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Insert categoryMasterEntity error.");
        }
        return result;
    }

    @PostMapping(value = "/category/doUpdate")
    public HttpJsonResult<Hashtable<String, Object>> doUpdate(@RequestBody CategoryMasterEntity categoryMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> categoryMasterResult = categoryMasterService.doUpdate(categoryMasterEntity);
            if (categoryMasterResult.getSuccess() && categoryMasterResult.getResult() != null) {
                returnTable.put("id", categoryMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][CategoryMasterController][doUpdate] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Update categoryMasterEntity error.");
        }
        return result;
    }

    @PostMapping(value = "/category/doDelete")
    public HttpJsonResult<Hashtable<String, Object>> doDelete(@RequestParam int categoryId) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Boolean flag = false;
        try {
            ServiceResult<Boolean> categoryMasterResult = categoryMasterService.doDelete(categoryId);
            if (categoryMasterResult.getSuccess() && categoryMasterResult.getResult() != null) {
                flag = categoryMasterResult.getResult();
            }
            returnTable.put("deleteFlag", flag);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][CategoryMasterController][doDelete] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Delete categoryMasterEntity error.");
        }
        return result;
    }
}
