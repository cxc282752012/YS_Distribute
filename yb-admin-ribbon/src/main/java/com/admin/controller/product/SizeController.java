package com.admin.controller.product;

import com.admin.controller.BaseController;
import com.admin.service.product.SizeMasterAPI;
import com.google.common.collect.Maps;
import com.product.entity.SizeMasterEntity;
import com.system.util.ConvertUtil;
import com.system.util.HttpJsonResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class SizeController extends BaseController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SizeController.class);

    @Autowired
    private SizeMasterAPI sizeMasterAPI;

    @Override
    public String list(HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/size/findList.html", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<?> findList(HttpServletRequest request) {
        Integer storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        Map<String, Object> result = Maps.newHashMap();
        Map<String, Object> params = null;
        List<SizeMasterEntity> supplierMasterList = null;
        try {
            params = new HashMap<String, Object>();
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            HttpJsonResult<ConcurrentHashMap<String, Object>> sizeMasterResult = sizeMasterAPI.findList(params);
            supplierMasterList = sizeMasterResult.getDataList("sizeMasterList", SizeMasterEntity.class);
            if (sizeMasterResult.getSuccess() && supplierMasterList != null && supplierMasterList.size() > 0) {
                result.put("sizeMasterList", supplierMasterList);
            } else {
                result.put("info", sizeMasterResult.getData().get("info"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Ys Admin Management][SizeController][findList] failed!", e);
        }
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findInfo(HttpServletRequest request) {
        return null;
    }

    @Override
    public String detail(HttpServletRequest request, Model model) {
        return null;
    }

}
