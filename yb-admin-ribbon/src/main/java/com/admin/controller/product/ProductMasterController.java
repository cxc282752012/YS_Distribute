package com.admin.controller.product;

import com.admin.controller.BaseController;
import com.admin.service.product.ProductMasterAPI;
import com.google.common.collect.Maps;
import com.product.entity.ProductDetailEntity;
import com.product.entity.ProductMasterEntity;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class ProductMasterController extends BaseController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductMasterController.class);

    @Autowired
    private ProductMasterAPI productMasterAPI;

    /**
     * 跳转到商品列表
     *
     * @Author chenxichao
     * @Date 2019-05-23 17:02
     * @Param [request, model]
     **/
    @RequestMapping(value = "/product/list.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String list(HttpServletRequest request, Model model) {
        return "/product/productList";
    }

    @RequestMapping(value = "/product/findList.html", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<?> findList(HttpServletRequest request) {
        Integer storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        int productId = ConvertUtil.toInt(request.getParameter("productId"), 0);
        String customCode = request.getParameter("customCode");
        Map<String, Object> result = Maps.newHashMap();
        Map<String, Object> params = null;
        List<ProductMasterEntity> productMasterList = null;
        try {
            params = new HashMap<String, Object>();
            if (storeId > 0) {
                params.put("storeId", storeId);
            }
            if (productId > 0) {
                params.put("productId", productId);
            }
            if (customCode != null) {
                params.put("customCode", customCode);
            }

            HttpJsonResult<ConcurrentHashMap<String, Object>> productMasterResult = productMasterAPI.findList(params);
            productMasterList = productMasterResult.getDataList("productMasterList", ProductMasterEntity.class);
            if (productMasterResult.getSuccess() && productMasterList != null && productMasterList.size() > 0) {
                result.put("productMasterList", productMasterList);
            } else {
                result.put("info", productMasterResult.getData().get("info"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Ys Admin Management][ProductMasterController][findList] failed!", e);
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

    @RequestMapping(value = "/product/doInsert.html", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<?> doInsert(HttpServletRequest request) {
        String customCode = request.getParameter("customCode");
        String productName = request.getParameter("productName");
        String seasonName = request.getParameter("seasonName");
        String productionTime = request.getParameter("productionTime");
        String isIntegral = ConvertUtil.toInt(request.getParameter("isIntegral"), 0) == 1 ? "Y" : "N";
        String isDiscount = ConvertUtil.toInt(request.getParameter("isDiscount"), 0) == 1 ? "Y" : "N";
        int categoryId = ConvertUtil.toInt(request.getParameter("categoryId"), 0);
        int storeId = ConvertUtil.toInt(request.getParameter("storeId"), 0);
        int supplieId = ConvertUtil.toInt(request.getParameter("supplieId"), 0);
        int unitId = ConvertUtil.toInt(request.getParameter("unitId"), 0);
        int productStatus = ConvertUtil.toInt(request.getParameter("productStatus"), 0);
        int colorId = ConvertUtil.toInt(request.getParameter("colorId"), 0);
        int sizeId = ConvertUtil.toInt(request.getParameter("sizeId"), 0);
        int brandId = ConvertUtil.toInt(request.getParameter("brandId"), 0);
        double purchasePrice = ConvertUtil.toDouble(request.getParameter("purchasePrice"), 0.00);
        double retailPrice = ConvertUtil.toDouble(request.getParameter("retailPrice"), 0.00);
        double memberPrice = ConvertUtil.toDouble(request.getParameter("memberPrice"), 0.00);
        double transferPrice = ConvertUtil.toDouble(request.getParameter("transferPrice"), 0.00);
        double websitePrice = ConvertUtil.toDouble(request.getParameter("websitePrice"), 0.00);
        double wholesalePrice = ConvertUtil.toDouble(request.getParameter("wholesalePrice"), 0.00);
        Map<String, Object> result = Maps.newHashMap();
        ProductMasterEntity params = null;
        int id;
        try {
            params = new ProductMasterEntity();
            // TODO: 2019/5/24  参数过滤
            List<ProductDetailEntity> productDetailList = new ArrayList<>();
            params.setProductDetailList(productDetailList);
            HttpJsonResult<ConcurrentHashMap<String, Object>> productMasterResult = productMasterAPI.doInsert(params);
            id = (int) productMasterResult.getData().getOrDefault("id", -1);
            if (productMasterResult.getSuccess() && id > 0) {
                result.put("id", id);
            } else {
                result.put("info", productMasterResult.getData().get("info"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("[Ys Admin Management][ProductMasterController][findList] failed!", e);
        }
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    /**
     * 跳转到编辑商品
     *
     * @Author chenxichao
     * @Date 2019-05-22 16:44
     * @Param [request, model]
     **/
    @RequestMapping(value = "/product/productEdit.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String productEdit(HttpServletRequest request, Model model) {
        return "/product/productEdit";
    }
}
