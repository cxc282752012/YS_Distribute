package com.admin.controller.product;

import com.admin.controller.BaseController;
import com.admin.service.product.UnitMasterAPI;
import com.google.common.collect.Maps;
import com.product.entity.UnitMasterEntity;
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
public class UnitController extends BaseController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UnitController.class);

    @Autowired
    private UnitMasterAPI unitMasterAPI;

    @Override
    public String list(HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/unit/findList.html", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<?> findList(HttpServletRequest request) {
        Integer storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        Map<String, Object> result = Maps.newHashMap();
        Map<String, Object> params = null;
        List<UnitMasterEntity> supplierMasterList = null;
        try {
            params = new HashMap<String, Object>();
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            HttpJsonResult<ConcurrentHashMap<String, Object>> unitMasterResult = unitMasterAPI.findList(params);
            supplierMasterList = unitMasterResult.getDataList("unitMasterList", UnitMasterEntity.class);
            if (unitMasterResult.getSuccess() && supplierMasterList != null && supplierMasterList.size() > 0) {
                result.put("unitMasterList", supplierMasterList);
            } else {
                result.put("info", unitMasterResult.getData().get("info"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Ys Admin Management][UnitController][findList] failed!", e);
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
