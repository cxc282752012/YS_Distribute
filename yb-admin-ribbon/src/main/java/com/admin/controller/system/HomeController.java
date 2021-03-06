package com.admin.controller.system;

import com.admin.controller.BaseController;
import com.admin.service.product.ProductMasterAPI;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends BaseController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

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

    @RequestMapping(value = "/system/home.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(HttpServletRequest request, Model model) {
        return "/public/frame";
    }
}
