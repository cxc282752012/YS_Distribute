package com.api.controller.product;

import com.api.service.product.IColorMasterService;
import com.product.entity.ColorMasterEntity;
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
public class ColorMasterController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ColorMasterController.class);

    @Autowired
    private IColorMasterService colorMasterService;

    /**
     * findList
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:52
     * @Param [request]
     **/
    @RequestMapping(value = { "/color/findList" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findList(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Integer storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        List<ColorMasterEntity> colorMasterList = null;
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
            ServiceResult<List<ColorMasterEntity>> colorMasterResult = colorMasterService.findList(params);
            pagerInfo = colorMasterResult.getPager();
            if (colorMasterResult.getSuccess() && colorMasterResult.getResult() != null
                    && colorMasterResult.getResult().size() > 0) {
                colorMasterList = colorMasterResult.getResult();
                returnTable.put("colorMasterList", colorMasterList);
            }
            returnTable.put("pagerInfo", pagerInfo);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][ColorMasterController][findList] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find colorMasterList error.");
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
    @RequestMapping(value = { "/color/findInfo" }, method = { RequestMethod.GET, RequestMethod.POST })
    public HttpJsonResult<Hashtable<String, Object>> findInfo(HttpServletRequest request) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        ColorMasterEntity colorMasterEntity = null;
        Map<String, Object> params = null;
        int colorId = ConvertUtil.toInt(request.getParameter("colorId"), 0);
        try {
            params = new HashMap<String, Object>();
            if (colorId > 0) {
                params.put("colorId", colorId);
            }
            ServiceResult<ColorMasterEntity> colorMasterResult = colorMasterService.findInfo(params);
            if (colorMasterResult.getSuccess() && colorMasterResult.getResult() != null) {
                colorMasterEntity = colorMasterResult.getResult();
                returnTable.put("colorMasterEntity", colorMasterEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][ColorMasterController][findInfo] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Find colorMasterEntity error.");
        }
        return result;
    }

    /**
     * doInsert
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [colorMasterEntity]
     **/
    @PostMapping(value = "/color/doInsert")
    public HttpJsonResult<Hashtable<String, Object>> doInsert(@RequestBody ColorMasterEntity colorMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> colorMasterResult = colorMasterService.doInsert(colorMasterEntity);
            if (colorMasterResult.getSuccess() && colorMasterResult.getResult() != null) {
                returnTable.put("id", colorMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][ColorMasterController][doInsert] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Insert colorMasterEntity error.");
        }
        return result;
    }

    /**
     * doUpdate
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [colorMasterEntity]
     **/
    @PostMapping(value = "/color/doUpdate")
    public HttpJsonResult<Hashtable<String, Object>> doUpdate(@RequestBody ColorMasterEntity colorMasterEntity) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        try {
            ServiceResult<Integer> colorMasterResult = colorMasterService.doUpdate(colorMasterEntity);
            if (colorMasterResult.getSuccess() && colorMasterResult.getResult() != null) {
                returnTable.put("id", colorMasterResult.getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][ColorMasterController][doUpdate] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Update colorMasterEntity error.");
        }
        return result;
    }

    /**
     * doDelete
     *
     * @Author qinwanli
     * @Description
     * @Date 2019/5/24 10:53
     * @Param [colorId]
     **/
    @PostMapping(value = "/color/doDelete")
    public HttpJsonResult<Hashtable<String, Object>> doDelete(@RequestParam int colorId) {
        Hashtable<String, Object> returnTable = new Hashtable<String, Object>();
        HttpJsonResult<Hashtable<String, Object>> result = new HttpJsonResult<Hashtable<String, Object>>(returnTable);
        Boolean flag = false;
        try {
            ServiceResult<Boolean> colorMasterResult = colorMasterService.doDelete(colorId);
            if (colorMasterResult.getSuccess() && colorMasterResult.getResult() != null) {
                flag = colorMasterResult.getResult();
            }
            returnTable.put("deleteFlag", flag);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Yb Public API][ColorMasterController][doDelete] failed!", e);
            result.setError(BaseErrorConstants.ERROR_CODE_API_CONTROLLER, "Delete ColorMasterEntity error.");
        }
        return result;
    }
}
