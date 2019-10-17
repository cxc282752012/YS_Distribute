package com.admin.controller.system;

import com.admin.controller.BaseController;
import com.admin.service.product.ProductMasterAPI;
import com.google.common.collect.Maps;
import com.system.util.StringUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserMasterController extends BaseController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserMasterController.class);

    @Autowired
    private ProductMasterAPI productMasterAPI;

    @Override
    public String list(HttpServletRequest request, Model model) {
        return null;
    }

    @Override
    public ResponseEntity<?> findList(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> findInfo(HttpServletRequest request) {
        return null;
    }

    @Override
    public String detail(HttpServletRequest request, Model model) {
        return null;
    }

    @RequestMapping(value = "/user/login.html", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<?> login(HttpServletRequest request) {
        String userPhone = StringUtil.nullSafeString(request.getParameter("userPhone"));
        String password = StringUtil.nullSafeString(request.getParameter("password"));
        Map<String, Object> result = Maps.newHashMap();
        Map<String, Object> params = null;
        try {
            result.put("flag", 1);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Note Admin Ribbon][UserController][login] failed!", e);
        }
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }
}
