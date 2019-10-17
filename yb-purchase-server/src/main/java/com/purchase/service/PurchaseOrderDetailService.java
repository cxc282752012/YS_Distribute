package com.purchase.service;

import com.github.pagehelper.PageHelper;
import com.purchase.entity.PurchaseOrderDetailEntity;
import com.purchase.mapper.PurchaseOrderDetailMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("purchaseOrderDetailService")
public class PurchaseOrderDetailService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PurchaseOrderDetailService.class);

    @Autowired
    private PurchaseOrderDetailMapper purchaseOrderDetailMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:53
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<PurchaseOrderDetailEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.purchaseOrderDetailMapper, "Property 'purchaseOrderDetailMapper' is required.");
        ServiceResult<List<PurchaseOrderDetailEntity>> result = new ServiceResult<List<PurchaseOrderDetailEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.purchaseOrderDetailMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchaseOrderDetailService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:53
     * @Param [params]
     **/
    public ServiceResult<PurchaseOrderDetailEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.purchaseOrderDetailMapper, "Property 'purchaseOrderDetailMapper' is required.");
        ServiceResult<PurchaseOrderDetailEntity> result = new ServiceResult<PurchaseOrderDetailEntity>();
        try {
            result.setResult(this.purchaseOrderDetailMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchaseOrderDetailService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:54
     * @Param [purchaseOrderDetailEntity]
     **/
    public ServiceResult<Integer> doInsert(PurchaseOrderDetailEntity purchaseOrderDetailEntity) {
        Assert.notNull(this.purchaseOrderDetailMapper, "Property 'purchaseOrderDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.purchaseOrderDetailMapper.doInsert(purchaseOrderDetailEntity);
            if (success > 0) {
                id = purchaseOrderDetailEntity.getPurchaseDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchaseOrderDetailService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:54
     * @Param [purchaseOrderDetailEntity]
     **/
    public ServiceResult<Integer> doUpdate(PurchaseOrderDetailEntity purchaseOrderDetailEntity) {
        Assert.notNull(this.purchaseOrderDetailMapper, "Property 'purchaseOrderDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.purchaseOrderDetailMapper.doUpdate(purchaseOrderDetailEntity);
            if (success > 0) {
                id = purchaseOrderDetailEntity.getPurchaseDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchaseOrderDetailService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:55
     * @Param [purchaseDetailId]
     **/
    public ServiceResult<Boolean> doDelete(int purchaseDetailId) {
        Assert.notNull(this.purchaseOrderDetailMapper, "Property 'purchaseOrderDetailMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.purchaseOrderDetailMapper.doDelete(purchaseDetailId);
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
            LOGGER.error("[PurchaseOrderDetailService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}