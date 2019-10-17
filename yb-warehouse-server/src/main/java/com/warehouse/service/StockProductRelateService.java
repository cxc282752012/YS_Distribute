package com.warehouse.service;

import com.github.pagehelper.PageHelper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import com.warehouse.entity.StockProductRelateEntity;
import com.warehouse.mapper.StockProductRelateMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("stockProductRelateService")
public class StockProductRelateService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StockProductRelateService.class);

    @Autowired
    private StockProductRelateMapper stockProductRelateMapper;

    /**
     * find list
     *
     * @param params
     * @param pagerInfo
     * @return
     */
    public ServiceResult<List<StockProductRelateEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.stockProductRelateMapper, "Property 'stockProductRelateMapper' is required.");
        ServiceResult<List<StockProductRelateEntity>> result = new ServiceResult<List<StockProductRelateEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.stockProductRelateMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StockProductRelateService][findList]：query findList occur exception", e);
        }
        return result;
    }

    public ServiceResult<StockProductRelateEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.stockProductRelateMapper, "Property 'stockProductRelateMapper' is required.");
        ServiceResult<StockProductRelateEntity> result = new ServiceResult<StockProductRelateEntity>();
        try {
            result.setResult(this.stockProductRelateMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StockProductRelateService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doInsert(StockProductRelateEntity stockProductRelateEntity) {
        Assert.notNull(this.stockProductRelateMapper, "Property 'stockProductRelateMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.stockProductRelateMapper.doInsert(stockProductRelateEntity);
            if (success > 0) {
                id = stockProductRelateEntity.getStockProductId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StockProductRelateService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Integer> doUpdate(StockProductRelateEntity stockProductRelateEntity) {
        Assert.notNull(this.stockProductRelateMapper, "Property 'stockProductRelateMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.stockProductRelateMapper.doUpdate(stockProductRelateEntity);
            if (success > 0) {
                id = stockProductRelateEntity.getStockProductId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StockProductRelateService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    public ServiceResult<Boolean> doDelete(int stockProductId) {
        Assert.notNull(this.stockProductRelateMapper, "Property 'stockProductRelateMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.stockProductRelateMapper.doDelete(stockProductId);
            if (id > 0) {
                flag = true;
            }
            result.setResult(flag);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StockProductRelateService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}